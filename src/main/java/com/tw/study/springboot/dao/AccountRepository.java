package com.tw.study.springboot.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hwwei on 2016/11/9.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
