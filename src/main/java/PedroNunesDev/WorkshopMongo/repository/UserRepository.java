package PedroNunesDev.WorkshopMongo.repository;

import PedroNunesDev.WorkshopMongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
