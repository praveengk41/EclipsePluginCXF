package com.psl.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.psl.model.UserDetails;
import com.psl.service.TreeStructure;
import com.psl.service.UserValidation;


public class UserController {

	@POST
	@Path("/validate")
	@Consumes("application/json")
	@Produces("application/json")
	public UserDetails ValidateParam(UserDetails userdetail)
			throws IOException {
		UserValidation userVal = new UserValidation();
		try {
			if (userVal.authenticate(userdetail.getUserName(), userdetail.getPassword())) {
				userdetail.setAuthorised(true);
				TreeStructure tr = new TreeStructure();
				return tr.getTreeStructure(userdetail);
			}
		} catch (IOException e) {
			userdetail.setAuthorised(false);
		}
		return userdetail;

	}

}

