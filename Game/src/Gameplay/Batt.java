
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

    public Batt(Engine engine, int w, int h, int x, int y, int speed) {
        super(engine, w, h, x, y, speed);
    }
    
    
    @Override
    public void update(double delta) {
        if(y<(engine.gameh-h)){y+=(3*delta);}
        if(engine.keypool.contains(KeyCode.UP)){y-=(10*delta);}
        if(engine.keypool.contains(KeyCode.LEFT)){x-=(speed*delta);}
        if(engine.keypool.contains(KeyCode.RIGHT)){x+=(speed*delta);}

        
    }

    @Override
    public void render(GraphicsContext g) {
        File f = new File("src/mario.jpg");
        try {
            FileInputStream fi = new FileInputStream(f);
             Image i = new Image(fi);
             g.drawImage(i, x, y, w, h);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Batt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
