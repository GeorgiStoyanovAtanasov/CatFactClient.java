package com.example.consuming_rest_apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CatFactController {
    private CatFactRepository catFactRepository;

    private final CatFactService catFactService;

    @Autowired
    public CatFactController(CatFactRepository catFactRepository,CatFactService catFactService) {
        this.catFactRepository = catFactRepository;
        this.catFactService = catFactService;
    }


    @GetMapping("/catfact")
    public String getCatFact() throws IOException {
        return catFactService.getCatFact();
    }

    @PostMapping("/post")
    public String postCatFact(@RequestBody CatFact catFact) throws IOException {
        return catFactService.postCatFact(catFact);
    }
    @PostMapping("/post-to-database")
    public String postCatFactToDatabase(@RequestBody CatFact catFact){
        catFactRepository.save(catFact);
        return "Successfully posted to the database!";
    }
    @GetMapping("catfact-2")
    public ResponseEntity<CatFact> getCatFact2(){
        return catFactService.getCatFactSecondMethod();
    }
}
