package base.scene;

import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.player.Player;


public class SceneStage1 extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
    }
}
