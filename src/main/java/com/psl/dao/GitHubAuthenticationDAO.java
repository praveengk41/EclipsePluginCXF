/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.psl.model.GitHubUser;
import com.psl.util.HibernateUtil;

/**
 * @author Praveen GK
 *
 */
public class GitHubAuthenticationDAO implements GitHubAuthenticationDAOImpl {

	public void save(GitHubUser gitHubUser) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(gitHubUser);
		session.getTransaction().commit();
		session.close();
	}

}
