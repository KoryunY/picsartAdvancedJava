package Timer;

public class TimerThread extends Thread{
    private long timer;

    public TimerThread(long timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        while (this.timer>=0){
            System.out.println(this.timer/60000+"m  "+
                    (this.timer-(this.timer/60000)*60000)/1000+"sec");
            this.timer-=1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
