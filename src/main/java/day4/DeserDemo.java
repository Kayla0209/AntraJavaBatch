package day4;

import java.io.*;

public class DeserDemo {
    public static void main(String[] args) {
        Student student = null;
        try {
            InputStream fileIn = new FileInputStream("/Users/shaohua/Desktop/JavaMaterial/student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            student = (Student) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getSsn());


    }
}