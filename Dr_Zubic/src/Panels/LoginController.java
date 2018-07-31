
package Panels;
import Moduls.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class LoginController implements Initializable {
    Users user;
    @FXML
    ImageView picture;
    @FXML
    TextField usertx;
    @FXML
    PasswordField passtx;
    @FXML
    Button login;
    @FXML
    Label wrong;
    @FXML
    Hyperlink create;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        picSetup();
       create.setOnAction((event) -> {
            try {
                java.awt.Desktop.getDesktop().browse(new URI("http://localhost:8080/Dr_Web/Cr.html"));
                
            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
            }
        });
        login.setOnAction((event) -> {
             String u=usertx.getText();
             String p=passtx.getText();
        boolean log =Data.DataRep.login(u, p);
        user= Data.DataRep.getUser(u, p);
            
         if(log){
             pusher(event);}
         else{ wrong.setText("Wrong username or password");}
        });
    }    
    public void picSetup(){
    File f = new File("nbproject/logo.png");
        try {
            Image i = new Image(new FileInputStream(f));
            picture.setImage(i);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public void pusher(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Doctors.fxml"));
        try {
            Parent p = loader.load();
            Scene s = new Scene(p);
            DoctorsController controler = loader.getController();
            controler.initUser(user);
            Stage st =(Stage)((Node)event.getSource()).getScene().getWindow();
            st.setScene(s);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
