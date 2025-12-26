package PedroNunesDev.WorkshopMongo.controller;

import PedroNunesDev.WorkshopMongo.dto.UserDto;
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
}
