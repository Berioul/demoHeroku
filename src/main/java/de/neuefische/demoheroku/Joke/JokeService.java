package de.neuefische.demoheroku.Joke;

import de.neuefische.demoheroku.Jokes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JokeService {
    private final JokeRepository jokeRepository;

    public Jokes creatNewJoke(Jokes jokes){

        return jokeRepository.save(jokes);
    }

    public Optional<Jokes> getJoke(String id) {
        return jokeRepository.findById(id);
    }

    public void deleteJoke(String id) {
        jokeRepository.deleteById(id);
    }
    public List<Jokes> findAllJoke(){
        return jokeRepository.findAll();
    }
}
