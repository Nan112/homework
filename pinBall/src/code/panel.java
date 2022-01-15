package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class panel extends JPanel implements KeyListener, ActionListener {

    //挡板长跟宽度
    final int width=60;
    int hight=20;
    //球拍初始位置
    final int racket_y=450;
    int racket_x=120;
    final int size=16;//小球大小：直径16
    int x=120,y=20;//小球位置
    int speedX=10,speedY=5;//小球速度

    boolean isFall=false;//判断游戏是否失败
    Timer time=new Timer(100,(ActionListener) this);//界面刷新速度

    public panel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        time.start();
    }

    public void init() {}
    //绘制
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        if (isFall == false) {//游戏中
            g.setColor(Color.BLUE);
            g.fillOval(x, y, size, size);//填充小球颜色，filloval填充圆形
            g.setColor(Color.PINK);
            g.fillRect(racket_x, racket_y, width, hight);//填充球拍颜色，fillrect填充矩形
        } else if (isFall == true) {//游戏失败
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏失败！", 10, 200);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //小球碰到左右边框
        if(x<=0||x>=(450-size)) {
            speedX= -speedX;
        }
        //小球碰到球拍或上边框
        if(y<=0 || (y>racket_y-size && x>racket_x && x<racket_x+width)) {
            speedY= -speedY;
        }
        //游戏失败
        if(y>racket_y-size && (x<racket_x || x>racket_x+width)) {
            time.stop();
            isFall=true;
            repaint();
        }
        x+=speedX;
        y+=speedY;
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_LEFT) {
            if(racket_x>0) {racket_x-=10;}//向左一次10像素
        }else if(keyCode==KeyEvent.VK_RIGHT) {
            if(racket_x<450-width) {racket_x+=10;}//向右一次10像素
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
