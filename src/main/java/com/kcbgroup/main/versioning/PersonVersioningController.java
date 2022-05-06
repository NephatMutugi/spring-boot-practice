package com.kcbgroup.main.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/")
public class PersonVersioningController {

    @GetMapping("/v1")
    public PersonV1 personV1(){
        return new PersonV1("Nephat Mutugi");
    }

    @GetMapping("/v2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Nephat" , "Mutugi", "Muchiri"));
    }

}
