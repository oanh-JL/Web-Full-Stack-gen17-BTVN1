package base.enemy;

import base.*;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.counter.FrameCounter;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    Action actionFire;
    Action actionMove;

    public Enemy() {
        super();
        //this.position = new Vector2D(200,100);
        this.defineAction();
    }

    void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequenceFire = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeatFire = new ActionRepeat(actionSequenceFire);

        ActionSequence actionSequenceMove = new ActionSequence(actionMove);
        ActionRepeat actionRepeatMove = new ActionRepeat(actionSequenceMove);

        this.actionFire = actionRepeatFire;
        this.actionMove = actionRepeatMove;
    }

    @Override
    public void run() {
        this.actionFire.run(this);
        this.actionMove.run(this);
        if (this.position.y>600){
            this.destroy();
            return;
        }
    }

    public void fire() {
        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
        bullet.position.set(this.position.x + 5, this.position.y + 20);
    }

    public void takeDamage(int damage) {

    }

    public void move() {
        this.position.addThis(0, 4);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
