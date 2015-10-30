/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.psl.model.GitHubUser;
import com.psl.util.HibernateUtil;

/**
 * @author praveen_kumatekar
 *
 */
public class GitHubAuthenticationDAO implements GitHubAuthenticationDAOImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.psl.dao.GitHubDAOImpl#save(com.psl.model.GitHubUser)
	 */
	public void save(GitHubUser gitHubUser) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(gitHubUser);
		session.getTransaction().commit();
		session.close();
	}

}
