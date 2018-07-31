package Panels;
import Moduls.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppointmentController implements Initializable {
  Users selected;
@FXML
Label username;
@FXML
ListView<String> list;
@FXML
Button back;
@FXML
Button delete;
@FXML
Label cancel;
public void iniUser(Users u){
    selected=u;
    username.setText(selected.getUser());
    ObservableList<String> appointment=Data.DataRep.applist(selected.getUser());
    list.getItems().addAll(appointment);
    
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delete.setOnAction((event) -> {
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
      cancel.setText(Data.DataRep.delAp(selected.getUser()));
    });
        back.setOnAction((event) -> {
        dr_zubic.Dr_Zubic.loadScene("Login");
        });
    }  
   
   
}
