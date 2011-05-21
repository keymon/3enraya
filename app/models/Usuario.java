package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Usuario extends Model {
	
	@Required
	public String login;
	
	@Required
	public String password;
    
}
