package base.enemy;

import base.physics.BoxCollider;
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
                "assets/images/enemy-main/03.png",
                "assets/images/enemy-main/04.png",
                "assets/images/enemy-main/05.png",
                "assets/images/enemy-main/06.png",
                "assets/images/enemy-main/07.png",
                "assets/images/enemy-main/08.png",
                "assets/images/enemy-main/010.png",
                "assets/images/enemy-main/011.png",
                "assets/images/enemy-main/012.png",
                "assets/images/enemy-main/013.png",
                "assets/images/enemy-main/015.png",
                "assets/images/enemy-main/016.png",
                "assets/images/enemy-main/018.png",
                "assets/images/enemy-main/020.png",
                "assets/images/enemy-main/021.png"
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
}
