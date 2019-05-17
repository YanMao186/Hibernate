package com.ym.hibernate;

import javax.persistence.*;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-16 13:04
 **/
//声明当前类为实体类
@Entity
//指定当前类与数据库表的映射关系
@Table(name = "cst_customer")
public class Customer {
//用于指定主键
@Id
//用于指定主键的生成策略,GenerationType.IDENTITY为mysql默认的
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;

    private String cust_name;
    private String cust_source;
    private String cust_industry;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;
    public Long getCust_id() {
        return cust_id;
    }
    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public String getCust_source() {
        return cust_source;
    }
    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }
    public String getCust_industry() {
        return cust_industry;
    }
    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }
    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }
    public String getCust_phone() {
        return cust_phone;
    }
    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }
    public String getCust_mobile() {
        return cust_mobile;
    }
    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_source='" + cust_source + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_linkman='" + cust_linkman + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                '}';
    }
}
