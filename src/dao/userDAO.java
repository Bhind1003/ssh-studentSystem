package dao;

import hib.ManagerLogEntity;
import hib.StudentLogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class userDAO {
    public StudentLogEntity select1(String name){
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudentLogEntity user = (StudentLogEntity) session.get(StudentLogEntity.class,name);
        System.out.println("调用hibernate操作：");
        if(user!=null)System.out.println("采用Hibernate查询得到的结果如："+user.getSno() + "   " + user.getPassword());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return user;
    }
    public StudentLogEntity saveStuPass(StudentLogEntity user){
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        session.saveOrUpdate(user);
        System.out.println("调用hibernate操作：");
        if(user!=null)System.out.println("采用Hibernate储存后查询得到的结果如："+user.getSno() + "   " + user.getPassword());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return user;
    }
    public ManagerLogEntity select2(String name){
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        ManagerLogEntity user = (ManagerLogEntity) session.get(ManagerLogEntity.class,name);
        System.out.println("调用hibernate操作：");
        if(user!=null)System.out.println("采用Hibernate查询得到的结果如："+user.getMno() + "   " + user.getPassword());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return user;
    }
    public ManagerLogEntity saveManPass(ManagerLogEntity user){
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        session.saveOrUpdate(user);
        System.out.println("调用hibernate操作：");
        if(user!=null)System.out.println("采用Hibernate储存后查询得到的结果如："+user.getMno() + "   " + user.getPassword());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return user;
    }
}
