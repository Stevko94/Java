package Tools;

import Gameplay.Batt;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class Engine extends VBox{
    public int gamew = 800;
    public int gameh = 600;
    public Canvas canvas;
    GraphicsContext gc;
    public List<GameObject> objects= new LinkedList<>();
    public Set<KeyCode> keypool = new HashSet<>();
    double last_time = System.nanoTime();
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            double delta_time = (l - last_time) ;
            mainLoop(delta_time/ 10000000);
             last_time = l;
        }
    };
    public void mainLoop(double delta){
    this.canvas.getGraphicsContext2D().clearRect(0, 0, gamew,gameh);
    for(GameObject o: objects){
    o.update(delta);
    }
    for(GameObject o: objects){
    o.render(this.canvas.getGraphicsContext2D());
    }
    }
   
    
    public Engine(){
    canvas = new Canvas(gamew, gameh);
    
    }
    public void init(){
        this.requestFocus();
        this.setOnKeyPressed((t) -> {
            keypool.add(t.getCode());
        });
        this.setOnKeyReleased((t) -> {
            keypool.clear();
        });
        this.getChildren().add(this.canvas);
        this.timer.start();
    }
    
}
