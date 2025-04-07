package com.mohamed.supplements.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nutritional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNutri;
    private String nomNutri;
    private String descriptionNutri;
    @JsonIgnore
    @OneToMany(mappedBy = "nutritional")
    private List<Supplement> supplements;
    
    public Nutritional() {}
    
    public Nutritional(String nomNutri, String descriptionNutri, List<Supplement> supplements) {
        super();
        this.nomNutri = nomNutri;
        this.descriptionNutri = descriptionNutri;
        this.supplements = supplements;
    }
    
    public Long getIdNutri() {
        return idNutri;
    }
    
    public void setIdNutri(Long idNutri) {
        this.idNutri = idNutri;
    }
    
    public String getNomNutri() {
        return nomNutri;
    }
    
    public void setNomNutri(String nomNutri) {
        this.nomNutri = nomNutri;
    }
    
    public String getDescriptionNutri() {
        return descriptionNutri;
    }
    
    public void setDescriptionNutri(String descriptionNutri) {
        this.descriptionNutri = descriptionNutri;
    }
    
    public List<Supplement> getSupplements() {
        return supplements;
    }
    
    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }
}