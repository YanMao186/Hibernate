package com.test;

import com.ym.hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @program: hibernatedemo
 * @description:测试对象的三种状态
 * @author: Mr.Yan
 * @create: 2019-05-17 10:34
 **/

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.fun();
    }

    private void fun() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Customer customer = new Customer(); //没有id,没有与session关联,瞬时状态
//        customer.setCust_name("Lenovo"); //瞬时状态
//        session.save(customer);    //持久化状态,有id,有关联
        Customer customer = session.get(Customer.class, 2L);
//        customer.setCust_name("sum");
        System.out.println(customer);
        Customer customer1 = session.get(Customer.class, 2L);
        System.out.println(customer1);
        System.out.println(customer == customer1);
        transaction.commit();
        session.close();   //游离|托管,有id,没有关联
    }
}
