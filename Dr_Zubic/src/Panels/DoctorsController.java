package Panels;
import Moduls.Doctors;
import Moduls.Time;
import Moduls.Users;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class DoctorsController implements Initializable {
    Time t = new Time();
    ObservableList<Doctors> doctori = Data.DataRep.getDoctors();
    Users selected;
    @FXML
    Label username;
    @FXML
    TableView<Doctors> table;
    @FXML
    TableColumn<Doctors,Integer> id;
    @FXML
    TableColumn<Doctors,String> name;
    @FXML
    TableColumn<Doctors,String> location;
    @FXML
    TableColumn<Doctors,Integer> start;
    @FXML
    TableColumn<Doctors,Integer> end;
    @FXML
    TableColumn<Doctors,String> contact;
    @FXML
    TextField drname;
    @FXML
    ComboBox hour;
    @FXML
    Button appoint;
    @FXML
    Label mess;
    @FXML
    DatePicker datepick;
    @FXML
    Button logout;
    @FXML
    Button appointment;
    public void initUser(Users u){
    selected=u;
    username.setText(selected.getUser());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        tableSetup();
        table.setOnMouseClicked((event) -> {
            drname.textProperty().bind(table.getSelectionModel().getSelectedItem().nameProperty());
            hour.setItems(Data.DataRep.workhours(table.getSelectionModel().getSelectedItem().getid()));
            
        });
        logout.setOnAction((event) -> {
            dr_zubic.Dr_Zubic.loadScene("login");
        });
        appoint.setOnAction((event) -> {
            LocalDate ld = datepick.getValue();
            String mes =Data.DataRep.appointment(table.getSelectionModel().getSelectedItem().getid(), t.pick(hour.getSelectionModel().getSelectedItem().toString(), String.valueOf(ld.getDayOfMonth()),String.valueOf(ld.getMonthValue()), String.valueOf(ld.getYear())),selected.getUser());
            mess.setText(mes);
        });
       appointment.setOnAction((event) -> {
           push(event);
       });
    }    
    public void tableSetup(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        start.setCellValueFactory(new PropertyValueFactory<>("start"));
        end.setCellValueFactory(new PropertyValueFactory<>("end"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        table.setItems(doctori);
    }
    
    public void push(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Appointment.fxml"));
        
        try {
            Parent p = loader.load();
            Scene s = new Scene(p);
            AppointmentController controler = loader.getController();
            controler.iniUser(selected);
            Stage st =(Stage)((Node)event.getSource()).getScene().getWindow();
            st.setScene(s);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(DoctorsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
