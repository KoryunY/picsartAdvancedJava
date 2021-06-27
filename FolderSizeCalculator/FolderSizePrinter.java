package FolderSizeCalculator;

public class FolderSizePrinter extends Thread{
    FolderSizeCalculator fsc;
    public FolderSizePrinter(FolderSizeCalculator fsc) {
        this.fsc=fsc;
    }

    @Override
    public void run() {
        while (fsc.isAlive()){
        System.out.println( "("+(int)FolderSizeCalculator.getSize() + "bytes"+")");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        System.out.println("Your Folder Size is:"+"("+(int)FolderSizeCalculator.getSize() + "bytes"+")");

    }
}
