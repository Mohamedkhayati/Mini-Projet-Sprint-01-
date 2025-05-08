package com.mohamed.supplements.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.mohamed.supplements.entities.Nutritional;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplementDTO {
    private Long idSupplement;
    private String nomSupplement;
    private String dosageSupplement;
    private Double prixSupplement;
    private String marqueSupplement;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent    
    private Date dateCreation;
    private Nutritional nutritional;
}
