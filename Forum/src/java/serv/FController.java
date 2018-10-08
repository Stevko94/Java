
package serv;

import Ent.Comments;
import Ent.CommentsDao;
import Ent.Topic;
import Ent.TopicDao;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FController {
    @Autowired
    TopicDao Top;
    @Autowired
    CommentsDao Comments;
    @Autowired
    DataSource dataSource;
    @RequestMapping("/")
    public String home(ModelMap mm){
        List<Topic> topic = Top.findAll();
        mm.put("topics", topic);
    return "index";
    } 
   
    @RequestMapping(value = "/{id}")
    public String topic(@PathVariable(value="id") Integer id, ModelMap mm,@RequestParam(required = false,value = "Comment") String com,@RequestParam(required = false,value = "topic_id") String topic_id){    
      List<Comments> coms= Comments.findAll(id);
        Topic t = Top.find(id);
             mm.put("topic", t);
             mm.put("coments", coms);
        if(com!=null){
            Comments.createComm(topic_id, com);
                 }
     
    return "Topic";}
    
}
