package base.enemy;

import base.Explosion;
import base.GameObject;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class EnemyBossBullet extends GameObject implements Physics {
    public BoxCollider collider;
     ArrayList<BufferedImage> images;
      int damage;
     public EnemyBossBullet(){
      super();
      this.setType(new Random().nextInt(3));
      this.collider=new BoxCollider(24,24);
         this.damage = 1;
     }
     public void setType(int n){
         images = SpriteUtils.loadImages(
                 "assets/images/player-bullets/a/0.png",
                 "assets/images/player-bullets/a/1.png",
                 "assets/images/player-bullets/a/2.png",
                 "assets/images/player-bullets/a/3.png"
         );
         ArrayList<BufferedImage> images1 = SpriteUtils.loadImages(
                 "assets/images/sphere/0.png",
                 "assets/images/sphere/1.png"
         );
         switch (n){
             case 0:
                 this.renderer = new AnimationRenderer(images);
                 break;
             case 1:
                 images.clear();
                 this.renderer = new AnimationRenderer(images1);
                 break;

         }
         this.position=new Vector2D(0,0);

     }
     @Override
     public void run() {
         Player player = GameObject.intersect(Player.class, this);
         if (player != null) {
             player.takeDamage(this.damage);
             this.destroy();
         }
         this.position.addThis(0,-3);
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
