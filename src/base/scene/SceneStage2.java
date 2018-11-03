package base.scene;

import base.BackgroundStone;
import base.GameObject;
import base.player.Player;
import base.stone.StoneSummon;
import base.stone.StoneType1;
import javafx.scene.layout.Background;

public class SceneStage2 extends Scene {

    public BackgroundStone backgroundStone;
    public Player player;
    StoneSummon stoneSummon;

    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        this.backgroundStone = GameObject.recycle(BackgroundStone.class);
        this.player = GameObject.recycle(Player.class);
        stoneSummon= GameObject.recycle(StoneSummon.class);
//        StoneType1 stoneType1 = GameObject.recycle(StoneType1.class);
//        stoneType1.position.set(200,200);

    }

    @Override
    public void run() {
        stoneSummon.isEnd = backgroundStone.isEnd;
    }
//
//    @Override
//    public void run() {
//        stoneSummon.isEnd = backgroundStone.isEnd;
//    }
}
