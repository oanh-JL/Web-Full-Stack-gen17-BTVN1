package base.tank;

import base.GameObject;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;

public class TankType2 extends Tank {
    public  TankType2(){
        super();
        this.renderer=new SingleImageRenderer("assets/images/enemy-side/cannon/4.png");
        this.collider=new BoxCollider(50,41);

    }
    @Override
    public void fire(){
        TankBullet2  bullet = GameObject.recycle(TankBullet2.class);
        bullet.position.set(this.position.x, this.position.y + 5);
    }

    @Override
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.destroy();
        }
    }
}
