package ch.bfh.swos.bookapp.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Author
 *
 */
@Entity

public class Author implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = ALL, mappedBy = "author")
	private List<Book> books;

	public Author() {
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
   
}
