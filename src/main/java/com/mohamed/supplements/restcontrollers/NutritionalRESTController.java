package com.mohamed.supplements.restcontrollers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.repos.NutritionalRepository;

@RestController
@RequestMapping("/api/nut")
@CrossOrigin("http://localhost:4200")
public class NutritionalRESTController {

    @Autowired
    NutritionalRepository nutritionalRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllNutritionals() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> embedded = new HashMap<>();
        embedded.put("nutritionals", nutritionalRepository.findAll());
        response.put("_embedded", embedded);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Nutritional getNutritionalById(@PathVariable("id") Long id) {
        return nutritionalRepository.findById(id).orElse(null);
    }
}
