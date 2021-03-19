package dao;

import hib.NoticeEntity;
import hib.StudInfoEntity;
import hib.StudSchoolEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class stuDAO {
    public StudInfoEntity select1(String use) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudInfoEntity stu = null;
        try {
            stu = session.get(StudInfoEntity.class, use);
            System.out.println("调用hibernate操作：");
            if (stu != null) System.out.println("采用Hibernate查询学生信息得到的结果如：" + stu.getSno() + "   " + stu.getSname());
        }catch (Exception e){
            e.printStackTrace();
        }
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return stu;
    }

    public StudInfoEntity updateINFO(StudInfoEntity stu) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        session.saveOrUpdate(stu);
        System.out.println("调用hibernate操作：");
        if (stu != null) System.out.println("采用Hibernate更新学生信息后得到的结果如：" + stu.getSno() + "   " + stu.getSname());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return stu;
    }

    public StudSchoolEntity selectSchool(String userName) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudSchoolEntity stu=null;
        try {
            stu = session.get(StudSchoolEntity.class, userName);
            System.out.println("调用hibernate操作：");
            if (stu != null) System.out.println("采用Hibernate查询在校信息得到的结果如：" + stu.getSno() + "   " + stu.getDeptName());
        }catch (Exception e){
            e.printStackTrace();
        }
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return stu;
    }

    public StudSchoolEntity updateSchool(StudSchoolEntity user) {
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
        if (user != null) System.out.println("采用Hibernate在校信息更新后得到的结果如：" + user.getSno() + "   " + user.getDeptName());
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        //标准流程如上所示
        return user;
    }

    public List<NoticeEntity> listNotice() {
        String hql = "from NoticeEntity order by date";
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        List<NoticeEntity> tmp = (List<NoticeEntity>) session.createQuery(hql).list();
        System.out.println("调用hibernate操作：");
        System.out.println("查询全部通知操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }
}
