package base;

import base.GameObject;
import base.Vector2D;
import base.renderer.AnimationRenderer;

public class Explosion extends GameObject {
    public Explosion() {
        this.position = new Vector2D();
        this.renderer = new AnimationRenderer(
                15, true,
                "assets/images/explosion/explosion1.png",
                "assets/images/explosion/explosion2.png",
                "assets/images/explosion/explosion3.png",
                "assets/images/explosion/fire1.png",
                "assets/images/explosion/fire2.png"
        );
    }
}