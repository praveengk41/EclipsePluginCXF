/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author praveen_kumatekar
 *
 */
public final class HibernateUtil {

	private static SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		}

		return sessionFactory;
	}
}
