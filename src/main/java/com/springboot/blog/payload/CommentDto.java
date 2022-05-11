package com.springboot.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	private long id;

	// Name shouldn't be null nor empty
	@NotEmpty(message = "Name shouldn't be null nor empty")
	private String name;

	// Comment body should not be null nor empty
	// Comment body must be minimum 10 characters
	@NotEmpty(message = "Comment Body Shouldn't be null nor empty")
	@Size(min = 10, message = "Comment body must be minimum 10 characters")
	private String body;

	// email should not be null nor empty
	// Email Field validation
	@NotEmpty(message = "Email Shouldn't be null nor empty")
	@Email(message = "Enter valid Email ID")
	private String email;

}
