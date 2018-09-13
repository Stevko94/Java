
package Tools;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    public int w;
    public int h;
    public int x;
    public int y;
    public int speed;
    public Engine engine;
 public GameObject(Engine engine,int w,int h,int x, int y, int speed){
     this.w =w;
     this.h =h;
     this.x =x;
     this.y =y;
     this.speed =speed;

  this.engine=engine;
 }
 public abstract void update(double delta);
 public abstract void render(GraphicsContext g);

  
}
