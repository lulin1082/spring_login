package cn.tedu.ems.system.service.ls;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Author: lulin
 * @Date: 3/7/2019 10:27 PM
 * @Version 1.0
 */
public class ImageService {

    public static BufferedImage drawImage(String code ) {
    /* * step1.生成图片
		 */
        //创建一个画布
        BufferedImage image = new BufferedImage(105, 30, BufferedImage.TYPE_INT_BGR);
        //获得画笔
        Graphics g = image.getGraphics();
        //给笔设置颜色
        g.setColor(new Color(255, 255, 255));
        //设置画布背景颜色
        g.fillRect(0, 0, 105, 30);
        //重新给笔设置颜色
        Random r = new Random();
        g.setColor(new Color(
                r.nextInt(255),
                r.nextInt(255),
                r.nextInt(255)));
        //设置字体
        g.setFont(new Font(null, Font.BOLD, 24));
        for (int i = 0; i < 20; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(105), r.nextInt(30), r.nextInt(105), r.nextInt(30));
        }
        //在图片上绘制随机数
        g.drawString(code, 2, 25);
        return image;
    }
}
