package models;

import javax.persistence.Entity;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.Model;
import play.libs.Mail;

@Entity
public class Usuario extends Model {

	@Required
	public String login;
	@Required
	public String password;
	@Required
	public boolean activo = false;
	public String resetToken;
	@Email
	public String mail;
	
	public Usuario(String login, String password, String mail) throws EmailException {
		this.login = login;
		this.password = password;
		this.mail = mail; 
		this.resetUUID();
		SimpleEmail email = new SimpleEmail();
		email.setFrom("a@a.com");
		email.addTo(this.mail);
		email.setSubject("Confirma tu usuario");
		email.setMsg(this.resetToken);
		Mail.send(email);
	}
	
	public boolean activar(String token) {
		if (this.resetToken == token)
			this.activo = true;
		return activo;
	}
	
	public void remindPassword() throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setFrom("a@a.com");
		email.addTo(this.mail);
		email.setSubject("Contraseña de usuario");
		email.setMsg(this.password);
		Mail.send(email);
	}
	
	public void resetUUID(){
		this.resetToken = play.libs.Codec.UUID();
	}
	
}
