package code;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame=new JFrame("20软件工程1班20号李温妮");
        frame.setBounds(550, 100, 450, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new panel());
    }
}
