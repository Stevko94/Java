
package serv;

import Ent.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FController {
    @Autowired
    DataSource dataSource;
    @RequestMapping("/")
    public String home(ModelMap mm){
        List<Topic> topic = new ArrayList<>();
        try {
            Connection conn =dataSource.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from topic");
            while(rs.next()){
                Topic t = new Topic();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                topic.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mm.put("topics", topic);
    return "index";
    } 
    @RequestMapping("/{id}")
    public String topic(@PathVariable(value="id") Integer id, ModelMap mm, @RequestParam(required = false) String com){
      Connection conn;
      String comment= com;
        try {
            conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery("select * from topic where id ="+id);
             if(rs.next()){
             Topic t = new Topic();
             t.setTitle(rs.getString("title"));
             t.setDescription(rs.getString("description"));
             mm.put("topic", t);
             if(comment!=null){
                 PreparedStatement ps = conn.prepareStatement("insert into comments(com,topic_id) values("+comment+","+t.getId()+")");
                 ps.execute();
             }}
             
        } catch (SQLException ex) {
            Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    return "Topic";}
    
}
