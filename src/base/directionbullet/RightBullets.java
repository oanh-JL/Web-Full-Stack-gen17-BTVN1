package base.directionbullet;

import base.GameObject;
import base.enemy.Enemy;
import base.enemy.EnemyBossBullet;
import base.enemy.EnemyBullet;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.player.PlayerBullet;

public class RightBullets extends EnemyBossBullet implements Physics {
    @Override
    public void run() {
       Player player = GameObject.intersect(Player.class, this);

        if(player != null){
            player.destroy();
            this.destroy();
            return;
        }
        if(this.position.y < 0){
            this.destroy();
            return;
        }
        this.position.addThis(3,-3);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
