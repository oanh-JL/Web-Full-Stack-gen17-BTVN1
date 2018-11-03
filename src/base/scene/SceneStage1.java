package base.scene;

import base.Background;
import base.GameObject;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.stone.StoneSummon;


public class SceneStage1 extends Scene {

    public Background background;
    public Player player;
    EnemySummoner enemySummoner;
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        enemySummoner = GameObject.recycle(EnemySummoner.class);
    }

    @Override
    public void run() {
        enemySummoner.isEnd = background.isEnd;
    }
}
