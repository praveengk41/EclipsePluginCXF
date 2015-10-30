/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.service;

import com.psl.dao.GitHubAuthenticationDAO;
import com.psl.dao.GitHubAuthenticationDAOImpl;
import com.psl.model.GitHubUser;

/**
 * @author praveen_kumatekar
 *
 */
public class GitHubAuthenticationService implements GitHubAuthenticationServiceImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.psl.service.GithubServiceImpl#save(com.psl.model.GitHubUser)
	 */

	public void save(GitHubUser gitHubUser) {
		// TODO Auto-generated method stub
		GitHubAuthenticationDAOImpl gitHubDAOImpl = new GitHubAuthenticationDAO();
		gitHubDAOImpl.save(gitHubUser);

	}

}
