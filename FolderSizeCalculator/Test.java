package FolderSizeCalculator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Folder Path");
        String path = scanner.next();
        scanner.close();
        FolderSizeCalculator fs = new FolderSizeCalculator(path);
        fs.start();
    }
}

