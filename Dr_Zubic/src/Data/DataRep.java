package Data;
import Moduls.Doctors;
import Moduls.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataRep {
       private static Connection getConn(){
           Connection conn = null;
           if(conn==null){
               try {
                   conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/Dr_Zubic", "root", "");
               } catch (SQLException ex) {
                   Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           return conn;
       }    
       public static ObservableList<Doctors> getDoctors(){
           Connection conn= getConn();
           ObservableList<Doctors> doctors= FXCollections.observableArrayList();
           try {
               PreparedStatement ps = conn.prepareStatement("select* from doctors");
               ResultSet rs =ps.executeQuery() ;
               while(rs.next()){
                Doctors d = new Doctors(rs.getInt("id"),rs.getString("name"),rs.getString("location"),rs.getInt("opens"),rs.getInt("closes"),rs.getString("contact"));
                doctors.addAll(d);
               }
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }
           return doctors;
}
       public static ObservableList<Integer>  workhours(int izabrani){
           ObservableList<Integer> startfinish = FXCollections.observableArrayList();
            Connection conn = getConn();
              int x=0,z=0;
               PreparedStatement ps;
               startfinish.clear();
           try {
               ps = conn.prepareStatement("select* from doctors where id =?");
               ps.setInt(1, izabrani);
               ResultSet rs =ps.executeQuery() ;
               while(rs.next()){
                 x= rs.getInt("opens");z=rs.getInt("closes");
               }
               for(int i = x;i<z;i++){
                  startfinish.add(i);
               }
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }
              return startfinish;}
       public static String appointment(int drid,String time,String user){
       Connection conn = getConn();
       String ok ="";
       boolean checker= checkAppointment(time);
           try {
               if(checker){
               PreparedStatement ps= conn.prepareStatement("insert into appointments(doctor_id,atime,username) values(?,?,?)");
               ps.setInt(1, drid);
               ps.setString(2, time);
               ps.setString(3, user);
               ps.execute();
               ok="Appointment made";
               }else
                   ok="We have another appointmant at this time";
                
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }finally{try {
               
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }
}
       
      return ok;
       }
       private static boolean checkAppointment(String time){
         Connection conn = getConn();
         boolean checker = true;  
         try {
               PreparedStatement ps =conn.prepareStatement("select* from appointments");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               if(time.equals(rs.getString("atime"))){
                   checker= false;               
                   return checker;}
               }
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }return checker;
           
       }
       public static boolean login(String u,String p){
       Connection conn = getConn();
       boolean access=false;
           try {
               PreparedStatement ps = conn.prepareStatement("select* from userlog where username=? and pass = ? ");
               ps.setString(1, u);
               ps.setString(2, p);
               ResultSet rs =ps.executeQuery();
               
                if(rs.next()){
                    access=true;
                    return access;
             } 
               
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }finally{
           try {
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }
}
       
      return access; }
       public static Users getUser(String u,String p){
        Users user=null;
         Connection conn = getConn();
          try {
         PreparedStatement ps =conn.prepareStatement("select* from userlog where username=? and pass=?");
         ps.setString(1, u);
         ps.setString(2, p);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
          user = new Users();
          user.setId(rs.getInt("id"));
          user.setUser(rs.getString("username"));
          user.setPass(rs.getString("pass"));
          return user;}

           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           } finally {try {
               conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
            }
}
       
       
       
       
       
       return user;
       }
       public static ObservableList<String> applist(String user){
        ObservableList<String> apoint= FXCollections.observableArrayList();
        Connection conn =getConn();
           try {
               PreparedStatement ps = conn.prepareStatement("select * from appointments where username=?");
               ps.setString(1, user);
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               apoint.addAll(rs.getString("username")+" has an appointment at: "+rs.getString("atime"));
               }
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }finally{try {
               conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
        
       return apoint;
       
       }
       public static String delAp(String user){
       Connection conn =getConn();
           try {
               PreparedStatement ps = conn.prepareStatement("delete from appointments where username=?");
               ps.setString(1, user);
               ps.execute();
           } catch (SQLException ex) {
               Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
           }finally{try {
               conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataRep.class.getName()).log(Level.SEVERE, null, ex);
            }
}
       
       return "appointment canceled";
       }
}
