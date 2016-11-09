package com.tw.study.springboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * Created by hwwei on 2016/11/9.
 */
@Transactional
@Service
public class EntityManagerService {

    private final Logger logger = LoggerFactory.getLogger(EntityManagerService.class);

    private EntityManager entityManager;

    @Autowired
    public EntityManagerService(EntityManager sessionFactory) {
        this.entityManager = sessionFactory;
    }

    public void save(Object t){
        entityManager.persist(t);
    }
}
