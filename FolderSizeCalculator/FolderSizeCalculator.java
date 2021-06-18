package FolderSizeCalculator;

import java.io.File;

public class FolderSizeCalculator extends Thread {
    private String path;
    private double size = 0;

    public FolderSizeCalculator(String path) {
        this.path = path;
    }

    public void  listFilesForFolder(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);

            } else {
                this.size += fileEntry.length();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Math.round((this.size/1024)*100.0)/100.0+"Kb "+"("+(int)this.size + "bytes"+")");
        }
    }

    @Override
    public void run() {
        File folder = new File(this.path);
        System.out.println("Calculating");
        listFilesForFolder(folder);
        System.out.println("Your Folder Size is:"+Math.round((this.size/1024)*100.0)/100.0+"Kb "+"("+(int)this.size + "bytes"+")");
    }
}
