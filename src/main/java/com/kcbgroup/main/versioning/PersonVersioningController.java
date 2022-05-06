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

    @GetMapping(value = "/v1/param/header", headers = "API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Nephat Mutugi");
    }

    @GetMapping(value = "/v1/param/header", headers = "API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Nephat" , "Mutugi", "Muchiri"));
    }

    @GetMapping(value = "/v1/param/produces",
            produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Nephat Mutugi");
    }

    @GetMapping(value = "/v1/param/produces",
            produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Nephat" , "Mutugi", "Muchiri"));
    }
}
