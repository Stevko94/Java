
package Ent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreDao {
    @Autowired
    DataSource dataSource;
    public List<Genre> findAll(){
     List<Genre> genres = new ArrayList<>();
        try {
            Connection conn =dataSource.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from genre");
            while(rs.next()){
                Genre g = new Genre();
                g.setId(rs.getInt("id"));
                g.setTitle(rs.getString("title"));
                genres.add(g);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return genres;
    }
}
