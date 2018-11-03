package base.enemy;

import base.Explosion;
import base.GameObject;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        super();
        List<String> listEnemies = Arrays.asList(
                "assets/images/enemy-main/00.png",
                "assets/images/enemy-main/01.png",
                "assets/images/enemy-main/02.png",
                "assets/images/enemy-main/04.png",
                "assets/images/enemy-main/05.png",
                "assets/images/enemy-main/06.png",
                "assets/images/enemy-main/07.png",
                "assets/images/enemy-main/08.png"
        );
        Random rand = new Random();
        int randomIndex = rand.nextInt(listEnemies.size());
        String randomElement = listEnemies.get(randomIndex);
        this.renderer = new SingleImageRenderer(randomElement);
        this.collider = new BoxCollider(30, 51);
    }

    @Override
    public void takeDamage(int damage) {
        if(damage > 0) {
            this.destroy();
        }

    }
    @Override
    public void destroy() {
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position);
    }
}
