package ch.bfh.swos.bookapp.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.swos.bookapp.service.BookService;
import ch.bfh.swos.bookapp.service.dto.BookDTO;

@Controller
@RequestMapping("/books")
public class BookController {

	@Inject
	private BookService bookService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public BookDTO createBook(@RequestBody BookDTO book) {
		BookDTO createdBook = bookService.create(book);
		System.out.println("Book created with id = " + createdBook.getId());
		return createdBook;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<BookDTO> getBooks() {
		System.out.println("Collection of Book requested");
		return bookService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public BookDTO getBook(@PathVariable long id) {
		System.out.println("Book requested with id = " + id);
		return bookService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public BookDTO updateBook(@RequestBody BookDTO book) {
		BookDTO updatedBook = bookService.update(book);
		System.out.println("Book updated with id = " + updatedBook.getId());
		return updatedBook;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteBook(@PathVariable long id) {
		BookDTO book = bookService.read(id);
		bookService.delete(book);
		System.out.println("Delete Book with id = " + id);
	}
}
