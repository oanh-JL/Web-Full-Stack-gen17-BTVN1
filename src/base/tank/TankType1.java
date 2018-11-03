package base.tank;

import base.GameObject;
import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;

public class TankType1 extends Tank {
    public TankType1(){
        super();
        this.renderer=new AnimationRenderer("assets/images/enemy-side/cannon/2.png");
        this.collider=new BoxCollider(50,41);
    }
    @Override
    public void fire(){
        TankBullet1  bullet = GameObject.recycle(TankBullet1.class);
        bullet.position.set(this.position.x, this.position.y + 5);
    }
    @Override
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.destroy();
        }
    }
}
