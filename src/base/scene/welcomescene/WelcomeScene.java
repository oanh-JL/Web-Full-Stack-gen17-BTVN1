package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class WelcomeScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject banner = GameObject.recycle(Banner.class);
    }

    @Override
    public void run() {

    }
}
