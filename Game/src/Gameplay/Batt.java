
package Gameplay;

import Tools.Engine;
import Tools.GameObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Batt extends GameObject{

    public Batt(Engine engine, int w, int h, int speed) {
        super(engine, w, h, speed);
    }
    
    
    @Override
    public void update(double delta) {
        if(getY()<(engine.gameh-h)){setY((int) (getY() + (3*delta)));}
        if(engine.keypool.contains(KeyCode.UP)){setY((int) (getY() - (10*delta)));}
        if(engine.keypool.contains(KeyCode.LEFT)){setX((int) (getX() - (speed*delta)));}
        if(engine.keypool.contains(KeyCode.RIGHT)){setX((int) (getX() + (speed*delta)));}
    }

    @Override
    public void render(GraphicsContext g) {
        File f = new File("src/mario.jpg");
        try {
            FileInputStream fi = new FileInputStream(f);
             Image i = new Image(fi);
             g.drawImage(i, getX(), getY(), w, h);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Batt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
