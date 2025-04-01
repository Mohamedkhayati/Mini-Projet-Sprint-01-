package com.mohamed.supplements;

import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SupplementsApplication implements CommandLineRunner {

    @Autowired
    private SupplementService supplementService;

    public static void main(String[] args) {
        SpringApplication.run(SupplementsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        supplementService.saveSupplement(new Supplement("Whey Protein", "30g", 29.99, "Optimum Nutrition", new Date()));
        supplementService.saveSupplement(new Supplement("Creatine", "5g", 19.99, "MuscleTech", new Date()));
        supplementService.saveSupplement(new Supplement("BCAA", "10g", 24.99, "Scivation", new Date()));
    }
}