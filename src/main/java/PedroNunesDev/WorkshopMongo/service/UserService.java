package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.dto.UserDto;
import PedroNunesDev.WorkshopMongo.model.User;
import PedroNunesDev.WorkshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll(){

        List<User> list = userRepository.findAll();

        return list.stream().map(user -> new UserDto(user.getId(), user.getName(), user.getEmail())).toList();
    }
}
