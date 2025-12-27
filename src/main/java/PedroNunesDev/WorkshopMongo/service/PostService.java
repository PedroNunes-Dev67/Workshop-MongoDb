package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.exception.ObjectNotFoundException;
import PedroNunesDev.WorkshopMongo.model.Post;
import PedroNunesDev.WorkshopMongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){

        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }
}
