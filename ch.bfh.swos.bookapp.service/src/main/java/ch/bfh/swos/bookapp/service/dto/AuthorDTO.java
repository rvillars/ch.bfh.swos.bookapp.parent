package ch.bfh.swos.bookapp.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Author
 *
 */
public class AuthorDTO implements Serializable {

	   
	private Long id;
	private String firstname;
	private String lastname;
	private static final long serialVersionUID = 1L;
	
	
	private List<BookDTO> books;

	public AuthorDTO() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
   
}
