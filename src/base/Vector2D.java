package base;

import java.util.Vector;

public class Vector2D {
    // Tạo ra 1 class vector có tọa độ x và y cùng các phương thức
    public float x;
    public float y;
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    /**
     * @return an other vector with same x & y
     */
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    /**
     *
     * @param x
     * @param y
     * @return return new vector = oldVector + passed arguments
     */
    //Add sẽ tạo 1 vector mới rồi cộng, ko làm ảnh hưởng đến vector gốc
    public Vector2D add(float x, float y) {
        Vector2D result = new Vector2D(this.x + x, this.y + y);
        return result;
    }

    //Add thẳng vào vector gốc
    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addThis(Vector2D other) {
        return this.addThis(other.x, other.y);
    }

    public Vector2D substract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D substract(Vector2D other) {
        return this.substract(other.x, other.y);
    }


    public Vector2D substractThis(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D substractThis(Vector2D other) {
        return this.substractThis(other.x, other.y);
    }


    /**
     * return new Vector = oldVector * n
     * @param n
     * @return
     */
    public Vector2D scale(float n) {
        return new Vector2D(this.x * n, this.y * n);
    }

    public Vector2D scaleThis(float n) {
        this.x *= n;
        this.y *= n;
        return this;
    }

    public Vector2D normalize() {
        return new Vector2D(this.x/this.length(), this.y/this.length());
    }

    /**
     * Tính đường chéo của 2 vector (2 điểm trên tọa độ)
     * @return vector's length
     */
    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public void print() {
        System.out.println(x + "; " + y);
    }

    //Override để print ra kết quả project
    @Override
    public String toString() {
        return "(x: " + x + "; y" + y + ")";
    }
}
