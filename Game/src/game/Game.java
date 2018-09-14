
package game;

import Gameplay.Batt;
import Gameplay.Bulet;
import Tools.Engine;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Game extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Engine eg = new Engine();
        Scene scene = new Scene(eg);
        stage.setScene(scene);
        eg.init();
        stage.show();
        Batt b = new Batt(eg, 50, 50, 5);
        Bulet bul = new Bulet(eg, 10, 10, 10,b);
        eg.objects.add(b);
        eg.objects.add(bul);
    }

    
}
