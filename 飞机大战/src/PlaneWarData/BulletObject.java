package PlaneWarData;

import java.awt.*;

public class BulletObject extends Object{
    public BulletObject() {
        super();
    }

    public BulletObject(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    public BulletObject(String img, Main frame) {
        super(img, frame);
    }

    public BulletObject(String img, int x, int y, int width, int height, double speed, Main frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        y += speed;
        //越界删除
        if(y>600){
            this.x = -200;
            this.y = 200;
            this.frame.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,10,20);
    }
}
