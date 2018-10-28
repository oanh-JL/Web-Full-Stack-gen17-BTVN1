package base;

import base.physics.Physics;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();
    public static BufferedImage backBuffer = new BufferedImage(Settings.SCREEN_WIDHT
            , Settings.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    public static Graphics backBufferGraphics = backBuffer.createGraphics();

    //Hàm tạo đối tượng và add đối tượng vào mảng
    public static <E extends GameObject> E create(Class<E> childClass) {
        try {
            GameObject newGameObject = childClass.newInstance();
            newGameObjects.add(newGameObject);
            return (E)newGameObject;
        }catch (Exception e) {
            return null;
        }
    }

    public static <E extends GameObject> E recycle(Class<E> childClass) {
        //Kiểm tra có Game Object thỏa mãn yêu cầu
        //Có thì dùng lại
        //Không có tạo mới
        //Return Game Object
        for(GameObject go : gameObjects) {
            if(!go.isActive && go.getClass().isAssignableFrom(childClass)) {
                go.isActive = true;
                return (E)go;
            }
        }
        return create(childClass);
    }

    //Physics là đối tượng cần đc check va chạm
    public static <E extends GameObject> E intersect(Class<E> childClass, Physics physics) {
        for(GameObject go : gameObjects) {
            if(go.isActive && childClass.isAssignableFrom(go.getClass())
                    && go instanceof Physics) {
                Physics physicsGo = (Physics) go;
                boolean intersected = physics.getBoxCollider().intersect(physicsGo,
                        (GameObject) physics);
                if(intersected) {
                    return (E) physicsGo;
                }
            }
        }
        return null;
    }

    public static void runAll() {
        for(GameObject go : gameObjects) {
            if(go.isActive) {
                go.run();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAllToBackBuffer() {
        for(GameObject go : gameObjects) {
            if(go.isActive) {
                go.render(backBufferGraphics);
            }
        }
    }

    public static void renderBackBufferToGame(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public Renderer renderer;
    public Vector2D position;
    public boolean isActive;
    public Vector2D anchor;

    public GameObject() {
        this.isActive = true;
        this.anchor = new Vector2D(0.5f, 0.5f);
    }

    public void destroy() {
        this.isActive = false;
    }

    public void run() {

    }

    public void render(Graphics g) {
        if(this.renderer != null) {
            this.renderer.render(g, this);
        }
    }
}
