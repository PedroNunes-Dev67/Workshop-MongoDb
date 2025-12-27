package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.exception.ObjectNotFoundException;
import PedroNunesDev.WorkshopMongo.model.Post;
import PedroNunesDev.WorkshopMongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){

        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }

    public List<Post> findByTitle(String title){

        String titleDecode = titleDecoder(title);

        return postRepository.findByTitle(titleDecode);
    }

    private String titleDecoder(String title){

        try{

            return URLDecoder.decode(title, "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
