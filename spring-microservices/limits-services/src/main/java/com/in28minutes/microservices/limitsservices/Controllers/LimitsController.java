package com.in28minutes.microservices.limitsservices.Controllers;

import com.in28minutes.microservices.limitsservices.Beans.Limits;
import com.in28minutes.microservices.limitsservices.Configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitsController {
    @Autowired
    private Configuration configuration;
    @GetMapping
    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
//        return new Limits(1,1000);
    }
}
