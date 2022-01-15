package PlaneWarData;

import java.awt.*;

//背景的实体类
public class BgObj extends Object{
    int score=0;

    public BgObj() {
        super();
    }

    public BgObj(String img, int x, int y, double speed, Main frame) {
        super(img, x, y, speed, frame);
    }

    public BgObj(String img, Main frame) {
        super(img, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        if(y>=0){y = -2000;}//控制背景图循环
        y += speed;//背景图向下移动
        //计分板
        g.setColor(Color.white);
        g.setFont(new Font("仿宋",Font.BOLD,30));
        g.drawString(score + "分",20,550);
    }

    @Override
    public Rectangle getRec() {
        return null;
    }
}
