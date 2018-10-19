
package serv;

import Ent.Comments;
import Ent.CommentsDao;
import Ent.Genre;
import Ent.GenreDao;
import Ent.Topic;
import Ent.TopicDao;
import java.util.List;
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
    GenreDao Genre;
    @RequestMapping("/")
    public String bas(ModelMap mm){
    List<Genre> genres= Genre.findAll();
    mm.put("Genres",genres);
    return"Home";
    }
    @RequestMapping("/Topics/{id}")
    public String home(@PathVariable(value="id")Integer id,ModelMap mm){
        List<Topic> topic = Top.findAll(id);
        mm.put("topics", topic);
    return "Topics";
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
