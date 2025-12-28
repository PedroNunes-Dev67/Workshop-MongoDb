package PedroNunesDev.WorkshopMongo.service;

import PedroNunesDev.WorkshopMongo.exception.ObjectNotFoundException;
import PedroNunesDev.WorkshopMongo.model.Post;
import PedroNunesDev.WorkshopMongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public List<Post> fullSerache(String text, String minDate, String maxDate){

        String textDecode = titleDecoder(text);

        LocalDate minDateDecode = convertDate(minDate, LocalDate.now().plusDays(1));
        LocalDate maxDateDecode = convertDate(maxDate, LocalDate.now().plusDays(1));

        maxDateDecode.plusDays(1);

        return postRepository.fullSearch(textDecode, minDateDecode, maxDateDecode);
    }

    private LocalDate convertDate(String textDate, LocalDate defaultDate){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(textDate);
        }
        catch (DateTimeException e){
            return defaultDate;
        }
    }
}
