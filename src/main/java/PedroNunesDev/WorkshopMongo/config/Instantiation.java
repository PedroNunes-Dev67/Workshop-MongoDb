package PedroNunesDev.WorkshopMongo.config;

import PedroNunesDev.WorkshopMongo.dto.AuthorDto;
import PedroNunesDev.WorkshopMongo.dto.CommentDto;
import PedroNunesDev.WorkshopMongo.model.Post;
import PedroNunesDev.WorkshopMongo.model.User;
import PedroNunesDev.WorkshopMongo.repository.PostRepository;
import PedroNunesDev.WorkshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null,"Maria Brown","maria@gmail.com");
        User alex = new User(null,"Alex Green","alex@gmail.com");
        User bob = new User(null, "Bob Grey","bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,LocalDate.parse("21/03/2018", fmt) ,"Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        CommentDto comment1 = new CommentDto("Boa viagem mano!", LocalDate.parse("21/03/2018",fmt), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto("Aproveite!", LocalDate.parse("21/03/2018",fmt), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", LocalDate.parse("23/03/2018",fmt), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);
    }
}
