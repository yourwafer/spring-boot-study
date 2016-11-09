package com.tw.study.springboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by hwwei on 2016/11/9.
 */
@Service
public class RepositoryService {

    private final Logger logger = LoggerFactory.getLogger(RepositoryService.class);

    private AccountRepository repository;

    @Autowired
    public RepositoryService(AccountRepository repository) {
        this.repository = repository;
    }


    @PostConstruct
    void init() {
        Account wafer = repository.save(new Account("wafer"));
        logger.info(wafer.toString());

    }
}
