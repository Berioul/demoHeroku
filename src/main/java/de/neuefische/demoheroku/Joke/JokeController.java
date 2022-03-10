package de.neuefische.demoheroku.Joke;


import de.neuefische.demoheroku.Jokes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Jokes")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @PostMapping
    public Jokes creatNewJoke(@RequestBody Jokes jokes) {
        return jokeService.creatNewJoke(jokes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jokes> getJoke(@PathVariable String id) {
        return ResponseEntity.of(jokeService.getJoke(id));

    }

    @DeleteMapping("/{id}")
    public void deleteJoke(@PathVariable String id) {
        jokeService.deleteJoke(id);
    }

    @GetMapping
    public List<Jokes> findAllJokes() {
      return jokeService.findAllJoke();
    }
}
