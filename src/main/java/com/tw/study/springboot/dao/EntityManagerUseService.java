package com.tw.study.springboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by hwwei on 2016/11/9.
 */
@Service
public class EntityManagerUseService {

    private final Logger logger = LoggerFactory.getLogger(EntityManagerUseService.class);
    private EntityManagerService entityManagerService;

    public EntityManagerUseService(EntityManagerService entityManagerService) {
        this.entityManagerService = entityManagerService;
    }

    @PostConstruct
    public void init() {
        entityManagerService.save(new Account("angela----123"));
    }
}
