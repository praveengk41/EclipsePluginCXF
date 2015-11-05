package com.pl.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.psl.controller.UserController;
import com.psl.model.UserDetails;

public class UserValidationTest {
	
	@Test
	public void test() throws IOException {
		String userName = "vishalgupta12";
		String password = "testing123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn";
		UserController uc = new UserController();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(userName);
		userDetails.setPassword(password);
		userDetails.setUrl(url);
		uc.userValidation(userDetails);
		assertTrue(userDetails.isAuthorised());
	}

	@Test
	public void test2() throws IOException {
		String userName = "sriram";
		String password = "testing123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn";
		UserController uc = new UserController();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(userName);
		userDetails.setPassword(password);
		userDetails.setUrl(url);
		uc.userValidation(userDetails);
		assertTrue(userDetails.isAuthorised());
	}

	@Test
	public void sizeOftheFile() throws IOException {
		String userName = "vishalgupta12";
		String password = "testing123";
		String url = "https://github.com/nikhildongre/PSLEclipsePlugIn";
		UserController uc = new UserController();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(userName);
		userDetails.setPassword(password);
		userDetails.setUrl(url);
		UserDetails validateParam = uc.userValidation(userDetails);
		assertEquals(validateParam.getRepositoryFiles().size(),5);
	}


}
