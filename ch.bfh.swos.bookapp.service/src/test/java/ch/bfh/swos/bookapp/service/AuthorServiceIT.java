package ch.bfh.swos.bookapp.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.bookapp.service.dto.AuthorDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class AuthorServiceIT {

	@Inject
	private AuthorService authorService;

	@Test
	public void test() {

		// Create
		AuthorDTO newAuthor = new AuthorDTO();
		newAuthor.setLastname("Test");
		newAuthor = authorService.create(newAuthor);

		// Read
		AuthorDTO readAuthor = authorService.read(newAuthor.getId());
		Assert.assertTrue(newAuthor.getLastname().equals(readAuthor.getLastname()));

		// Update
		readAuthor.setLastname("Test2");
		readAuthor = authorService.update(readAuthor);
		AuthorDTO updatedAuthor = authorService.read(readAuthor.getId());
		Assert.assertTrue(readAuthor.getLastname().equals(updatedAuthor.getLastname()));

		// Delete
		authorService.delete(updatedAuthor);
		AuthorDTO deletedAuthor = authorService.read(readAuthor.getId());
		Assert.assertNull(deletedAuthor);
	}

}
