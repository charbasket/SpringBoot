package com.in28minutes.rest.webservices.restfulwebservices.Controllers;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.Name;
import com.in28minutes.rest.webservices.restfulwebservices.Beans.PersonV1;
import com.in28minutes.rest.webservices.restfulwebservices.Beans.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonVersioningController {

    // URL versioning
    @GetMapping("/v1")
    public PersonV1 getPersonV1() {
        return new PersonV1("Carlos Fuentes");
    }

    @GetMapping("/v2")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Carlos", "Fuentes"));
    }

    // Parameter versioning
    @GetMapping(params = "version=1")
    public PersonV1 getPersonV1Parameter() {
        return new PersonV1("Carlos Fuentes");
    }

    @GetMapping(params = "version=2")
    public PersonV2 getPersonV2Parameter() {
        return new PersonV2(new Name("Carlos", "Fuentes"));
    }

    // Custom headers versioning
    @GetMapping(headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header() {
        return new PersonV1("Carlos Fuentes");
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Name("Carlos", "Fuentes"));
    }

    // Media type versioning
    @GetMapping(produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1Media() {
        return new PersonV1("Carlos Fuentes");
    }

    @GetMapping(produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2Media() {
        return new PersonV2(new Name("Carlos", "Fuentes"));
    }
}
