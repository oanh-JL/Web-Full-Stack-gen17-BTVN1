package base.scene;

import base.Background;
import base.BackgroundGun;
import base.GameObject;
import base.player.Player;
import base.tank.Tank;
import base.tank.TankSummon;

public class SceneStage extends Scene {
public BackgroundGun background;
public Player player;
    public TankSummon tankSummon;


    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        this.background=GameObject.recycle(BackgroundGun.class);
        this.player=GameObject.recycle(Player.class);
        tankSummon=GameObject.recycle(TankSummon.class);

    }

    @Override
    public void run() {
      tankSummon.isEnd =background.isEnd;

    }
}
