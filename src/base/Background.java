package base;

import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;
import base.scene.SceneStage2;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public boolean isEnd = false;

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,
                -(image.getHeight() - Settings.SCREEN_HEIGHT));
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        if (this.position.y >= 0) {
            //isEnd = true;
            return;
        } else {

            if (this.position.y > -Settings.SCREEN_HEIGHT - 600) {
                isEnd = true;
            }

            this.position.y += 3/*speed*/;
        }
        //System.out.println(isEnd);
    }
}
