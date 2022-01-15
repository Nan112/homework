package code;

import javax.swing.*;
import java.net.URL;

public class data {
    public static URL headerurl=data.class.getResource("/picture/header.jpg");
    public static URL bodyurl=data.class.getResource("/picture/body.jpg");
    public static URL downurl=data.class.getResource("/picture/down.jpg");
    public static URL foodurl=data.class.getResource("/picture/food.jpg");
    public static URL lefturl=data.class.getResource("/picture/left.jpg");
    public static URL righturl=data.class.getResource("/picture/right.jpg");
    public static URL upurl=data.class.getResource("/picture/up.jpg");

    public static ImageIcon up = new ImageIcon(upurl);
    public static ImageIcon down = new ImageIcon(downurl);
    public static ImageIcon left = new ImageIcon(lefturl);
    public static ImageIcon right = new ImageIcon(righturl);
    public static ImageIcon header = new ImageIcon(headerurl);
    public static ImageIcon body = new ImageIcon(bodyurl);
    public static ImageIcon food = new ImageIcon(foodurl);
}
