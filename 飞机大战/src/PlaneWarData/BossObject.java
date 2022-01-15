package PlaneWarData;

import java.awt.*;

public class BossObject extends Object{
    int life=10;
    public BossObject() {
        super();
    }

    public BossObject(String img, Main frame) {
        super(img, frame);
    }

    public BossObject(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        //控制BOSS方向
        if(x>500){
            speed = -5;
        }
        if(x<=0){
            speed = 5;
        }
        x += speed;
        //BOSS与我方子弹碰撞检测
       for(shellObject shellObject:this.frame.shellobjlist){
           if(this.getRec().intersects(shellObject.getRec())){
               shellObject.x = -100;
               shellObject.y = 100;
               this.frame.removeList.add(shellObject);
           life--;
           }
           if ((life <= 0)){
               this.frame.state = 4;
               this.frame.explode_x = this.frame.bossobj.x;
               this.frame.explode_y = this.frame.bossobj.y;
           }
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,157,109);
    }
}
