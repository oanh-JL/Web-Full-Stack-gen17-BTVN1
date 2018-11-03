package base.player;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.event.MouseManager;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.scene.SceneManager;
import base.scene.SceneStage1;
import base.scene.SceneStage2;
import base.scene.welcomescene.WelcomeScene;
import base.stone.StoneType1;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    int hp;
    Vector2D velocity;
    Vector2D bulletVelocity;

    public Player() {
        super();
        this.bulletVelocity = new Vector2D();
        this.renderer = new PlayerAnimator();
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X
                , Settings.START_PLAYER_POSITION_Y);
       // this.position = new Vector2D(0,0);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(30, 69);
        this.hp = 20;
        this.velocity = new Vector2D(0, 0);
    }
   // FrameCounter newSceneCounter = new FrameCounter(500);
    @Override
    public void run() {
        int VX = 0;
        int VY = 0;
        if(KeyEventPress.isUpPress) {
            VY -= 1;
        }
        if(KeyEventPress.isDownPress) {
            VY += 1;
        }
        if(KeyEventPress.isRightPress) {
            VX += 1;
        }
        if(KeyEventPress.isLeftPress) {
            VX -= 1;
        }
        this.move(VX, VY);
        //fire
        boolean fireCounterRun = this.fireCounter.run();
        if(MouseManager.mouseManager.isPressed && fireCounterRun) {
            bulletVelocity.set(MouseManager.mouseManager.position.x - this.position.x, MouseManager.mouseManager.position.y - this.position.y );
            this.fire(bulletVelocity.normalize().scaleThis(3));
        }
        if (KeyEventPress.isSpacePress && fireCounterRun){
            this.fireSpace();
        }

        if (this.position.x <= 85){
            this.position.x = 85;
        }
        if (this.position.x >= 415){
            this.position.x = 415;
        }
        if (this.position.y >= 520){
            this.position.y = 520;
        }
        if (this.position.y <= 50){
            this.position.y = 50;
        }

        StoneType1 type1 = GameObject.intersect(StoneType1.class,this);
        Background background;
        if (type1!=null){
            this.destroy();
        }
        this.position.addThis(this.velocity);
    }
    public void fireSpace(){
        PlayerBulletType1 bulletType1 = GameObject.recycle(PlayerBulletType1.class);
        PlayerBulletType1 bulletType2 = GameObject.recycle(PlayerBulletType1.class);
        bulletType1.position.set(this.position.x,this.position.y);
        bulletType2.position.set(this.position.x,this.position.y);
        bulletType1.velocity.set(0,-3);
        bulletType2.velocity.set(3,-3);
        this.fireCounter.reset();
    }
    public void fire(Vector2D velocity) {

        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);

        bullet.velocity.set(velocity);

        bullet.position.set(this.position.x, this.position.y);

        this.fireCounter.reset();
    }

    public void move(int velocityX, int velocityY) {
        if(velocityX == 0 && velocityY == 0) {
            this.velocity.set(0, 0);
        } else {
            this.velocity.addThis(velocityX, velocityY);
            this.velocity.set(clamp(velocity.x, -3, 3),
                    clamp(velocity.y, -3, 3));
        }
    }

    public float clamp(float number, float min, float max) {
        return number < min ? min : number > max ? max : number;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0) {
            this.destroy();
            hp = 0;
            SceneManager.signNewScene(new WelcomeScene());

        }
    }

    @Override
    public void destroy() {
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }

}
