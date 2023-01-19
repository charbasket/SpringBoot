package com.in28minutes.rest.webservices.restfulwebservices.Controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.restfulwebservices.Beans.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        // We create a filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("v1", "v3");

        // We add our filter to the filter list
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        // Adding dynamic filtering
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"));

        // We create the filters and a list of filters using our own method
        FilterProvider filters = this.createFilters("SomeBeanFilter", "v1", "v3");

        // Adding dynamic filtering
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    // Filters out all the fields excepts the ones that are passed as parameters.
    private FilterProvider createFilters(String filterName, String... fieldsToShow) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToShow);
        return new SimpleFilterProvider().addFilter(filterName, filter);
    }
}
