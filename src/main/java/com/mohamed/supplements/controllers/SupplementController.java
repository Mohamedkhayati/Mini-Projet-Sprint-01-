package com.mohamed.supplements.controllers;


import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    // List supplements with pagination
    @RequestMapping("/listeSupplements")
    public String listeSupplements(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        
        Page<Supplement> supps = supplementService.getAllSupplementsParPage(page, size);
        modelMap.addAttribute("supplements", supps);
        modelMap.addAttribute("pages", new int[supps.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeSupplements";
    }


    // Show create form
    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("supplement", new Supplement());
        return "createSupplement";
    }

    @RequestMapping("/saveSupplement")
    public String saveSupplement(@ModelAttribute("supplement") Supplement supplement,
                               @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse(date);
        supplement.setDateCreation(dateCreation);

        Supplement savedSupplement = supplementService.saveSupplement(supplement);
        String msg = "Supplément enregistré avec ID " + savedSupplement.getIdSupplement();
        modelMap.addAttribute("msg", msg);
        return "createSupplement";
    }

    // Delete supplement
    @RequestMapping("/supprimerSupplement")
    public String supprimerSupplement(@RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        
        supplementService.deleteSupplementById(id);
        Page<Supplement> supps = supplementService.getAllSupplementsParPage(page, size);
        modelMap.addAttribute("supplements", supps);
        modelMap.addAttribute("pages", new int[supps.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeSupplements";
    }

    // Edit supplement
    @RequestMapping("/modifierSupplement")
    public String editerSupplement(@RequestParam("id") Long id, ModelMap modelMap) {
        Supplement s = supplementService.getSupplement(id);
        modelMap.addAttribute("supplement", s);
        return "editerSupplement";
    }

    // Update supplement
    @RequestMapping("/updateSupplement")
    public String updateSupplement(@ModelAttribute("supplement") Supplement supplement,
                                   @RequestParam("date") String date,
                                   ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse(date);
        supplement.setDateCreation(dateCreation);
        supplementService.updateSupplement(supplement);
        return "redirect:/listeSupplements";
    }
}