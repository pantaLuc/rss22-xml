package fr.univrouen.rss22xml.repository;

import fr.univrouen.rss22xml.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
