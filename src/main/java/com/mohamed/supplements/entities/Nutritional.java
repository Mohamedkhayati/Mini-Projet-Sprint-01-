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
    
  
    
    
}