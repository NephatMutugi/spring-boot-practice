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


    @GetMapping(value = "/v1/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Nephat Mutugi");
    }

    @GetMapping(value = "/v1/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Nephat" , "Mutugi", "Muchiri"));
    }
}
