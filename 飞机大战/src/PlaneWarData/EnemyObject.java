package PlaneWarData;

import java.awt.*;

//敌方飞机
public class EnemyObject extends Object{
    int x=(int)(Math.random()*12) * 50;
    int speed=5;
    public EnemyObject() {
        super();
    }

    public EnemyObject(String img, Main frame) {
        super(img, frame);
    }

    public EnemyObject(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        y += speed;
        //越界的敌方飞机删除：性能优化
        if(y>600){
            this.x = -150;
            this.y = 150;
            this.frame.removeList.add(this);
        }
        //与我方飞机接触，游戏结束
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
            this.frame.state = 3;
            this.frame.explode_x = this.frame.planeObj.x - 11;
            this.frame.explode_y = this.frame.planeObj.y - 16;
        }
        //与我方炮弹进行碰撞检测
        for(shellObject shellObject:this.frame.shellobjlist){
            if(this.getRec().intersects(shellObject.getRec())){
                //添加爆炸效果
                ExplodeObject explodeobj=new ExplodeObject(this.x,this.y);
                this.frame.explodeObjectList.add(new ExplodeObject(this.x,this.y));
                //删除爆炸效果图：优化性能
                this.frame.removeList.add(explodeobj);
                //我方子弹删除前改变坐标为-100,100；敌方飞机改变坐标为-150,150(否则会在应消失处留位置)
                shellObject.x = -100;
                shellObject.y = 100;
                this.x = -150;
                this.y = 150;

                this.frame.removeList.add(shellObject);
                this.frame.removeList.add(this);

                this.frame.bgobj.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,40,30);
    }
}
