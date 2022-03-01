package day2.homework;

import java.io.File;

public class Criteria {
    static String folderPath;
    static boolean includeSubFolder;
    static String extension;
    static File file;

    Criteria(String path) {
        this.folderPath = path;
        this.file = new File(folderPath);
        this.includeSubFolder = isIncludeSubFolder();
    }

    public static boolean isFolder() {
        return file.isDirectory();
    }

    public static boolean isIncludeSubFolder() {
        if (!isFolder()) { // not a path of folder
            return false;
        }
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                return true;
            }
        }
        return false;
    }
}
