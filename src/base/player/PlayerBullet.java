package base.player;

import base.Explosion;
import base.enemy.EnemyBoss;
import base.enemy.EnemyBullet;
import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import base.tank.Tank;
import base.tank.TankSummon;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    public Vector2D velocity;
    int damage;

    public PlayerBullet() {
        super();
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        Enemy enemy = GameObject.intersect(Enemy.class, this);
        EnemyBullet enemyBullet = GameObject.intersect(EnemyBullet.class,this);
        Tank tank=GameObject.intersect(Tank.class,this);
        EnemyBoss enemyBoss=GameObject.intersect(EnemyBoss.class, this);
        if(enemyBoss!=null){
           enemyBoss.takeDamage(this.damage);
            this.destroy();

        }
       if (enemyBullet!=null){
            this.destroy();
            enemyBullet.destroy();
        }
        if(enemy != null) {
            enemy.takeDamage(this.damage);
            this.hitEnemy();
            return;
        }
        if(tank!=null){
            this.destroy();
            tank.destroy();
        }
        if(this.position.y < 0) {
            this.destroy();
            return;
        }
        this.position.addThis(velocity);
    }

    public void hitEnemy() {
    }

    @Override
    public void destroy() {
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position.x,this.position.y);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
