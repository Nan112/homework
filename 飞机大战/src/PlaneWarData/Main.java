package PlaneWarData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{
    Image bg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    Image explode=Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");

    //定义双缓存图片：解决开头文字闪动问题
    Image offScreenImage=null;

    //背景实体类
    BgObj bgobj=new BgObj("imgs/bg.jpg",0,-2000,1,this);

    //大集合
    List<Object> objList=new ArrayList<>();
    //被删除的物体集合
    List<Object> removeList=new ArrayList<>();
    //我方战斗机
    PlaneObject planeObj=new PlaneObject("imgs/plane.png",290,550,0,this);
    //我方子弹
    List<shellObject> shellobjlist=new ArrayList<>();//集合
    //敌方战机
    List<EnemyObject> enemyObjlist=new ArrayList<>();
    //BOSS
    BossObject bossobj=null;
    //敌方子弹
    List<BulletObject> bullobjlist=new ArrayList<>();
    //爆炸对象集合
    List<ExplodeObject> explodeObjectList=new ArrayList<>();


    int count=1;//游戏重绘次数
    int enemyCount=0;
    int state=0;//0:未开始 1：游戏中 2：暂停 3：通关成功 4：通关失败
    int my_width=600;
    int my_height=600;
    int explode_x = -300;
    int explode_y = 300;

    public void launch(){
        this.setTitle("飞机大战-2020120310120李温妮");
        this.setVisible(true);
        this.setSize(my_width,my_height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        //将游戏物体添加到大集合
        objList.add(bgobj);
        objList.add(planeObj);

        //鼠标点击变化
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标左键点击为1，滚轮为2，右键为3
                if(e.getButton()==1 && state==0){
                    state=1;
                    repaint();//重新调用pain方法
                }

            }
        });
        //暂停：键盘事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==32){
                    switch (state){
                        case 1:state=2;break;
                        case 2:state=1;break;
                    }
                }
            }
        });

        while(true){
            if(state==0){repaint();}
            if(state == 1){
                creatObj();
                repaint();
            }
            try {
                Thread.sleep(20);//线程休眠：1s等于1000ms
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        //创建和容器一样大小的图片
        if(offScreenImage ==null){
            offScreenImage=createImage(my_width,my_height);
        }
        //获得该图片画布
        Graphics gImage=offScreenImage.getGraphics();
        //填充画布
        gImage.fillRect(0,0,my_width,my_height);

        if(state==0){
            gImage.drawImage(bg,0,0,null);//背景图片
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("点击开始游戏",180,300);
        }
        if(state==1){
            //爆炸添加到大集合
            objList.addAll(explodeObjectList);

            //绘制所有游戏物体
            for(Object object:objList){
                object.paintSelf(gImage);
            }
            //绘制完后再删除
            objList.removeAll(removeList);
            /*如需优化成功，顺序需改为这样，先添加大集合中，
            *绘制所有元素成功后，
            * 再进行删除。*/
        }
        if(state==3){
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("游戏失败！",180,300);
            }
        if(state==4){
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("恭喜！游戏成功！",180,300);
        }

        gImage.drawImage(explode,explode_x,explode_y,null);
        //将缓冲区绘制好的图片绘制到容器画布中
        g.drawImage(offScreenImage,0,0,null);
        count++;
    }

    //添加子弹或敌人
    public void creatObj(){
        //控制我方子弹发射次数
        if (count % 15 == 0) {
            shellobjlist.add(new shellObject("imgs/shell.png", planeObj.x + 3, planeObj.y - 10, 10, this));
            objList.add(shellobjlist.get(shellobjlist.size() - 1));
        }
        //敌方飞机
        if(count % 15 ==0) {
            enemyObjlist.add(new EnemyObject("imgs/enemy.png",this));
            objList.add(enemyObjlist.get(enemyObjlist.size() - 1));
            enemyCount++;
        }
        if(enemyCount>20){
            if(bossobj==null){
                bossobj=new BossObject("imgs/boss.png",250,30,5,this);
                objList.add(bossobj);
            }
        }
        //控制敌方子弹发射次数
        if(count % 10 == 0 && bossobj != null) {
        bullobjlist.add(new BulletObject("imgs/bullet.png",bossobj.x + 43,bossobj.y+ 109,10,this));
        objList.add(bullobjlist.get(bullobjlist.size() - 1));
        }
    }

    public static void main(String[] args) {
	Main planwar=new Main();
    planwar.launch();
    }
}
