package de.neuefische.demoheroku;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/Servus")
public class Heroku {

    @GetMapping("/{name}")
    public String servus(@PathVariable String name){
        return "Grüss gott " + name;
    }

}
