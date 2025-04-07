package com.mohamed.supplements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.repos.SupplementRepository;

@SpringBootTest
class SupplementsApplicationTests {

    @Autowired
    private SupplementRepository supplementRepository;

    @Test
    public void testCreateSupplement() {
        Supplement supp = new Supplement("Whey Protein", "Protein", 29.99, "Optimum Nutrition", new Date());
        supplementRepository.save(supp);
    }

    @Test
    public void testFindSupplement() {
        Supplement s = supplementRepository.findById(1L).get();
        System.out.println(s);
    }

    @Test
    public void testUpdateSupplement() {
        Supplement s = supplementRepository.findById(1L).get();
        s.setPrixSupplement(25.99);
        supplementRepository.save(s);
    }

    @Test
    public void testDeleteSupplement() {
        supplementRepository.deleteById(1L);
    }

    @Test
    public void testListerTousSupplements() {
        List<Supplement> supps = supplementRepository.findAll();
        for (Supplement s : supps) {
            System.out.println(s);
        }
    }
    @Test
    public void testFindSupplementByNom() {
        List<Supplement> s = supplementRepository.findByNomSupplement("GSN");
        for(Supplement ss:s)
        System.out.println(ss);
    }
    @Test
    public void testFindByNomSupplement() {
        List<Supplement> supps = supplementRepository.findByNomSupplement("Whey Protein");
        for (Supplement s : supps) {
            System.out.println(s);
        }
    }
    @Test
    public void testfindByNomPrix() {
        List<Supplement> supps = supplementRepository.findByNomPrix("Whey Protein",29.99);
        for (Supplement s : supps) {
            System.out.println(s);
        }
    }


    @Test
    public void testFindByNutritionalIdNutri() {
        List<Supplement> supps = supplementRepository.findByNutritionalIdNutri(1L);
        for (Supplement s : supps) {
            System.out.println(s);
        }
    }

    @Test
    public void testTrierSupplementsNomsPrix() {
        List<Supplement> supps = supplementRepository.trierSupplementsNomsPrix();
        for (Supplement s : supps) {
            System.out.println(s);
        }
    }
    
    @Test
    public void testCreateSupplement1() {
        Nutritional nutr = new Nutritional();
        nutr.setIdNutri(1L);
        
        Supplement supp = new Supplement("Creatine", "5g", 25.99, "Optimum Nutrition", new Date());
        supp.setNutritional(nutr);
        supplementRepository.save(supp);
    }

}