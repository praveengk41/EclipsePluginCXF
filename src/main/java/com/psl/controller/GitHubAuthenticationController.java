/**
 * Copy right by Persistent PVT LTD.
 */
package com.psl.controller;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;
import com.psl.model.GitHubUser;
import com.psl.service.GitHubAuthenticationService;
import com.psl.service.GitHubAuthenticationServiceImpl;

/**
 * @author praveen_kumatekar
 *
 */
public class GitHubAuthenticationController {

	final private String URL = "https://github.com/login/oauth/access_token";
	final private String clientId = "13a5bec734f0b4f91435";
	final private String clientSecret = "ff00139c8507f5a49180ffd9726258cff6589412";
	final private String redirectURL = "http://localhost:9090/EclipsePluginCXF/rest/Outh/authentication";

	@GET
	@Path("/Outh/authentication")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response getMsg(@QueryParam("code") String code) {
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(URL);
		postMethod.addParameter("client_id", clientId);
		postMethod.addParameter("client_secret", clientSecret);
		postMethod.addParameter("code", code);
		postMethod.addParameter("redirect_uri", redirectURL);
		Header mtHeader = new Header();
		mtHeader.setName("content-type");
		mtHeader.setValue("application/x-www-form-urlencoded");
		mtHeader.setName("accept");
		mtHeader.setValue("application/json");
		postMethod.addRequestHeader(mtHeader);
		String output = null;
		try {
			client.executeMethod(postMethod);
			output = postMethod.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (postMethod.getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ postMethod.getStatusCode());
		}
		JSONObject jsonObject = new JSONObject(output);
		return getGitHubAccountUserDetails((String) jsonObject
				.get("access_token"));
		// return Response.status(200).entity(output).build();
	}

	public Response getGitHubAccountUserDetails(String accessToken) {
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(
				"https://api.github.com/user?access_token=" + accessToken);
		String output = null;
		try {
			client.executeMethod(getMethod);
			output = getMethod.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		GitHubUser gitHubUser = new GitHubUser();
		JSONObject jsonObject = new JSONObject(output);

		gitHubUser.setUserName(jsonObject.get("login").toString());
		gitHubUser.setGithubId(jsonObject.get("id").toString());
		gitHubUser.setGithubURL(jsonObject.get("url").toString());
		gitHubUser.setAccessToken(accessToken);
		if (jsonObject.get("email") != null) {
			gitHubUser.setEmail(jsonObject.get("email").toString());
		}

		if (jsonObject.get("name") != null) {
			gitHubUser.setGithubName(jsonObject.get("name").toString());
		}

		if (jsonObject.get("location") != null) {
			gitHubUser.setLocation(jsonObject.get("location").toString());
		}

		GitHubAuthenticationServiceImpl githubServiceImpl = new GitHubAuthenticationService();
		githubServiceImpl.save(gitHubUser);
		return Response.status(200).entity(output).build();
	}
}
