package com.test;

import com.ym.hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-16 13:11
 **/

public class Test {
    public static void main(String[] args) {
        //1.加载配置文件
        Configuration configuration = new Configuration().configure();
        //hibernate.cfg.xml默认位于src根路径下
        //2.创建一个SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //3.创建Session对象
        Session session = sessionFactory.openSession();

        //4.开启事务
        Transaction transaction = session.beginTransaction();
        //5.执行相关操作
        Customer customer = new Customer();
        customer.setCust_name("alibaba");
        customer.setCust_phone("11111111");
        session.save(customer);
        //6.提交事务
        transaction.commit();
        //7.释放资源
        session.close();
        sessionFactory.close();
    }
}
