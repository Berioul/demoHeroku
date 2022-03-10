package de.neuefische.demoheroku.Joke;

import de.neuefische.demoheroku.Jokes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepository extends MongoRepository<Jokes,String> {
    List<Jokes> findByRating (String rating);

}


