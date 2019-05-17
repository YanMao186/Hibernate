package com.test;

import com.ym.hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-17 16:32
 **/

public class Dmeo4 {
    public static void main(String[] args) {
        Dmeo4 dmeo4 = new Dmeo4();
//        dmeo4.findById();
        dmeo4.page();
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        //查询所有的Customer对象
//        Query customer = session.createQuery("from Customer ");
//        List list = customer.list();
//        System.out.println(list);
    }

    public void findById() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        /**
         * ?后面的参数要与setParameter的参数保持一致,不一定要从0开始,不写会报异常
         * org.hibernate.QueryException: Legacy-style query parameters (`?`)
         */
        //定义HQL语句创建查询对象
        Query query = session.createQuery(" from Customer where cust_id = ?0 ");
        //设置参数
        query.setParameter(0, 1L);
        //根据查询对象获取查询结果
        Customer customer = (Customer) query.uniqueResult();
        System.out.println(customer);
        transaction.commit();
        session.close();

    }
    public void page() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //定义HQL语句
        String hql = "from Customer";
        Query query = session.createQuery(hql);
        //设置分页信息limit ? ,?
        //起始页
        query.setFirstResult(0);
        //每页显示数
        query.setMaxResults(2);
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();

    }
}
