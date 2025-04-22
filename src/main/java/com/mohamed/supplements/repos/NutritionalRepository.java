package com.mohamed.supplements.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohamed.supplements.entities.Nutritional;

public interface NutritionalRepository extends JpaRepository<Nutritional, Long> {
}