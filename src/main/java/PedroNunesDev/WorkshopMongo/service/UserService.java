package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.dto.UserDto;
import PedroNunesDev.WorkshopMongo.dto.UserDtoRequest;
import PedroNunesDev.WorkshopMongo.exception.ObjectNotFoundException;
import PedroNunesDev.WorkshopMongo.exception.UserConflictException;
import PedroNunesDev.WorkshopMongo.model.Post;
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

    public UserDto findById(String id){

        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));

        return new UserDto(user.getId(),user.getName(),user.getEmail());
    }

    public UserDto createUser(UserDtoRequest userDtoRequest){

        User user = userRepository.findByEmail(userDtoRequest.getEmail()).orElse(null);

        if (user != null) throw new UserConflictException("Usuário já cadastrado.");

        user = new User(null, userDtoRequest.getName(), userDtoRequest.getEmail());

        userRepository.save(user);

        return new UserDto(user.getId(),user.getName(),user.getEmail());
    }

    public void deleteUser(String id){

        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("usuário não encontrado."));

        userRepository.delete(user);
    }

    public UserDto updateUser(String id, UserDtoRequest userDtoRequest){

        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));

        updateData(user, userDtoRequest);

        userRepository.save(user);

        return new UserDto(user.getId(),user.getName(),user.getEmail());
    }

    private void updateData(User user, UserDtoRequest userDtoRequest){

        user.setName(userDtoRequest.getName());
        user.setEmail(userDtoRequest.getEmail());
    }

    public List<Post> findAllPosts(String id){

        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Uusuário não encontrado."));

        return user.getPosts();
    }
}
