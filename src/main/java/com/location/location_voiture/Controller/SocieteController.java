package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Societe;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Societe")
public class SocieteController {
	@Autowired
    private SocieteRepository SocieteRepository;
	@GetMapping(value="/All")
	public ResponseEntity<List<Societe>> GetAllSocietes()
	{
		return ResponseEntity.ok(SocieteRepository.findAll());
	}
	@PostMapping(value="/create")
	public ResponseEntity<Societe> CreateSociete(@RequestBody Societe societe)
	{
	  return ResponseEntity.ok(SocieteRepository.save(societe));
	}
	@GetMapping("/findSocieteBy/{NumSociete}")
	public ResponseEntity<Optional<Societe>> getSociete(@PathVariable long NumSociete)
	{
       return ResponseEntity.ok(SocieteRepository.findById(NumSociete));
	}
    @DeleteMapping(value="/delete/{NumSociete}")
	public ResponseEntity<Void> DeleteSociete(@PathVariable long NumSociete)
	{
	  SocieteRepository.deleteById(NumSociete);
	  return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping(value="/societe/{NumSociete}")
	public ResponseEntity<Societe> update(@RequestBody Societe societe, @PathVariable("NumSociete") long NumSociete) {
			Societe S = SocieteRepository.findById(NumSociete)
		                .orElseThrow(()->new NotFoundException("Societe avec "+NumSociete+" n'existe pas!"));
			S.setNomSociete(societe.getNomSociete());
			S.setPersonnePhysique(societe.getPersonnePhysique());
			S.setAdresseSociete(societe.getAdresseSociete());
			S.setTelSociete(societe.getTelSociete());
			S.setMailSociete(societe.getMailSociete());
			S.setDateCreationSociete(societe.getDateCreationSociete());
			S.setPrenomNomRepresentantSociete(societe.getPrenomNomRepresentantSociete());
			S.setTelRepresentantSociete(societe.getTelRepresentantSociete());

			SocieteRepository.save(societe);
	        return ResponseEntity.ok(societe);
	    }
}
