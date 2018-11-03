package base.tank;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.SingleImageRenderer;

public class TankBullet1 extends GameObject implements Physics {
    BoxCollider collider;
    Vector2D velocity;
    int damage;
    public TankBullet1(){
        this.renderer=new SingleImageRenderer("assets/images/enemy-side/cannon/0.png");
        this.position=new Vector2D(Settings.TANK_POSITION_X+5, Settings.TANK_POSITION_Y+5);
        this.velocity=new Vector2D(4,4);
        this.damage=4;
        this.collider=new BoxCollider(15,15);
    }


    @Override
    public void run() {
        this.position.addThis(this.velocity);
        Player player = GameObject.intersect(Player.class, this);
        if(player != null) {
            player.takeDamage(this.damage);
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
