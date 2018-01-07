package com.example.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by shen on 2018/1/4.
 * Entity实体类方法,生成数据库对应的表字段
 */

//这个类对应的就是数据库的类,会生成对应的字段
@Entity
public class Girl {
//    @Entity表示对应数据库的一个表
//    @GeneratedValue 自增的id
    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl(){
    }
}
