package com.cike.demo01;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage(BallGame.class.getClassLoader().getResource("ball.png"));
    Image desk = Toolkit.getDefaultToolkit().getImage(BallGame.class.getClassLoader().getResource("desk.jpg"));

    int x = 100;
    int y = 100;
    boolean right = true;

    //画窗口的方法
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, x, y, null);
        if (right) {
            x = x + 10;
        } else {
            x = x - 10;
        }
        if (x < 40) {
            right = true;
        }
        if (x > 856 - 40 - 30) {
            right = false;
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
        BallGame ballGame = new BallGame();
        ballGame.launchFrame();
    }
}
