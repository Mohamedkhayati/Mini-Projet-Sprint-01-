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
    
	@RequestMapping(path="all", method=RequestMethod.GET)
    public List<SupplementDTO> getAllSupplements() {
        return supplementService.getAllSupplements();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public SupplementDTO getSupplementById(@PathVariable("id") Long id) {
        return supplementService.getSupplement(id);
    }

    @RequestMapping(path = "/addsupp", method = RequestMethod.POST)
    public SupplementDTO createSupplement(@RequestBody SupplementDTO supplement) {
        return supplementService.saveSupplement(supplement);
    }

    @RequestMapping(path = "/updatesupp", method = RequestMethod.PUT)
    public Supplement updateSupplement(@RequestBody SupplementDTO supplement) {
        return supplementService.updateSupplement(supplement);
    }

    @RequestMapping(value = "/delsupp/{id}", method = RequestMethod.DELETE)
    public void deleteSupplement(@PathVariable("id") Long id) {
        supplementService.deleteSupplementById(id);
    }

    @RequestMapping(value = "/suppsnutri/{idNutri}", method = RequestMethod.GET)
    public List<Supplement> getSupplementsByNutriId(@PathVariable("idNutri") Long idNutri) {
        return supplementService.findByNutritionalIdNutri(idNutri);
    }

    @GetMapping("/supplementsByName/{nom}")
    public List<Supplement> findByNomSupplementContains(@PathVariable("nom") String nom) {
        return supplementService.findByNomSupplementContains(nom);
    }
}