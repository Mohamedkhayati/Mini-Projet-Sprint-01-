package com.mohamed.supplements.controllers;

import com.mohamed.supplements.dto.SupplementDTO;
import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.service.SupplementService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SupplementController {

    @Autowired
    private SupplementService supplementService;
 


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

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        List<Nutritional> nutritionals = supplementService.getAllNutritionals();
        modelMap.addAttribute("supplement", new Supplement());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("nutritionals", nutritionals);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formSupplement";
    }

    @RequestMapping("/saveSupplement")
    public String saveSupplement(@Valid @ModelAttribute("supplement") SupplementDTO supplement,
                                 BindingResult bindingResult,
                                 @RequestParam(name = "dateCreation", defaultValue = "") String dateStr,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "5") int size,
                                 ModelMap modelMap) throws ParseException {
        
        // Handle date conversion
        if (!dateStr.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                Date dateCreation = dateFormat.parse(dateStr);
                supplement.setDateCreation(dateCreation);
            } catch (ParseException e) {
                bindingResult.rejectValue("dateCreation", "error.supplement", "Format de date invalide (yyyy-MM-dd)");
            }
        }

        List<Nutritional> nutritionals = supplementService.getAllNutritionals();
        modelMap.addAttribute("nutritionals", nutritionals);
        modelMap.addAttribute("mode", supplement.getIdSupplement() == null ? "new" : "edit");
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        if (bindingResult.hasErrors()) {
            return "formSupplement";
        }

        supplementService.saveSupplement(supplement);
        return "redirect:/listeSupplements?page=" + page + "&size=" + size;
    }

    @RequestMapping("/supprimerSupplement")
    public String supprimerSupplement(@RequestParam("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        supplementService.deleteSupplementById(id);
        return "redirect:/listeSupplements?page=" + page + "&size=" + size;
    }

    @RequestMapping("/modifierSupplement")
    public String editerSupplement(@RequestParam("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            ModelMap modelMap) {
        SupplementDTO s = supplementService.getSupplement(id);
        List<Nutritional> nutritionals = supplementService.getAllNutritionals();
        modelMap.addAttribute("supplement", s);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("nutritionals", nutritionals);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formSupplement";
    }

 /**   @RequestMapping({"/", "/index"})
    public String index(ModelMap modelMap) {
        return "index";
    }*/
    @GetMapping("/accessDenied")
    public String error()
    {
    return "accessDenied";
    }
}