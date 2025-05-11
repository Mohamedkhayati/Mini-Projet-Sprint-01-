package com.mohamed.supplements.service;

import com.mohamed.supplements.dto.SupplementDTO;
import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;

import java.util.List;

import org.springframework.data.domain.Page;

public interface SupplementService {
    // CRUD Operations
    SupplementDTO saveSupplement(SupplementDTO s);
    Supplement updateSupplement(SupplementDTO s);
    void deleteSupplement(Supplement s);
    void deleteSupplementById(Long id);
    SupplementDTO getSupplement(Long id);
    List<SupplementDTO> getAllSupplements();
    
    // Pagination
    Page<Supplement> getAllSupplementsParPage(int page, int size);
    
    // Search methods
    List<Supplement> findByNomSupplement(String nom);
    List<Supplement> findByNomSupplementContains(String nom);
    List<Supplement> findByNomPrix(String nom, Double prix);
    
    // Nutritional category methods
    List<Supplement> findByNutritional(Nutritional nutritional);
    List<Supplement> findByNutritionalIdNutri(Long id);
    List<Nutritional> getAllNutritionals();
    
    // Sorting methods
    List<Supplement> findByOrderByNomSupplementAsc();
    List<Supplement> trierSupplementsNomsPrix();
    
    // DTO Conversion
    SupplementDTO convertEntityToDto(Supplement supplement);
    Supplement convertDtoToEntity(SupplementDTO supplementDto);
}