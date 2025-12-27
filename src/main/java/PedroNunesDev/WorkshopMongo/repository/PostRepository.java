package PedroNunesDev.WorkshopMongo.repository;

import PedroNunesDev.WorkshopMongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
