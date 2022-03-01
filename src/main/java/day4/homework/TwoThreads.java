package day4.homework;

import java.io.*;

public class TwoThreads {
    private static volatile boolean finished = false;
    public static void main(String[] args) throws IOException, InterruptedException {

        StringBuffer sb = new StringBuffer();
        Thread threadWrite = new Thread(){
            @Override
            public void run(){
                try{
                    String outputAddress = new String("/Users/lys/Documents/AntraJavaBatch/src/main/java/Day4/Homework/output.txt");
                    FileOutputStream out = new FileOutputStream(outputAddress);
                    while (sb.length()>0 || ! finished){
                        if (sb.length() == 0) continue;
                        synchronized (sb) {
                            if (sb.length()>0) {
                                out.write(sb.charAt(0));
                                sb.deleteCharAt(0);
                            }
                        }
                    }
                    out.close();
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        };

        Thread threadRead = new Thread() {
            @Override
            public void run() {
                try {
                    String inputAddress = new String("/Users/lys/Documents/AntraJavaBatch/src/main/java/Day4/Homework/input.txt");

                    FileInputStream in = new FileInputStream(inputAddress);

                    int c = 0;
                    c = in.read();
                    boolean startedNumberReading = false;
                    int tempNum = 0;
                    int result = 0;
                    boolean isPlusSign = true;
                    boolean empty = true;
                    while (c != -1) {
                        if (Character.isDigit(c)) {
                            empty = false;
                            if (!startedNumberReading) { // this digit is the first digit of a number
                                tempNum = Character.getNumericValue(c);
                                startedNumberReading = true;
                            } else {
                                tempNum = tempNum * 10 + Character.getNumericValue(c);
                            }
                        } else if (isPlus(c)) {
                            empty = false;
                            isPlusSign = true;
                        } else if (isMinus(c)) {
                            empty = false;
                            isPlusSign = false;
                        } else if (Character.isSpaceChar(c) || c == '\n' || c == '\r') {
                            if (startedNumberReading) { // this is the space just after a number
                                startedNumberReading = false;
                                result = (isPlusSign) ? result + tempNum : result - tempNum;
                                tempNum = 0;
                            }
                        }
                        if (c != '\n' && c != '\r') {
                        } else if (empty) {
                        } else {
                            sb.append(" = ");
                            sb.append(result);
                            result = 0;
                            empty = true;
                            isPlusSign = true;
                        }
                        sb.append((char) c);
                        c = in.read();
                    }
                    result = (isPlusSign) ? result + tempNum : result - tempNum;
                    sb.append(" = ");
                    sb.append(result);
                    in.close();
                    finished = true;
                } catch (IOException e) {
                    System.out.println("IOException.");
                }
            }
        };

        threadRead.start();
        threadWrite.start();
        threadRead.join();
        threadWrite.join();
        System.out.println(sb);

    }

    public static boolean isPlus(int c) {
        return (char) c == '+';
    }

    public static boolean isMinus(int c) {
        return (char) c == '-';
    }

}


