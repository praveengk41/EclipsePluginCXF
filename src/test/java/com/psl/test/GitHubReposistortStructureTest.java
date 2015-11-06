/**
 * 
 */
package com.psl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.psl.controller.GitHubRepositoryController;

/**
 * @author Praveen G K
 *
 */
public class GitHubReposistortStructureTest {

	GitHubRepositoryController gitHubRepositoryController;

	/**
	 * Test case for correct Credentials
	 */
	@Test
	public void testRepoCorrectCredentials() {
		String userName = "vishalgupta12";
		String password = "testing123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn";
		gitHubRepositoryController = new GitHubRepositoryController();
        assertEquals(gitHubRepositoryController.gitHubRepositoryStructure(userName, password, url).isUrlAccessible(), true);
	}
	

	/**
	 * Test case for incorrect password
	 */
	@Test
	public void testRepoInCorrectCredentials() {
		String userName = "vishalg2pta12";
		String password = "testing@123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn";
		gitHubRepositoryController = new GitHubRepositoryController();
        assertEquals(gitHubRepositoryController.gitHubRepositoryStructure(userName, password, url).isUrlAccessible(), false);
	}
	
	/**
	 * Test case for incorrect URL
	 */
	@Test
	public void testRepoInCorrectUrl() {
		String userName = "vishalg2pta12";
		String password = "testing123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn123";
		gitHubRepositoryController = new GitHubRepositoryController();
        assertEquals(gitHubRepositoryController.gitHubRepositoryStructure(userName, password, url).isUrlAccessible(), false);
	}
}
