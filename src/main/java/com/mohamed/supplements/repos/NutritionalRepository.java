package com.mohamed.supplements.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mohamed.supplements.entities.Nutritional;
@RepositoryRestResource(path = "cat")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 

public interface NutritionalRepository extends JpaRepository<Nutritional, Long> {
}