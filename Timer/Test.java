package Timer;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Input minutes and seconds int m,s format");
        String ms=s.next();
        s.close();
        String[] spl=ms.split(",");
        int min=Integer.parseInt(spl[0]);
        long sec=Long.parseLong(spl[1]);
        sec=sec+min*60;
        Timer(sec);

    }
    static void Timer(long x){
        TimerThread timerThread=new TimerThread(x*1000);
        timerThread.start();
    }
}
