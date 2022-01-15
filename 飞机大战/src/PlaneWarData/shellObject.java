package PlaneWarData;

import java.awt.*;

//我方子弹
public class shellObject extends Object{
    public shellObject() {
        super();
    }

    public shellObject(String img, Main frame) {
        super(img, frame);
    }

    public shellObject(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        //移动
        y -= speed;

        if(y<0){
            this.x = -100;
            this.y = 100;
            this.frame.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,14,29);
    }
}
