/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.service;

import com.psl.dao.GitHubAuthenticationDAO;
import com.psl.dao.GitHubAuthenticationDAOImpl;
import com.psl.model.GitHubUser;

/**
 * @author Praveen GK
 *
 */
public class GitHubAuthenticationService implements
		GitHubAuthenticationServiceImpl {

	public void save(GitHubUser gitHubUser) {
		GitHubAuthenticationDAOImpl gitHubDAOImpl = new GitHubAuthenticationDAO();
		gitHubDAOImpl.save(gitHubUser);

	}

}
