// SupplementService.java
package com.mohamed.supplements.service;

import com.mohamed.supplements.dto.SupplementDTO;
import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;

import java.util.List;

import org.springframework.data.domain.Page;

public interface SupplementService {
    // Existing methods
    SupplementDTO saveSupplement(SupplementDTO  s);
    Supplement updateSupplement(SupplementDTO  s);
    void deleteSupplement(Supplement s);
    void deleteSupplementById(Long id);
    SupplementDTO getSupplement(Long id);
    List<SupplementDTO> getAllSupplements();
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
    SupplementDTO convertEntityToDto(Supplement supplement);
    Supplement convertDtoToEntity(SupplementDTO supplementDto);
    
    
}