package base.scene;

import base.Background;
import base.enemy.EnemySummoner;
import base.player.Player;

public abstract class Scene {
    public Background background;
    public Player player;
    public EnemySummoner enemySummoner;

    public abstract void destroy();

    public abstract void init();
}
