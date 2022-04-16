package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link ,Long> {

}
