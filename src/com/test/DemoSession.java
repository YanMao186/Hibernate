package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-17 16:25
 **/

public class DemoSession {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //返回同一个与线程绑定的session
        Session session1 = sessionFactory.getCurrentSession();
        Session session2 = sessionFactory.getCurrentSession();
        System.out.println(session1 == session2);
        //返回不同的session
        Session session3 = sessionFactory.openSession();
        Session session4 = sessionFactory.openSession();
        Query from_customer_ = session1.createQuery("from Customer ");
        List list = from_customer_.list();
        System.out.println(list);
        System.out.println(session3 == session4);
    }
}
