package game;

import base.*;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.scene.SceneManager;
import base.scene.SceneStage2;
import base.scene.welcomescene.WelcomeScene;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
//    Background background;
//    Player player;

    //Hàm khởi tạo GameCanvas
    public GameCanvas() {
//        this.background = GameObject.recycle(Background.class); //Background
//        this.player = GameObject.recycle(Player.class); //Player
//        EnemySummoner enemySummoner = GameObject.recycle(EnemySummoner.class); //Summon Enemy
        SceneManager.signNewScene(new WelcomeScene());
    }

    //Run: hàm để Update even khi có thay đổi về số liệu  (x += 1)
    //Chạy logic
    public void run() {
        //sceneStage2.run();
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
