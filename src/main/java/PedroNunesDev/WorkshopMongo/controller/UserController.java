package PedroNunesDev.WorkshopMongo.controller;

import PedroNunesDev.WorkshopMongo.dto.UserDto;
import PedroNunesDev.WorkshopMongo.dto.UserDtoRequest;
import PedroNunesDev.WorkshopMongo.model.User;
import PedroNunesDev.WorkshopMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){

        List<UserDto> list = userService.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){

        UserDto user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDtoRequest userDtoRequest){

        UserDto user = userService.createUser(userDtoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDtoRequest userDtoRequest){

        UserDto user = userService.updateUser(id,userDtoRequest);

        return ResponseEntity.ok(user);
    }
}
