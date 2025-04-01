package com.mohamed.supplements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohamed.supplements.entities.Supplement;

public interface SupplementRepository extends JpaRepository<Supplement, Long> {
}