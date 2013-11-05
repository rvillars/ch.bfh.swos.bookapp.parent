package ch.bfh.swos.bookapp.repository;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.bookapp.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class BookRepositoryIT {

	@Inject
	private BookRepository bookRepository;
	
	@Test
	public void test() {
		// Create
		Book newBook = new Book();
		newBook.setTitle("Test");
		bookRepository.save(newBook);

		// Read
		Book readBook = bookRepository.findOne(newBook.getId());
		org.junit.Assert.assertTrue(newBook.getTitle().equals(readBook.getTitle()));

		// Update
		readBook.setTitle("Test2");
		readBook = bookRepository.save(readBook);
		Book updatedBook = bookRepository.findOne(readBook.getId());
		org.junit.Assert.assertTrue(readBook.getTitle().equals(updatedBook.getTitle()));

		// Delete
		bookRepository.delete(updatedBook);
		Book deletedBook = bookRepository.findOne(readBook.getId());
		org.junit.Assert.assertNull(deletedBook);
	}

}
