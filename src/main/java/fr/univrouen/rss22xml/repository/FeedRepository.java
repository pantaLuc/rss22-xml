package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed,Long> {
}
