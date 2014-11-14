package com.jygj.admin.common;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configure = new Configuration();
			if (!ResourceUtils.isProdEnvConfig()) {
				configure = configure.configure();// default cfg xml
			} else {
				configure = configure.configure(new File(ResourceUtils.getProdCfgXml()));
			}

			sessionFactory = configure
					.buildSessionFactory(new ServiceRegistryBuilder()
							.applySettings(configure.getProperties())
							.buildServiceRegistry());
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object load(Class<?> claz, Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		Object returnObj = session.load(claz, id);

		tran.commit();
		HibernateSessionFactory.closeSession(session);

		return returnObj;
	}

	public static Object get(Class<?> claz, Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		Object returnObj = session.get(claz, id);

		tran.commit();
		HibernateSessionFactory.closeSession(session);

		return returnObj;
	}

	public static List<?> find(Object[] params, String hql) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<?> list = query.list();

		tran.commit();
		HibernateSessionFactory.closeSession(session);

		return list;
	}

	public static void add(Object paramObj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		session.save(paramObj);

		tran.commit();
		HibernateSessionFactory.closeSession(session);
	}

	public static void save(Object paramObj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		session.saveOrUpdate(paramObj);

		tran.commit();
		HibernateSessionFactory.closeSession(session);
	}

	public static List<?> list(String hql) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery(hql);
		List<?> list = query.list();

		tran.commit();
		HibernateSessionFactory.closeSession(session);

		return list;
	}

	public static void delete(Class<?> claz, Integer id) {
		// 1.建立一个与数据库进行连接的会话对象
		Session session = HibernateSessionFactory.getSession();
		// 2.开启一个数据库事务
		Transaction tran = session.beginTransaction();
		// 3.执行数据库的操作
		Object object = get(claz, id);
		session.delete(object);
		// 4.提交事务（保证数据库原子性操作）
		tran.commit();
		// 5.关闭与数据库连接的会话对象
		HibernateSessionFactory.closeSession(session);
	}

	public static void batchDelete(Class<?> claz, List<Integer> idList) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();

		String hql = "delete " + claz.getSimpleName() + " where id in(?)";
		Query query = session.createQuery(hql);
		query.setParameter(0, StringUtils.join(idList, ","));
		query.executeUpdate();

		tran.commit();
		HibernateSessionFactory.closeSession(session);
	}

	private static Session getSession() {
		Session session = null;
		if (null == session || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	private static void closeSession(Session session) {
		if (null != session && session.isOpen()) {
			session.close();
		}
	}

}