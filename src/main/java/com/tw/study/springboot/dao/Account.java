package com.tw.study.springboot.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hwwei on 2016/11/9.
 */
@Entity
@Table(name = "Account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", length = 30)
    private String name;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        return name != null ? name.equals(account.name) : account.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
