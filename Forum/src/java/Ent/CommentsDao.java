package Ent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentsDao {
    @Autowired
    DataSource dataSource;
    public List<Comments> findAll(int id){
    List<Comments> coms= new ArrayList<>();
    Connection conn;
        try {
            conn = dataSource.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from comments where topic_id ="+id);
             while(rs.next()){
               Comments c = new Comments();
               c.setId(rs.getInt("id"));
               c.setCom(rs.getString("com"));
               c.setTopicId(rs.getInt("topic_id"));
               coms.add(c);
        } 
            } catch (SQLException ex) {
            Logger.getLogger(CommentsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return coms;}
    public void createComm(String topic_id,String comment){
    try {
        PreparedStatement ps;
        Connection conn;
              conn = dataSource.getConnection();
              ps = conn.prepareStatement("insert into comments(com,topic_id) values(?,?)");
              ps.setString(1, comment);
                 ps.setInt(2, Integer.parseInt(topic_id));
                 ps.execute();
          } catch (SQLException ex) {
          }
    }
}
