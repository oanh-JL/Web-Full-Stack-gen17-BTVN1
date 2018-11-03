package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.gameoverscene.GameOverScene;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBoss extends GameObject implements Physics {
    BoxCollider collider;
    Action actionFire;
    int hp;
    public EnemyBoss(){
        super();
        this.collider=new BoxCollider(100,112);
        this.position=new Vector2D(200,10);
        BufferedImage image= SpriteUtils.loadImage("assets/images/boss/1.png");
        this.renderer=new SingleImageRenderer(image);
        defineAction();    }

    private void defineAction() {
        ActionWait actionWait=new ActionWait(5);
        Action actionFire=new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone=true;
            }

            @Override
            public void reset() {
                this.isDone=false;

            }
        };
        ActionSequence actionSequenceFire=new ActionSequence(actionFire,actionWait);
        ActionRepeat actionRepeatFire=new ActionRepeat(actionSequenceFire);
        this.actionFire=actionRepeatFire;
    }
    public void fire(){
        EnemyBullet Bullet=GameObject.recycle(EnemyBullet.class);
        Bullet.position.set(this.position.x + 5, this.position.y + 20);



    }
    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            this.destroy();
            hp = 0;
            SceneManager.signNewScene(new GameOverScene());

        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
