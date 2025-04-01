// SupplementServiceImpl.java
package com.mohamed.supplements.service;

import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.repos.SupplementRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SupplementServiceImpl implements SupplementService {

    @Autowired
    private SupplementRepository supplementRepository;

    // Existing methods
    @Override
    public Supplement saveSupplement(Supplement s) {
        return supplementRepository.save(s);
    }

    @Override
    public Supplement updateSupplement(Supplement s) {
        return supplementRepository.save(s);
    }

    @Override
    public void deleteSupplement(Supplement s) {
        supplementRepository.delete(s);
    }

    @Override
    public void deleteSupplementById(Long id) {
        supplementRepository.deleteById(id);
    }

    @Override
    public Supplement getSupplement(Long id) {
        return supplementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Supplement> getAllSupplements() {
        return supplementRepository.findAll();
    }

    // New method for pagination
    @Override
    public Page<Supplement> getAllSupplementsParPage(int page, int size) {
        return supplementRepository.findAll(PageRequest.of(page, size));
    }
}