package base.stone;

import base.GameObject;
import base.Settings;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;

import java.util.Random;

public class StoneSummon extends GameObject {
    Action action;
    //ArrayList<Stone> arr = new ArrayList<>();

    public boolean isEnd;

    //FrameCounter frameCounter = new FrameCounter(10);

    public StoneSummon() {
//        ArrayList<BufferedImage> images = SprssssssaasssssaddddddddwiteUtils.loadImages(""
        createStones();

    }

    public void createStones() {
        ActionWait actionWait = new ActionWait(50);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                createStone();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;
    }

    public void createStone() {
        StoneType1 stoneType1 = GameObject.recycle(StoneType1.class);
        stoneType1.position.set(
                Settings.START_STONE_POSITION_X - 250 + new Random().nextInt(200),
                -300);
    }

    @Override
    public void run() {
        if (!isEnd) {
            this.action.run(this);
        }
    }
}
