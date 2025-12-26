package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.model.User;
import PedroNunesDev.WorkshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }
}
