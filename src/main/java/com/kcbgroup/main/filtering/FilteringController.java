package com.kcbgroup.main.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public List<SomeBean> retrieveSomeBean(){
        return Arrays.asList(new SomeBean("Value 1", "Value 2", "Value 3"),
                new SomeBean("Value 11", "Value 21", "Value 31"));
    }
}
