package com.tw.study.springboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        template.execute("select ''", new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData meta = resultSet.getMetaData();
                int columnCount = meta.getColumnCount();
                String columnClassName = meta.getColumnClassName(1);
                logger.info(columnCount + "->" + columnClassName);

                return null;
            }
        });
        logger.info("--------------" + template.getDataSource().getConnection().toString());
    }
}
