// SupplementServiceImpl.java
package com.mohamed.supplements.service;

import com.mohamed.supplements.dto.SupplementDTO;
import com.mohamed.supplements.entities.Nutritional;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.repos.NutritionalRepository;
import com.mohamed.supplements.repos.SupplementRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SupplementServiceImpl implements SupplementService {

    @Autowired
    private SupplementRepository supplementRepository;
    @Autowired
    ModelMapper modelMapper;
    // Existing methods
    @Override
    public SupplementDTO saveSupplement(SupplementDTO  s) {
        return convertEntityToDto(supplementRepository.save(convertDtoToEntity(s)));
    }

    @Override
    public Supplement updateSupplement(SupplementDTO  s) {
        return supplementRepository.save(convertDtoToEntity(s));
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
    public SupplementDTO getSupplement(Long id) {
        return convertEntityToDto(supplementRepository.findById(id).orElse(null));
    }

    @Override
    public List<SupplementDTO> getAllSupplements() {
        return supplementRepository.findAll().stream()
            .map(this::convertEntityToDto)
            .collect(Collectors.toList());
        //OU BIEN
        /*List<Supplement> supplements = supplementRepository.findAll();
        List<SupplementDTO> listSuppDto = new ArrayList<>(supplements.size());
        for (Supplement s : supplements)
            listSuppDto.add(convertEntityToDto(s));
        return listSuppDto;*/
    }
    @Override
    public Supplement convertDtoToEntity(SupplementDTO supplementDto) {
        return modelMapper.map(supplementDto, Supplement.class);
    }



    // New method for pagination
    @Override
    public Page<Supplement> getAllSupplementsParPage(int page, int size) {
        return supplementRepository.findAll(PageRequest.of(page, size));
    }
    @Override
    public List<Supplement> findByNomSupplement(String nom) {
        return supplementRepository.findByNomSupplement(nom);
    }

    @Override
    public List<Supplement> findByNomSupplementContains(String nom) {
        return supplementRepository.findByNomSupplementContains(nom);
    }

	@Override
	public List<Supplement> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplement> findByNutritional(Nutritional nutritional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplement> findByNutritionalIdNutri(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplement> findByOrderByNomSupplementAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplement> trierSupplementsNomsPrix() {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
	NutritionalRepository nutritionalRepository;

	@Override
	public List<Nutritional> getAllNutritionals() {
	    return nutritionalRepository.findAll();
	}
	@Override
	public SupplementDTO convertEntityToDto(Supplement supplement) {
	    SupplementDTO supplementDTO = modelMapper.map(supplement, SupplementDTO.class);
	    return supplementDTO;
	


	    /*return SupplementDTO.builder()
	        .idSupplement(supplement.getIdSupplement())
	        .nomSupplement(supplement.getNomSupplement())
	        .dosageSupplement(supplement.getDosageSupplement())
	        .prixSupplement(supplement.getPrixSupplement())
	        .marqueSupplement(supplement.getMarqueSupplement())
	        .dateCreation(supplement.getDateCreation())
	        .nutritional(supplement.getNutritional())
	        .build();*/
	}


  /*  @Override
    public List<Supplement> findByNomPrix(String nom, Double prix) {
        return supplementRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Supplement> findByNutritional(Nutritional nutritional) {
        return supplementRepository.findByNutritional(nutritional);
    }

    @Override
    public List<Supplement> findByNutritionalIdNutri(long id) {
        return supplementRepository.findByNutritionalIdNutri(id);
    }

    @Override
    public List<Supplement> findByOrderByNomSupplementAsc() {
        return supplementRepository.findByOrderByNomSupplementAsc();
    }

    @Override
    public List<Supplement> trierSupplementsNomsPrix() {
        return supplementRepository.trierSupplementsNomsPrix();
    }*/
}