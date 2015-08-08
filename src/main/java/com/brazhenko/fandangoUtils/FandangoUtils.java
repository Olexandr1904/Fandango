package com.brazhenko.fandangoUtils;

import com.brazhenko.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Admin on 07.07.2015.
 */
public class FandangoUtils {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            configuration.addAnnotatedClass(Cinemas.class);
            configuration.addAnnotatedClass(Movie.class);
            configuration.addAnnotatedClass(Schedule.class);
            configuration.addAnnotatedClass(Tickets.class);
            configuration.addAnnotatedClass(User.class);

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings
                    (configuration.getProperties()).build();

            factory =configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex){
            System.out.print("Failed to create Session " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFacory(){
        return factory;
    }

}
