package com.psl.service;

import java.io.IOException;

import org.kohsuke.github.GitHub;

public class UserValidation {
	
	
	public boolean authenticate(String userName, String password)
			throws IOException {
		if(userName!=null&&password!=null){
		GitHub gitHub = GitHub.connectUsingPassword(userName, password);
		return gitHub.isCredentialValid();
		}
		return false;
	}

}
