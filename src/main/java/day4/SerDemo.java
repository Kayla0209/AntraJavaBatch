

package day4;

import java.io.*;

public class SerDemo {

    public static void main(String[] args) {
        Student student = new Student("Charlie", 12);
        student.setSsn(123456);
        try {
            OutputStream fileout = new FileOutputStream("/Users/lys/Desktop/student.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(student);
            out.close();
            fileout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
