package base.scene;

import base.BackgroundBoss;
import base.GameObject;
import base.enemy.EnemyBoss;
import base.enemy.EnemySummoner;
import base.player.Player;

public class LastSceneStage extends Scene {
    BackgroundBoss backgroundBoss;
    Player player;
    EnemyBoss enemyBoss;
    EnemySummoner enemySummoner;

    @Override
    public void destroy() {
        GameObject.clearAll();

    }

    @Override
    public void init() {
        backgroundBoss=GameObject.recycle(BackgroundBoss.class);
        player=GameObject.recycle(Player.class);
        enemyBoss=GameObject.recycle(EnemyBoss.class);
        enemySummoner=GameObject.recycle((EnemySummoner.class));

    }

    @Override
    public void run() {


    }
}
