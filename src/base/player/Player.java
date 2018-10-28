package base.player;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.event.MouseEvent;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.event.MouseEvent.MOUSE_CLICKED;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;
    int hp;
    Vector2D velocity;

    public Player() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        this.renderer = new PlayerAnimator();
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X
                , Settings.START_PLAYER_POSITION_Y);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(32, 48);
        this.hp = 20;
        this.velocity = new Vector2D(0, 0);
    }

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
        if(MouseEvent.isFirePress && fireCounterRun) {
            this.fire(0, -1);
        }
        this.position.addThis(this.velocity);
    }

    public void fire(int xM, int yM) {

        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);

        bullet.velocity.set(xM, yM);

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
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
