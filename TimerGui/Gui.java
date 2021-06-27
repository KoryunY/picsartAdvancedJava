package TimerGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JTextField tf1,tf2,tf3;
    JButton b1;
    JLabel l1,l2;
    Gui(){
        JFrame f= new JFrame();
        l1=new JLabel("Minutes");
        l1.setBounds(5,45, 100,30);
        l2=new JLabel("Seconds");
        l2.setBounds(5,95, 100,30);

        tf1=new JTextField();
        tf1.setBounds(60,50,150,20);
        tf2=new JTextField();
        tf2.setBounds(60,100,150,20);
        tf3=new JTextField("Timer");
        tf3.setBounds(50,150,150,20);
        tf3.setEditable(false);
        b1=new JButton("Start");
        b1.setBounds(60,200,100,50);
        b1.addActionListener(this);
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);f.add(l1);f.add(l2);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {

        String s1=tf1.getText();
        String s2=tf2.getText();
        byte min=Byte.parseByte(s1);
        int sec=Integer.parseInt(s2);
        sec=sec+min*60;
        TimerThread timerThread=new TimerThread(sec*1000,tf3);
        timerThread.start();

    }
}
