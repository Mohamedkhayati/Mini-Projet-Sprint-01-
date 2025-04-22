// SupplementService.java
package com.mohamed.supplements.service;

import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;

import java.util.List;

import org.springframework.data.domain.Page;

public interface SupplementService {
    // Existing methods
    Supplement saveSupplement(Supplement s);
    Supplement updateSupplement(Supplement s);
    void deleteSupplement(Supplement s);
    void deleteSupplementById(Long id);
    Supplement getSupplement(Long id);
    List<Supplement> getAllSupplements();
    // New method for pagination
    Page<Supplement> getAllSupplementsParPage(int page, int size);
    List<Supplement> findByNomSupplement(String nom);
    List<Supplement> findByNomSupplementContains(String nom);
    List<Supplement> findByNomPrix(String nom, Double prix);
    List<Supplement> findByNutritional(Nutritional nutritional);
    List<Supplement> findByNutritionalIdNutri(long id);
    List<Supplement> findByOrderByNomSupplementAsc();
    List<Supplement> trierSupplementsNomsPrix();
    List<Nutritional> getAllNutritionals();

    
    
}