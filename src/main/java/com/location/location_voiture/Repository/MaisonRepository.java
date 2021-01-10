package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.location_voiture.Entity.Maison;
import com.location.location_voiture.Entity.Marque;

public interface MaisonRepository extends JpaRepository<Maison, Long> {
	public Maison findByCodeMaison(int codeMaison);
}
