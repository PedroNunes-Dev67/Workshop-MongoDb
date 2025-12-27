package PedroNunesDev.WorkshopMongo.repository;

import PedroNunesDev.WorkshopMongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase(String title);
}
