package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Long> {
}
