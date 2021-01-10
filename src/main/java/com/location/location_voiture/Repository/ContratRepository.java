package com.location.location_voiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.location_voiture.Entity.Contrat;
import com.location.location_voiture.Entity.Marque;
@Repository 
public interface ContratRepository  extends JpaRepository<Contrat, Long> {
	public Contrat findByNumContrat(int numContrat);
}
