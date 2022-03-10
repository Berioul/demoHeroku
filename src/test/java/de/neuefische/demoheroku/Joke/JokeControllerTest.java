package de.neuefische.demoheroku.Joke;

import de.neuefische.demoheroku.Jokes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class JokeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoad() {

        Jokes joke = new Jokes();
        joke.setJokes("blablablalb");
        joke.setRating("bouuuuu");

        ResponseEntity<Jokes> postReponse = restTemplate.postForEntity("/api/Jokes", joke, Jokes.class);
        assertThat(postReponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postReponse.getBody().getId()).isNotNull();

        ResponseEntity<Jokes>postResponse = restTemplate.postForEntity("/api/Jokes",joke,Jokes.class);
        assertThat(postResponse.getBody().getId()).isNotNull();


        String id = postReponse.getBody().getId();
        ResponseEntity<Jokes> getRepesponse = restTemplate.getForEntity("/api/Jokes/"+ id,Jokes.class);
        assertThat(getRepesponse.getBody().getId()).isEqualTo(id);

        ResponseEntity<Jokes[]>getResponseAll = restTemplate.getForEntity("/api/Jokes",Jokes[].class);
        assertThat(getResponseAll.getBody().length).isEqualTo(2);
    }


}