package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示image画图
 */
public class ImageFile {

    private static String savePath = "/Users/xiaoguixin/Documents/test/image.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
        fill(bufferedImage);
    }

    /**
     * 演示填充
     * @param bufferedImage
     * @throws IOException
     */
    public static void fill(BufferedImage bufferedImage) throws IOException {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Graphics2D graphics2D = bufferedImage.createGraphics();

        // 填充背景
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0,width,height);

        // 画色块
        graphics2D.setColor(Color.green);
        for(int i=0;i<13;i++){
            int x = (i*3+1)*10;
            graphics2D.fillRect(x,10,20,20);
        }

        // 正方形状
        graphics2D.setColor(Color.orange);
        graphics2D.fillRect(180,180,40,40);

        // 填充圆
        graphics2D.setColor(Color.PINK);
        graphics2D.fillRoundRect(185,185,30,30,30,30);

        // 画色块
        graphics2D.setColor(Color.green);
        for(int i=0;i<13;i++){
            int x = (i*3+1)*10;
            graphics2D.fillRect(x,370,20,20);
        }

        // 保存图片
        ImageIO.write(bufferedImage,"JPEG", new FileOutputStream(savePath));
    }

    public void draw(BufferedImage bufferedImage) throws IOException {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Graphics2D graphics2D = bufferedImage.createGraphics();

        // 画框
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(0,0,width-1,height-1);

        // 画线
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawLine(2,2,100,2);

        // 画点
        graphics2D.setColor(Color.RED);
        graphics2D.drawLine(185,185,185,185);

        // 画圆

        // 保存图片
        ImageIO.write(bufferedImage,"JPEG", new FileOutputStream(savePath));
    }
}
