package PlaneWarData;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//我方飞机
public class PlaneObject extends Object{
    public PlaneObject() {
        super();
    }

    public PlaneObject(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    public PlaneObject(String img, Main frame) {
        super(img, frame);
    }

    public PlaneObject(String img, int x, int y, int width, int height, double speed, Main frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        //添加鼠标事件，飞机跟随鼠标移动
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                x=e.getX()-11;
                y=e.getY()-16;
            }
        });
        //我方飞机与敌方BOSS碰撞检测
        if(this.frame.bossobj != null){
            if(this.getRec().intersects(this.frame.bossobj.getRec())){
                this.frame.state = 3;
                this.frame.explode_x = x-11;
                this.frame.explode_y = y-16;
        }
        }
        //我方飞机与敌方子弹碰撞检测
        for(BulletObject bulletObject:this.frame.bullobjlist){
            if(this.getRec().intersects(bulletObject.getRec())){
                this.frame.state=3;
                this.frame.explode_x = x-11;
                this.frame.explode_y = y-16;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,22,33);
    }
}
