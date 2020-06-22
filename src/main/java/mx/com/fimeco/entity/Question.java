package mx.com.fimeco.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
    private Integer id;
	
	/**
	 * The text question. is what you need to ask.
	 */
	@Size(min = 3, max = 200, 
			message = "Question must have between 2 and 200 characters long.")
	@Pattern(regexp = "[A-Za-z0-9 .,;:]+",
			message = "Only letters, numbers and characters ,.;: are accepted in Question.")
	@Column(nullable = false, length = 200)
	private String text;
	
	/**
	 * The value of the question in points
	 */
	private int points;
	
	/**
	 * Flag to enable o disable the question. Logic Deletion
	 */
	private boolean active;
	
	/**
	 * Given answer by the user
	 */
	@Size(min = 2, max = 200, message = "Your response must have between 2 and 200 characters long.")
	@Pattern(regexp = "[A-Za-z0-9 .,]+",
	message = "Only letters, numbers and characters ., are accepted in Response.")
	@Transient
	private String userResponse;
}
