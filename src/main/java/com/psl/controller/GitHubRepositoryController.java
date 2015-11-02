/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.psl.model.UserDetails;
import com.psl.service.GitHubRepositoryService;
import com.psl.service.GitHubRepositoryServiceImpl;

/**
 * @author Praveen GK
 *
 */
public class GitHubRepositoryController {

	/**
	 * This method use to get structure of GitHub repository.
	 * @param userName GitHub user name
	 * @param password GitHub login password
	 * @param url Repository Url
	 * @return It will return object of UserDetails
	 */
	@POST
	@Path("/repositoryStructure")
	@Produces("application/json")
	public UserDetails gitHubRepositoryStructure(
			@FormParam("username") String userName,
			@FormParam("password") String password, @FormParam("url") String url) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(userName);
		userDetails.setPassword(password);
		userDetails.setUrl(url);
		GitHubRepositoryServiceImpl gitHubRepositoryService = new GitHubRepositoryService();
		gitHubRepositoryService.gitHubRepositoryStructure(userDetails);
		return userDetails;
	}

}
