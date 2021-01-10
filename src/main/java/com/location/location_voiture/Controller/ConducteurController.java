package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Conducteur;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Conducteur")
public class ConducteurController {
	@Autowired
    private ConducteurRepository conducteurRepository;
	    @GetMapping(value="/All")
		public ResponseEntity<List<Conducteur>> GetAllConducteurs()
		{
			return ResponseEntity.ok(conducteurRepository.findAll());
		}
	    @PostMapping(value="/create")
		public ResponseEntity<Conducteur> CreateSociete(@RequestBody Conducteur conducteur)
		{
		  return ResponseEntity.ok(conducteurRepository.save(conducteur));

		}
		@GetMapping("/findConducteurBy/{CodeConducteur}")
		 public ResponseEntity<Optional<Conducteur>> getConducteur(@PathVariable long CodeConducteur)
		 {
		 	return ResponseEntity.ok(conducteurRepository.findById(CodeConducteur));
		 }
		@DeleteMapping(value="/delete/{CodeConducteur}")
		public ResponseEntity<Void> DeleteConducteur(@PathVariable long CodeConducteur)
		{
			conducteurRepository.deleteById(CodeConducteur);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}

		@PutMapping(value="/Conducteur/{CodeConducteur}")
	  public ResponseEntity<Conducteur> update(@RequestBody Conducteur conducteur, @PathVariable("CodeConducteur") long CodeConducteur) {
			Conducteur C = conducteurRepository.findById(CodeConducteur)
		                .orElseThrow(()->new NotFoundException("Conducteur avec "+CodeConducteur+" n'existe pas!"));
			C.setPrenomNomConducteur(conducteur.getPrenomNomConducteur());
			C.setDateNaissance(conducteur.getDateNaissance());
			C.setNumPermisConduite(conducteur.getNumPermisConduite());
			C.setDateLivraisonPermisConduite(conducteur.getDateLivraisonPermisConduite());
			C.setDateFinValidite(conducteur.getDateFinValidite());
			C.setAdresse(conducteur.getAdresse());
			C.setTel(conducteur.getTel());
			C.setNumCIN(conducteur.getNumCIN());
			C.setDateCin(conducteur.getDateCin());
			C.setMailConducteur(conducteur.getMailConducteur());
			C.setDateCreationConducteur(conducteur.getDateCreationConducteur());
			conducteurRepository.save(conducteur);
	        return ResponseEntity.ok(conducteur);
	    }
}
