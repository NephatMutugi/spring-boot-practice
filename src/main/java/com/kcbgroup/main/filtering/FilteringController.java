package com.kcbgroup.main.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("Value 1", "Value 2", "Value 3", " Value 4", "Value 5");

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filterValues("field1", "field2"));
        return mapping;
    }

    @GetMapping("filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){
        List<SomeBean> someBeanList =  Arrays.asList(new SomeBean("Value 1", "Value 2", "Value 3", " Value 4", "Value 5"),
                new SomeBean("Value 11", "Value 21", "Value 31", "Value 41", "value 51"));

        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filterValues("field1", "field2"));

        return mapping;
    }

    public FilterProvider filterValues(String field1, String field2){
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(field1, field2);
        return new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);
    }
}
