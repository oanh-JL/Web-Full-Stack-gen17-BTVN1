package base.enemy;

import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        super();
        this.renderer = new AnimationRenderer(
            "assets/images/enemy-main/0.png"
        );
        this.collider = new BoxCollider(30, 51);
    }

    @Override
    public void takeDamage(int damage) {
        if(damage > 0) {
            this.destroy();
        }
    }
}
