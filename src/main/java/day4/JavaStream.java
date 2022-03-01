package day4;

import java.io.*;

public class JavaStream {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream("/Users/lys/Documents/input.txt");
            out = new FileOutputStream("/Users/lys/Documents/output.txt");

            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
                out.write(c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            {
                if (out != null) out.close();
                if (in != null) in.close();
            }
        }

    }
}
