package mx.com.fimeco.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

	@Size(min = 3, max = 10, message = "Username must have between 3 and 10 characters long.")
	@Pattern(regexp = "[A-Za-z]+", message = "Only letters are accepted.")	
	String name;
	
	@Email(message = "Enter a valid email address.")
	String email;
}
