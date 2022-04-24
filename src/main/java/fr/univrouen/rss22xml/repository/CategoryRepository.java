package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
