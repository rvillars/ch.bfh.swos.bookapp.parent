package ch.bfh.swos.bookapp.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.bookapp.service.dto.BookDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class BookServiceIT {

	@Inject
	private BookService bookService;

	@Test
	public void test() {

		// Create
		BookDTO newBook = new BookDTO();
		newBook.setTitle("Test");
		newBook = bookService.create(newBook);

		// Read
		BookDTO readBook = bookService.read(newBook.getId());
		Assert.assertTrue(newBook.getTitle().equals(readBook.getTitle()));

		// Update
		readBook.setTitle("Test2");
		readBook = bookService.update(readBook);
		BookDTO updatedBook = bookService.read(readBook.getId());
		Assert.assertTrue(readBook.getTitle().equals(updatedBook.getTitle()));

		// Delete
		bookService.delete(updatedBook);
		BookDTO deletedBook = bookService.read(readBook.getId());
		Assert.assertNull(deletedBook);
	}

}
