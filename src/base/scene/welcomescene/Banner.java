package base.scene.welcomescene;

import base.GameObject;
import base.Settings;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.*;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Banner extends GameObject {
    public Banner(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/wellcome.jpg");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDHT/2, Settings.SCREEN_HEIGHT/2);
    }
    @Override
    public void run() {
        if (KeyEventPress.isAnyKeyPress){
            SceneManager.signNewScene(new LastSceneStage());
        }
    }
}
