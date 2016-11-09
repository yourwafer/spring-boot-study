package com.tw.study.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by hwwei on 2016/11/9.
 */
@Component
public class JdbcTemplateService {

    private final Logger logger = LoggerFactory.getLogger(JdbcTemplateService.class);

    private JdbcTemplate template;

    @Autowired
    public JdbcTemplateService(JdbcTemplate template) {
        this.template = template;
    }

    @PostConstruct
    void init() throws SQLException {
        logger.info(template.getDataSource().getConnection().toString());
    }
}
