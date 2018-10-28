package game;

import base.event.KeyEventPress;
import base.Settings;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameWindow extends JFrame {
    GameCanvas canvas;
    public static int xM, yM;

    public GameWindow() {
        //setup window
        this.setSize(Settings.SCREEN_WIDHT, Settings.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListtener();

        //init game
        this.canvas = new GameCanvas();
        this.add(canvas);

        this.setVisible(true);
    }

    //Xử lí sự kiện ấn nút
    private void setupEventListtener() {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                base.event.MouseEvent.isFirePress = true;
                xM = e.getX();
                yM = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                base.event.MouseEvent.isFirePress = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });
    }

    //Vòng lặp Game
    public void gameLoop() {
        long delay = 1000 / 60;
        long lastTime = 0;
        while(true) {
            //Nếu thời gian hiện tại cách thời gian chạy cuối cùng 1 khoảng bằng delay thì vẽ hình (thời gian hiện tại luôn tăng)
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                canvas.run(); //runAll()
                canvas.render(); // render all to backBuffer
                this.repaint(); // render backBuffer to game
                //Mỗi lần chạy xong thì gán t/g hiện tại băng t/g cuối
                lastTime = currentTime;
            }
        }
    }
}
