package base.enemy;

import base.GameObject;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.scene.SceneManager;
import base.scene.gameoverscene.GameOverScene;

public class EnemyBoss extends GameObject implements Physics {
    BoxCollider collider;
    Action actionFire;
    int hp;
    public EnemyBoss(){
        super();
        defineAction();    }

    private void defineAction() {
        ActionWait actionWait=new ActionWait(20);
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
