package base.scene;

import base.Background;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.stone.StoneSummon;

public abstract class Scene {


    public abstract void destroy();

    public abstract void init();

    public abstract void run();
}
