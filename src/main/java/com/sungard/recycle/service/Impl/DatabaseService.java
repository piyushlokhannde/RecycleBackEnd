package com.sungard.recycle.service.Impl;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {
    private SessionFactory hibernateFactory;

    @Autowired
    public DatabaseService(EntityManagerFactory factory) {
      if(factory.unwrap(SessionFactory.class) == null){
        throw new NullPointerException("factory is not a hibernate factory");
      }
      this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    /**
     * @return the hibernateFactory
     */
    public SessionFactory getHibernateFactory() {
        return hibernateFactory;
    }

    /**
     * @param hibernateFactory the hibernateFactory to set
     */
    public void setHibernateFactory(SessionFactory hibernateFactory) {
        this.hibernateFactory = hibernateFactory;
    }
    
    
}
