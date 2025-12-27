package PedroNunesDev.WorkshopMongo.controller;

import PedroNunesDev.WorkshopMongo.model.Post;
import PedroNunesDev.WorkshopMongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post post = postService.findById(id);

        return ResponseEntity.ok(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){

        List<Post> posts = postService.findByTitle(title);

        return ResponseEntity.ok(posts);
    }
}
