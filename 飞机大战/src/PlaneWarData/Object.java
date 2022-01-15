package PlaneWarData;

import java.awt.*;

public abstract class Object {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    Main frame;//引用主界面

    public Object() {
    }

    public Object(String img, Main frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.frame = frame;
    }

    public Object(String img, int x, int y, double speed, Main frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.frame = frame;
    }

    public Object(String img, int x, int y, int width, int height, double speed, Main frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Main getFrame() {
        return frame;
    }

    public void setFrame(Main frame) {
        this.frame = frame;
    }
    //继承元素绘制自己的方法（抽象
    public abstract void paintSelf(Graphics g);

    //获取当前游戏元素的矩形，为碰撞检测作写
    public abstract  Rectangle getRec();
}
