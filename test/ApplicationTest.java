import models.Usuario;

import org.apache.commons.mail.EmailException;
import org.junit.*;
import org.junit.Before;

import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;

public class ApplicationTest extends FunctionalTest {

	Usuario usuario;
	
	@Before
	public void setUp() throws EmailException{
		usuario = new Usuario("pepe", "pepa", "a@a.com");
	}
	
    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset("utf-8", response);
    }
    
    @Test
    public void userHaveLogin(){
    	usuario.login = "test";
    	assertEquals("test", usuario.login);
    }
    
    @Test
    public void canObtainUUID(){
    	usuario.resetUUID();
    	assertNotNull(usuario.resetToken);
    	assertEquals(String.class, usuario.resetToken);
    }
    
    
}