/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Praveen GK
 *
 */
@XmlRootElement(name = "GitHubUser")
@Entity
@Table(name = "GITHUB_USER")
public class GitHubUser {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userID;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "GITHUB_ID")
	private String githubId;

	@Column(name = "GITHUB_URL")
	private String githubURL;

	@Column(name = "GITHUB_NAME")
	private String githubName;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "ACCESS_TOKEN")
	private String accessToken;

	@Column(name = "EMAIL")
	private String email;

	public GitHubUser() {
		super();
	}

	public GitHubUser(String userName, String githubId, String githubURL,
			String githubName, String location, String accessToken, String email) {
		super();
		this.userName = userName;
		this.githubId = githubId;
		this.githubURL = githubURL;
		this.githubName = githubName;
		this.location = location;
		this.accessToken = accessToken;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGithubId() {
		return githubId;
	}

	public void setGithubId(String githubId) {
		this.githubId = githubId;
	}

	public String getGithubURL() {
		return githubURL;
	}

	public void setGithubURL(String githubURL) {
		this.githubURL = githubURL;
	}

	public String getGithubName() {
		return githubName;
	}

	public void setGithubName(String githubName) {
		this.githubName = githubName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
