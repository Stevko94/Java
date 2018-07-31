package Moduls;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctors {
    SimpleIntegerProperty id;
    public void idproparty(){}
    SimpleStringProperty name;
    SimpleStringProperty location;
    SimpleIntegerProperty start;
    SimpleIntegerProperty end;
    SimpleStringProperty contact;
    public Doctors(int id,String name,String location,int start,int end,String contact){
    this.id = new SimpleIntegerProperty(id);
    this.name = new SimpleStringProperty(name);
    this.location = new SimpleStringProperty(location);
    this.start = new SimpleIntegerProperty(start);
    this.end =new SimpleIntegerProperty(end);
    this.contact = new SimpleStringProperty(contact);
    }
    
    public int getid(){return this.id.get();}
    
    public String getname(){return this.name.get();}
    
    public String getlocation(){return this.location.get();}
   
    public int getstart(){return this.start.get();}
    
    public int getend(){return this.end.get();}
    
    public String getcontact(){return this.contact.get();}
    
    
    
    public void setId(int k){id.setValue(k);}
    public void setName(String k){name.setValue(k);}
    public void setLocation(String k){location.setValue(k);}
    public void setStart(int k){start.setValue(k);}
    public void setEnd(int k){end.setValue(k);}
    public void setContact(String k){contact.setValue(k);}
    public IntegerProperty idProperty(){return id;}
    public StringProperty nameProperty(){return name;}
    public StringProperty locationProperty(){return location;}
    public IntegerProperty startProperty(){return start;}
    public IntegerProperty endProperty(){return end;}
    public StringProperty contactProperty(){return contact;}
    

   
}
