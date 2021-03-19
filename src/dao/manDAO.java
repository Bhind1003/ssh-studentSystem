package dao;

import hib.NoticeEntity;
import hib.StudInfoEntity;
import hib.StudSchoolEntity;
import hib.StudentLogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class manDAO {
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

    public List<NoticeEntity> findNotice(String id) {
        String cond = "%" + id + "%";
        String hql = "from NoticeEntity where date like :cond or info like :cond order by date";
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        Query query = session.createQuery(hql);
        query.setParameter("cond", cond);
        List tmp = query.list();
        System.out.println("调用hibernate操作：");
        System.out.println("搜索通知操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public NoticeEntity deleteNotice(String id) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        NoticeEntity tmp = (NoticeEntity) session.get(NoticeEntity.class, id);
        if(tmp!=null)session.delete(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("删除通知操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public NoticeEntity selectOne(String id) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        NoticeEntity tmp = (NoticeEntity) session.get(NoticeEntity.class, id);
        System.out.println("调用hibernate操作：");
        System.out.println("获取单个通知操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public NoticeEntity saveNotice(NoticeEntity tmp) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        session.saveOrUpdate(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("添加修改通知操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public List<StudSchoolEntity> listSchool(String kind,String id) {
        String cond = "%" + id + "%";
        String hql = "from StudSchoolEntity where "+kind+" like :cond order by sno";
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        if (id == null) {
            hql = "from StudSchoolEntity order by sno";
        }
        Query query = session.createQuery(hql);
        if (id != null) {
            query.setParameter("cond", cond);
        }
        List tmp = query.list();
        System.out.println("调用hibernate操作：");
        System.out.println("搜索学生在校信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public StudSchoolEntity deleteSchool(String id) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudSchoolEntity tmp = (StudSchoolEntity) session.get(StudSchoolEntity.class, id);
        session.delete(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("删除学生在校信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public List<StudInfoEntity> listStu(String kind,String id) {
        String cond = "%" + id + "%";
        String hql = "from StudInfoEntity where "+kind+" like :cond order by "+kind;
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        if (id == null) {
            hql = "from StudInfoEntity order by sno";
        }
        Query query = session.createQuery(hql);
        if (id != null) query.setParameter("cond", cond);
        List tmp = query.list();
        System.out.println("调用hibernate操作：");
        System.out.println("搜索学生个人信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public void saveLog(String sno, String pass) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudentLogEntity tmp = new StudentLogEntity();
        tmp.setSno(sno);
        tmp.setPassword(pass);
        session.saveOrUpdate(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("添加学生登录信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
    }

    public StudInfoEntity deleteInfo(String id) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudInfoEntity tmp = (StudInfoEntity) session.get(StudInfoEntity.class, id);
        if(tmp!=null)session.delete(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("删除学生个人信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
        return tmp;
    }

    public void deleteLog(String sno) {
        // 1.创建Configuration对象并加载hibernate.cfg.xml配置文件
        Configuration config = new Configuration().configure();
        // 2.获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 3.得到一个Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.执行持久化操作
        StudentLogEntity tmp = session.get(StudentLogEntity.class,sno);
        session.delete(tmp);
        System.out.println("调用hibernate操作：");
        System.out.println("删除学生登录信息操作");
        // 6.提交事务
        transaction.commit();
        // 7.关闭资源
        session.close();
        sessionFactory.close();
    }
}
