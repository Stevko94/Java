package dr_zubic;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Dr_Zubic extends Application{
    public static Stage primary;
    public static void loadScene(String fxml){
        Pane root;
        try {
             root = (Pane)FXMLLoader.load(Dr_Zubic.class.getResource("/Panels/"+fxml+".fxml"));
             Scene scene = new Scene(root);
             primary.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Dr_Zubic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
 }
    public static void main(String[] args) {
        launch(args);
    }

   @Override
    public void start(Stage primaryStage) throws Exception {
       primary=primaryStage;
       loadScene("Login");
       primary.show();
        
   
   }
    
}
