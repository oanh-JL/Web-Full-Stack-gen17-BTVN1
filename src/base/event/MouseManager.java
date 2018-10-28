package base.event;

import base.Vector2D;

import java.awt.event.MouseEvent;

public class MouseManager {
    public boolean isPressed;
    public Vector2D position = new Vector2D();

    public static MouseManager mouseManager = new MouseManager();

    public void mousePressed(MouseEvent e) {
        isPressed = true;
        this.position.set(e.getX(),e.getY());
    }

    public void mouseRelease(MouseEvent e) {
        isPressed = false;
    }

}
