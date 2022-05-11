package com.springboot.blog.payload;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PostDto {

	private long id;

	// Title shouldn't be null nor empty
	// Title should have atleast 2 characters
	@NotEmpty
	@Size(min = 2, message = "Title of the Post should have atleast 2 characters")
	private String title;

	// Title shouldn't be null nor empty
	// Title should have atleast 10 characters
	@NotEmpty
	@Size(min = 10, message = "Description of a Post should have atleast 10 characters")
	private String body;

	// Title shouldn't be null nor empty

	//@Size(value=1, message= "whatever")
	private long user_id;


	private Set<CommentDto> comments;

}
