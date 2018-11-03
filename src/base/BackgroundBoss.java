package base;

import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.LastSceneStage;
import base.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundBoss extends GameObject {
    boolean isEnd;

    public BackgroundBoss() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,
                -(image.getHeight() - Settings.SCREEN_HEIGHT));
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        if(this.position.y>0){
            if(KeyEventPress.isAnyKeyPress){
                SceneManager.signNewScene(new LastSceneStage());
            }
            return;
        }
        else {
            if (this.position.y > -Settings.SCREEN_HEIGHT -200) {
                isEnd = true;
            }

            this.position.y += 3/*speed*/;
        }


    }
}
