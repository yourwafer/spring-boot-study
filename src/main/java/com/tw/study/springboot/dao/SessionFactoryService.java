package com.tw.study.springboot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by hwwei on 2016/11/9.
 */
public class SessionFactoryService {

    private final Logger logger = LoggerFactory.getLogger(SessionFactoryService.class);

    private SessionFactory sessionFactory;

    @Autowired
    public SessionFactoryService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Serializable angela = session.save(new Account("angela"));
        logger.info(angela.toString());
    }
}
