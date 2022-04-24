package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
