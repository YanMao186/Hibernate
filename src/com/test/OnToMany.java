package com.test;

import com.ym.hibernate.Customer;
import com.ym.hibernate.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-17 21:07
 **/

public class OnToMany {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Customer customer = new Customer();
//        customer.setCust_name("严");
//        LinkMan linkMan1 = new LinkMan();
//        linkMan1.setLkm_name("李");
//        LinkMan linkMan2 = new LinkMan();
//        linkMan2.setLkm_name("王");
//        customer.getLinkMans().add(linkMan1);
//        customer.getLinkMans().add(linkMan2);
//        linkMan1.setCustomer(customer);
//        linkMan2.setCustomer(customer);
//        session.save(customer);
//        session.save(linkMan1);
//        session.save(linkMan2);
//        transaction.commit();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("严");
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("李");
        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkm_name("王");
        customer.getLinkMans().add(linkMan1);
        customer.getLinkMans().add(linkMan2);
        linkMan1.setCustomer(customer);
        linkMan2.setCustomer(customer);
        session.save(customer);
        transaction.commit();
    }
}
