package Gameplay;

import Tools.Engine;
import Tools.GameObject;
import javafx.beans.property.IntegerProperty;
import javafx.scene.canvas.GraphicsContext;

public class Bulet extends GameObject{
     Batt b;
    public Bulet(Engine engine, int w, int h,  int speed,Batt b) {
        super(engine, w, h, speed);
        this.b=b;
    }
    @Override
    public void update(double delta) {
        setX(b.getX());
        setY(b.getY());
    }

    @Override
    public void render(GraphicsContext g) {
        g.fillOval(getX(), getY(), w, h);
    }
    
}
