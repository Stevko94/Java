
package Tools;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int w;
    public int h;
    private int x;
    private int y;
    public int speed;
    public Engine engine;
 public GameObject(Engine engine,int w,int h, int speed){
     this.w =w;
     this.h =h;
     this.speed =speed;

  this.engine=engine;
 }
 public abstract void update(double delta);
 public abstract void render(GraphicsContext g);

  
}
