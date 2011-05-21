package controllers;

import models.Usuario;

public class Security extends Secure.Security {

	public static boolean authenticate(String username, String password) {

		Usuario user = Usuario.find("login", username).first();
		if (user == null) {
			return false;
		}
		return password.equals(user.password);
	}

}
