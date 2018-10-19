
package Ent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import serv.FController;

public class TopicDao {
    @Autowired
    DataSource dataSource;
    public List<Topic> findAll(int gid){
     List<Topic> topics = new ArrayList<>();
        try {
            Connection conn =dataSource.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from topic where genre_id="+gid);
            while(rs.next()){
                Topic t = new Topic();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                topics.add(t);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return topics;
    }
    public Topic find (int id){
    Connection conn;
    Topic t=null;
        try {
            conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery("select * from topic where id ="+id);
             if(rs.next()){
             t = new Topic();
             t.setId(rs.getInt("id"));
             t.setTitle(rs.getString("title"));
             t.setDescription(rs.getString("description"));
    return t;
    }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDao.class.getName()).log(Level.SEVERE, null, ex);
        }return t; }
            }
