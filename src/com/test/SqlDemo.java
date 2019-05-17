package com.test;

import com.ym.hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-17 17:54
 **/

public class SqlDemo {
    public static void main(String[] args) {
    SqlDemo sd = new SqlDemo();
    sd.findAll();
    sd.findById();
        sd.findpage();
    }
    /**
     * 查询全部
     */
    public void findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from cst_customer";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Customer.class);
        List<Customer> list = sqlQuery.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();
    }

    /**
     * 根据id查询
     */
    public void findById() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from cst_customer where cust_id = ?0";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setParameter(0,1L);
        sqlQuery.addEntity(Customer.class);
        List<Customer> list = sqlQuery.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();
    }

    /**
     * 分页查询
     */
    public void findpage() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from cst_customer limit ?0,?1 ";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
      sqlQuery.setParameter(0,0);
      sqlQuery.setParameter(1,1);
        sqlQuery.addEntity(Customer.class);
        List<Customer> list = sqlQuery.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();
    }
}
