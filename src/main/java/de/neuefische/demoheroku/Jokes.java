package de.neuefische.demoheroku;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Jokes {


    private String id;
    private String jokes;
    private String rating;

}
