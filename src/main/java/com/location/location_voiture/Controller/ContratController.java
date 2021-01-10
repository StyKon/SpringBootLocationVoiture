package com.location.location_voiture.Controller;
import com.location.location_voiture.Entity.Contrat;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Contrat")
public class ContratController {
	@Autowired
    private ContratRepository contratRepository;
	  @GetMapping(value="/All")
		public ResponseEntity<List<Contrat>> GetAllContrats()
		{
			return ResponseEntity.ok(contratRepository.findAll());
		}
	  @PostMapping(value="/create")
   	  public ResponseEntity<Contrat> CreateContrat(@RequestBody Contrat contrat)
	  {
	  return  ResponseEntity.ok(contratRepository.save(contrat));
	  }
	  @GetMapping("/findContratBy/{NumContrat}")
	  public ResponseEntity<Optional<Contrat>> getContrat(@PathVariable long NumContrat)
	  {
		 return ResponseEntity.ok(contratRepository.findById(NumContrat));
	  }
	  @DeleteMapping(value="/delete/{NumContrat}")
	  public ResponseEntity<Void> DeleteContrat(@PathVariable long NumContrat)
	  {
	   contratRepository.deleteById(NumContrat);
		return new ResponseEntity<Void>(HttpStatus.OK);
	  }

	  @PutMapping(value="/Contrat/{NumContrat}")
	  public ResponseEntity<Contrat> update(@RequestBody Contrat contrat, @PathVariable("NumContrat") long NumContrat) {
			Contrat C = contratRepository.findById(NumContrat)
		                .orElseThrow(()->new NotFoundException("Conducteur avec "+NumContrat+" n'existe pas!"));
			C.setDateContrat(contrat.getDateContrat());
			C.setSociete(contrat.getSociete());
			C.setConducteurs(contrat.getConducteurs());
			C.setVoitures(contrat.getVoitures());
			C.setDateDebutLocation(contrat.getDateDebutLocation());
			C.setDateFinLocation(contrat.getDateFinLocation());
			C.setPrixUnitaireJour(contrat.getPrixUnitaireJour());
			C.setPrixTotal(contrat.getPrixTotal());
			C.setMontantAvance(contrat.getMontantAvance());
			C.setDateCreationContrat(contrat.getDateCreationContrat());
			contratRepository.save(contrat);
	        return ResponseEntity.ok(contrat);
	    }
}
