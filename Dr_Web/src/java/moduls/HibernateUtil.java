
package moduls;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sf;
    private static ServiceRegistry sr;
    public static SessionFactory getSF(){
        if(sf==null){
        Configuration conf = new Configuration();
        conf.configure();
        sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        sf =conf.buildSessionFactory(sr);
        }
         return sf;
    }
}
