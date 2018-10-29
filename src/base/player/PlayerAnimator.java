package base.player;

import base.GameObject;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    Renderer straightAnimation;
    Renderer leftAnimation;
    Renderer rightAnimation;

    public PlayerAnimator() {
        this.straightAnimation = new AnimationRenderer(
                "assets/images/players/straight/0.png"
        );
        this.leftAnimation = new AnimationRenderer(
                "assets/images/players/left/0.png"
        );
        this.rightAnimation = new AnimationRenderer(
                "assets/images/players/right/0.png"
        );
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Player player = (Player)master;
        if(player.velocity.x > 0) {
            this.rightAnimation.render(g, master);
        } else if(player.velocity.x < 0) {
            this.leftAnimation.render(g, master);
        } else {
            this.straightAnimation.render(g, master);
        }
    }
}
