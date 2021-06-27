package TimerGui;

import javax.swing.*;

public class TimerThread extends Thread{
    private long timer;
    JTextField textField;
    public TimerThread(long timer, JTextField tf) {
        this.timer = timer;
        this.textField=tf;
    }

    @Override
    public void run() {
        while (this.timer>=0){
            this.textField.setText(this.timer/60000+"m  "+
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
