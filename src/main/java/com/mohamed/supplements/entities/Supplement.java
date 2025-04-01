package com.mohamed.supplements.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupplement;
    private String nomSupplement;
    private String dosageSupplement;  // Changed from typeSupplement to dosageSupplement
    private Double prixSupplement;
    private String marqueSupplement;
    private Date dateCreation;

    public Supplement() {
        super();
    }

    public Supplement(String nomSupplement, String dosageSupplement, Double prixSupplement, 
                     String marqueSupplement, Date dateCreation) {
        super();
        this.nomSupplement = nomSupplement;
        this.dosageSupplement = dosageSupplement;
        this.prixSupplement = prixSupplement;
        this.marqueSupplement = marqueSupplement;
        this.dateCreation = dateCreation;
    }

    // Getters and Setters
    public Long getIdSupplement() {
        return idSupplement;
    }

    public void setIdSupplement(Long idSupplement) {
        this.idSupplement = idSupplement;
    }

    public String getNomSupplement() {
        return nomSupplement;
    }

    public void setNomSupplement(String nomSupplement) {
        this.nomSupplement = nomSupplement;
    }

    public String getDosageSupplement() {
        return dosageSupplement;
    }

    public void setDosageSupplement(String dosageSupplement) {
        this.dosageSupplement = dosageSupplement;
    }

    public Double getPrixSupplement() {
        return prixSupplement;
    }

    public void setPrixSupplement(Double prixSupplement) {
        this.prixSupplement = prixSupplement;
    }

    public String getMarqueSupplement() {
        return marqueSupplement;
    }

    public void setMarqueSupplement(String marqueSupplement) {
        this.marqueSupplement = marqueSupplement;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Supplement [idSupplement=" + idSupplement + ", nomSupplement=" + nomSupplement 
               + ", dosageSupplement=" + dosageSupplement + ", prixSupplement=" + prixSupplement
               + ", marqueSupplement=" + marqueSupplement + ", dateCreation=" + dateCreation + "]";
    }
}