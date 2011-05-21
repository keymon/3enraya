import models.Usuario;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import controllers.Security;

public class AuthenticationTest extends UnitTest {

	@Before
	public void loadData() {
		// Fixtures.loadModels("data.yml");

		Usuario prueba = new Usuario();
		prueba.login = "prueba";
		prueba.password = "password";

		prueba.save();
	}

	@Test
	public void unUsuarioConPasswordIncorrectoNoAutentica() {

		Usuario prueba = Usuario.find("login", "prueba").first();

		boolean resultado = Security.authenticate(prueba.login,
				"passwordIncorrecto");
		assertFalse(resultado);
	}

	@Test
	public void unUsuarioConPasswordCorrectoAutentica() {
		Usuario prueba = Usuario.find("login", "prueba").first();
		String password = prueba.password;

		boolean resultado = Security.authenticate(prueba.login, password);

		assertTrue(resultado);

	}

	@Test
	public void unUsuarioNoRegistradoNoAutentica() {

		boolean resultado = Security.authenticate("prueba2", "password");

		assertFalse(resultado);
	}

}
