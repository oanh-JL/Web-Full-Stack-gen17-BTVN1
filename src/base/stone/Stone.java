package base.stone;

import base.GameObject;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;

public class Stone extends GameObject implements Physics {
    public Stone(){
        this.position = new Vector2D(200,200);
        //this.setPosition();
        this.collider = new BoxCollider(100, 100);
    }

    @Override
    public void setPosition() {
        super.setPosition();
    }

    @Override
    public void run() {
            this.position.y += 3/*speed*/;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
