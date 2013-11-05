package ch.bfh.swos.bookapp.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.bookapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
