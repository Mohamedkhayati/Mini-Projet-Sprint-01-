package com.mohamed.supplements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}