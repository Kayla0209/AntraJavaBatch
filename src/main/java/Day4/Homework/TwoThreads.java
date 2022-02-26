package Day4.Homework;

import java.io.*;

public class TwoThreads {
    public static void main(String[] args) throws IOException {
        try {
            BufferedInputStream in = null;
            BufferedOutputStream out = null;

            String inputAddress = new String("/Users/lys/Documents/AntraJavaBatch/src/main/java/Day4/Homework/input.txt");
            String outputAddress = new String("/Users/lys/Documents/AntraJavaBatch/src/main/java/Day4/Homework/output.txt");

            in = new BufferedInputStream(new FileInputStream(inputAddress));
            out = new BufferedOutputStream(new FileOutputStream(outputAddress));

            int c = 0;
            while (c != -1) {
                c = in.read();
                int result = Character.getNumericValue(c);
                while ((char) c != '\n') {
                    out.write(c);
                    System.out.print((char) c);
                    if (isPlus(c)) {
                        c = in.read(); // read a space
                        out.write(c); // write a space
                        System.out.print(' ');
                        c = in.read(); // read a number
                        result += Character.getNumericValue(c);
                    } else if (isMinus(c)) {
                        c = in.read(); // read a number
                        result -= Character.getNumericValue(c);
                    } else {
                        c = in.read();
                    }
                }
                out.write(' ');
                System.out.print(' ');
                out.write('=');
                System.out.print('=');
                out.write(' ');
                System.out.print(' ');
                out.write(c);
                System.out.print((char) c);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("IOException.");
        }
    }

    public static boolean isPlus(int c) {
        return (char) c == '+';
    }

    public static boolean isMinus(int c) {
        return (char) c == '-';
    }
}

