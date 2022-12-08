import models.Gender;
import models.Yakuza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Yakuza.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        /*session.save(new Yakuza("Kiryu","Kazuma"));
        session.save(new Yakuza("Majima","Goro"));
        session.save(new Yakuza("Taiga","Saejima"));
        session.save(new Yakuza("Akiyama"));*/
        session.save(new Yakuza("Haruka","Sawamura", Gender.FEMALE));
        session.getTransaction().commit();
        List<Yakuza> yakuzaList= session.createQuery("select y from Yakuza y", Yakuza.class).list();
        System.out.println(yakuzaList);
        session.close();
        sessionFactory.close();
    }
}
