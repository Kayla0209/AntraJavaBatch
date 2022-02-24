package Day2.HomeWork;


import java.io.File;

public class CountFiles {
    public static void main(String[] args) {
        Criteria c = new Criteria("/Users/lys/Documents/Antra");
        count(c);
    }
    public static void count(Criteria c) {
        int[] result = new int[]{0, 0};
        String path = new String(c.folderPath);
        File file = new File(path);
        countFileFolder(c, result);
        System.out.print("There are " + result[0] + " file(s) and " + result[1] + " folder(s) ");
        System.out.print("inside folder " + file.getName() + ".");
    }

    // num[0] - number of files in this directory, num[1] - number of folders in this directory
    public static void countFileFolder(Criteria c, int[] num) {
        if (c.file.isFile()) { // the path is a file's path
            num[0]++;
            return;
        }
        if (!c.includeSubFolder) { // no more subfolders
            num[0] += c.file.list().length;
            return;
        }

        // valid folder and there are subfolders
        for (File f : c.file.listFiles()) {
            if (f.isFile()) {
                num[0]++;
                //System.out.println("File: " + f.getName());
            }
            if (f.isDirectory()) {
                num[1]++;
                //System.out.println("Folder: " + f.getName());
                countFileFolder(new Criteria(f.getPath()), num);
            }
            // System.out.println(f.getName());
        }
    }
}

