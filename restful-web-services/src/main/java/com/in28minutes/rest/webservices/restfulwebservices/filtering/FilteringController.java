package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	// Static filtering
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1", "value2", "value3", "value4");
	}

	// Static filtering
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"),
				new SomeBean("value5", "value6", "value7", "value8"));
	}

	// Dynamic filtering
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue filteringDynamic() {
		SomeBean2 someBean2 = new SomeBean2("value1", "value2", "value3", "value4");

		// Ahora podemos añadir filtros a nuesta respueta
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean2);

		// Filtramos todos los campos menos field1 y field2
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean2Filter", filter);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	// Dynamic filtering
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue filteringListDynamic() {
		List<SomeBean2> someBean2List = Arrays.asList(new SomeBean2("value1", "value2", "value3", "value4"),
				new SomeBean2("value5", "value6", "value7", "value8"));
		// Ahora podemos añadir filtros a nuesta respueta
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean2List);

		// Filtramos todos los campos menos field1 y field2
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean2Filter", filter);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;

	}

}
