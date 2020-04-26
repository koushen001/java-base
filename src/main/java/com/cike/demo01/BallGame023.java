package com.cike.demo01;

import javax.swing.*;
import java.awt.*;

public class BallGame023 extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage(BallGame023.class.getClassLoader().getResource("ball.png"));
    Image desk = Toolkit.getDefaultToolkit().getImage(BallGame023.class.getClassLoader().getResource("desk.jpg"));

    double x = 100;
    double y = 100;

    double degree = 3.14 / 3;//弧度，此处就是60度

    //画窗口的方法
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
        if (y > 500 - 40 - 30 || y < 40 + 40) {//500是窗口宽度，40是桌子边框，30是球直径，40标题栏高度
            degree = -degree;
        }
        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
    }

    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);
        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BallGame023 ballGame = new BallGame023();
        ballGame.launchFrame();
    }
}
