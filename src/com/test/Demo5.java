package com.test;

import com.ym.hibernate.Customer;
import com.ym.hibernate.LinkMan;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * @program: hibernatedemo
 * @description:
 * @author: Mr.Yan
 * @create: 2019-05-18 09:41
 **/

public class Demo5 {

    @Test
    /**
     * 对象图导航检索
     */
    public void Object()  {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LinkMan linkMan = session.get(LinkMan.class, 4L);
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
        transaction.commit();
        session.close();
    }
    @Test
    /**
     * OID检索
     */
    public void Oid() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 2L);
        LinkMan linkMan = session.load(LinkMan.class, 4L);
        System.out.println(customer);
        System.out.println(linkMan);
        transaction.commit();
        session.close();
    }
    @Test
    /**
     * HQL基本检索
     */
    public void Hql() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //查询全部
        String hql = "from Customer";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        //排序查询
        String hqlOrderBy = "from Customer order by cust_id desc";
        Query query1 = session.createQuery(hqlOrderBy);
        List<Customer> list1 = query1.list();
        for (Customer customer : list1) {
            System.out.println(customer);
        }
        //条件查询
        String hqlWhereName = "from Customer where cust_name = ?0";
        Query query2 = session.createQuery(hqlWhereName);
        Query alibaba = query2.setParameter(0, "alibaba");
        List<Customer> list2 = alibaba.list();
        for (Customer customer : list2) {
        System.out.println(customer);
        }
        //分页检索
        String limitHql = "from Customer order by cust_id desc ";
        Query query3 = session.createQuery(limitHql);
        //起始页
       query3.setFirstResult(1);
       //显示数量
       query3.setMaxResults(2);
        List<Customer> list3 = query3.list();
        for (Customer customer : list3) {
            System.out.println(customer);
        }
        //统计查询
        String CountHql = "select count(*) from Customer";
        Query query4 = session.createQuery(CountHql);
        Long num = (Long) query4.uniqueResult();
        System.out.println("共查询到"+num);

        //投影检索
        //投影查询一列
        List<String> list4 = session.createQuery("select cust_name from Customer").list();
        for (String s : list4) {
            System.out.println(s);
        }
        transaction.commit();
        session.close();
    }
    @Test
    public void Qbc() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        Criteria custId = criteria.add(Restrictions.eq("cust_id", 1L));
        List list = custId.list();
        System.out.println(list);
        transaction.commit();
        session.close();
    }
    @Test
    public void DetachedCriteria() {
        //获得一个离线条件查询的对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.eq("cust_name","alibaba"));
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //离线条件查询对象与session绑定
        List<Customer> list = detachedCriteria.getExecutableCriteria(session).list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        session.close();
    }
}
