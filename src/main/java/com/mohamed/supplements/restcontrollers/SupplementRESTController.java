package com.mohamed.supplements.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.supplements.dto.SupplementDTO;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.service.SupplementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SupplementRESTController {

    @Autowired
    SupplementService supplementService;

    // 1. Get all supplements
    @GetMapping
    public List<SupplementDTO> getAllSupplements() {
        return supplementService.getAllSupplements();
    }

    // 2. Get a supplement by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SupplementDTO getSupplementById(@PathVariable("id") Long id) {
        return supplementService.getSupplement(id);
    }

    // 3. Create a supplement
    @RequestMapping(method = RequestMethod.POST)
    public SupplementDTO createSupplement(@RequestBody SupplementDTO supplement) {
        return supplementService.saveSupplement(supplement);
    }

    // 4. Update a supplement
    @RequestMapping(method = RequestMethod.PUT)
    public Supplement updateSupplement(@RequestBody SupplementDTO supplement) {
        return supplementService.updateSupplement(supplement);
    }

    // 5. Delete a supplement
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSupplement(@PathVariable("id") Long id) {
        supplementService.deleteSupplementById(id);
    }

    // 6. Get supplements by nutritional category ID
    @RequestMapping(value = "/suppsnutri/{idNutri}", method = RequestMethod.GET)
    public List<Supplement> getSupplementsByNutriId(@PathVariable("idNutri") Long idNutri) {
        return supplementService.findByNutritionalIdNutri(idNutri);
    }
}