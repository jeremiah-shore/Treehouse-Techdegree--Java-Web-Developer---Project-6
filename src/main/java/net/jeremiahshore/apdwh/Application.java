package net.jeremiahshore.apdwh;

import net.jeremiahshore.apdwh.model.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by Jeremiah on 8/1/2016.
 */
public class Application {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static void main(String[] args) {
        fetchAllCountries().forEach(System.out::println);
    }

    /**** SESSION FACTORY ****/
    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
        return new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    /**** DATA OPERATIONS ****/
    private static List<Country> fetchAllCountries() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Country.class);
        List<Country> allCountries = criteria.list();
        session.close();
        return allCountries;
    }
}
