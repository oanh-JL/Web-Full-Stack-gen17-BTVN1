package game;

import base.*;
import base.enemy.Enemy;
import base.enemy.EnemyType1;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;

    //Hàm khởi tạo GameCanvas
    public GameCanvas() {
        this.background = GameObject.recycle(Background.class); //Background
        this.player = GameObject.recycle(Player.class); //Player
        EnemyType1 enemy = GameObject.recycle(EnemyType1.class); //Enemy
    }

    //Run: hàm để Update even khi có thay đổi về số liệu  (x += 1)
    //Chạy logic
    public void run() {
        //Run all: chạy tất cả object được add vào list static gameObjects
        GameObject.runAll();
    }

    //render là bút vẽ sau khi số liệu đc update (g.draw)
    //Vẽ lên giao diện
    public void render() {
        GameObject.renderAllToBackBuffer();
    }

    //painComponent: là hàm vẽ các thay đổi
    //Graphics : đóng vai trò là bút vẽ, là 1 phần trong Jpanel
    @Override
    protected void paintComponent(Graphics g) {
        //Gom tất cả các phần vẽ trong render để vẽ
        GameObject.renderBackBufferToGame(g);
    }
}
