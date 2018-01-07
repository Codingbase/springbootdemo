package com.example.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    // 定义Min表示有个参数参考
    @Min(value = 18, message = "未成年禁止入内")
    private Integer age;
    @NotNull(message = "金额必传")
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

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

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
