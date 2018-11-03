package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.counter.FrameCounter;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.ArrayList;
import java.util.Random;

public class EnemySummoner extends GameObject {
    Action actionSpawn;
    public boolean isEnd;

    public EnemySummoner() {
        super();
        this.position = new Vector2D(250, -30);
        this.defineAction();
    }

    public void defineAction() {
        ActionWait actionWait = new ActionWait(60);
        Action actionSpawn = new Action() {
            @Override
            public void run(GameObject master) {
                spawn();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        ActionSequence actionSequenceSpawn = new ActionSequence(actionSpawn, actionWait);
        ActionRepeat actionRepeatSpawn = new ActionRepeat(actionSequenceSpawn);

        this.actionSpawn = actionRepeatSpawn;
    }

    @Override
    public void run() {
        if (!isEnd) {
            this.actionSpawn.run(this);
        }
    }

    public void spawn(){
        EnemyType1 enemy = GameObject.recycle(EnemyType1.class);
        enemy.position.set(this.position.x +100- new Random().nextInt(200), this.position.y);
    }
}