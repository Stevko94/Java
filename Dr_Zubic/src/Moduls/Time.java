
package Moduls;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Time {
     private static Date vreme ;
    private  SimpleDateFormat sdf ;
   public String pick(String hour,String day,String mount,String year){
       String picked=null;
       vreme = new Date();
       sdf= new SimpleDateFormat("HH:mm dd/MM/y");
       String izabrano=  hour+":"+"00"+" "+day+"/"+mount+"/"+year ;
        try {
          vreme =  sdf.parse(izabrano);
          picked =String.valueOf(sdf.format(vreme));
        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
            return picked;
   }
  
    
    
}
