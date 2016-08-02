package net.jeremiahshore.apdwh;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/** Created by Jeremiah Shore at 8/1/2016 19:35. **/
public class Application {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static void main(String[] args) {
        //fetchAllCountries().forEach(System.out::println);
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

}
