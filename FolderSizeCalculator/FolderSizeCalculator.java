package FolderSizeCalculator;

import java.io.File;

public class FolderSizeCalculator extends Thread {
    private String path;
    private static float size = 0;
    public FolderSizeCalculator(String path) {
        this.path = path;
    }

    public void listFilesForFolder(File folder) {

        for (final File fileEntry : folder.listFiles()) {

            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                size += fileEntry.length();
            }
        }
    }

    public static float getSize() {
        return size;
    }

    @Override
    public void run() {
        File folder = new File(this.path);
        System.out.println("Calculating");
        listFilesForFolder(folder);
    }

}
