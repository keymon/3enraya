package controllers;

import play.*;
import play.data.validation.Required;
import play.data.validation.Email;
import play.data.validation.Equals;
import play.mvc.*;

import java.util.*;

import models.Usuario;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void registrarUsuario(@Required String login,
			@Required String password, @Required @Equals("password") String passwordRepetido,
			@Email @Required String correoElectronico) {
	    if (!validation.hasErrors()) {
	    	new Usuario(login, password, correoElectronico); 
	        render("Application/envioCorreoConfirmacion.html");
	    }

		render();
	}

}