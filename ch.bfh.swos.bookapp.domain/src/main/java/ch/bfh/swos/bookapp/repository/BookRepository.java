package ch.bfh.swos.bookapp.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.bookapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
