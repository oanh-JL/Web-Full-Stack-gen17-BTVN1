package base.scene.gameoverscene;

import base.GameObject;
import base.scene.Scene;

public class GameOverScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        GameObject.recycle(Banner.class);
    }

    @Override
    public void run() {

    }
}
