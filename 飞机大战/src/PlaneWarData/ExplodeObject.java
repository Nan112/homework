package PlaneWarData;

import java.awt.*;

public class ExplodeObject extends Object{
    int explodeCount=0;
    static Image[] imgs = new Image[16];
    static {
        for(int i=0;i<16;i++){
            imgs[i]=Toolkit.getDefaultToolkit().getImage("imgs/explode/e"+(i+1)+".gif");
        }
    }

    public ExplodeObject() {
        super();
    }

    public ExplodeObject(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public void paintSelf(Graphics g) {
        if(explodeCount<16){
            g.drawImage(imgs[explodeCount],x,y,null);
            explodeCount++;
        }
    }

    @Override
    public Rectangle getRec() {
        return null;
    }
}
