package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class panel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] snakeX=new int[600];
    int[] snakeY=new int[500];
    String fx;
    boolean isStart=false;
    Timer timer=new Timer(100,(ActionListener) this);
    int foodx;int foody;
    Random random=new Random();
    boolean isFail=false;
    int score;

    public panel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    public void init() {
        length=3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        fx="R";

        foodx=25+25*random.nextInt(34);
        foody=75+25*random.nextInt(24);

        score=0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.fillRect(25,75,800,600);
        data.header.paintIcon(this,g,25,11);

        if(fx.equals("R")) {
            data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if(fx.equals("L")) {
            data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if(fx.equals("U")) {
            data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if(fx.equals("D")) {
            data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for(int i=1;i<length;i++) {
            data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,10));
        g.drawString("长度："+length, 750, 35);
        g.drawString("分数："+score, 750, 50);

        data.food.paintIcon(this, g, foodx, foody);

        if(isStart==false) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",250,400);
        }

        if(isFail) {
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败，按下空格重新开始",250,400);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {if(isStart&&isFail==false) {
        for(int i=length-1;i>0;i--) {
            snakeX[i]=snakeX[i-1];
            snakeY[i]=snakeY[i-1];
        }

        if(fx.equals("R")) {
            snakeX[0]=snakeX[0]+25;
            if(snakeX[0]>800)snakeX[0]=25;
        }else if(fx.equals("L")) {
            snakeX[0]=snakeX[0]-25;
            if(snakeX[0]<25)snakeX[0]=800;
        }else if(fx.equals("U")) {
            snakeY[0]=snakeY[0]-25;
            if(snakeY[0]<75)snakeY[0]=650;
        }else if(fx.equals("D")) {
            snakeY[0]=snakeY[0]+25;
            if(snakeY[0]>650)snakeY[0]=75;
        }

        if(snakeX[0]==foodx&&snakeY[0]==foody) {
            length++;
            score+=10;
            foodx=25+25*random.nextInt(34);
            foody=75+25*random.nextInt(24);
        }
        for(int i=1;i<length;i++) {
            if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]) {
                isFail=true;
            }
        }

        repaint();
    }
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFail) {
                isFail=false;
                init();
            }else {isStart = !isStart;}
            repaint();
        }
        if(keyCode==KeyEvent.VK_LEFT) {
            fx="L";
        }else if(keyCode==KeyEvent.VK_RIGHT) {
            fx="R";
        }else if(keyCode==KeyEvent.VK_UP) {
            fx="U";
        }else if(keyCode==KeyEvent.VK_DOWN) {
            fx="D";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
