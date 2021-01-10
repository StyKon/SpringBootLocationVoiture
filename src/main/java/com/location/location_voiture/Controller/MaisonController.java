package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Maison;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.MaisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Maison")
public class MaisonController {
	
	@Autowired
	private MaisonRepository MaisonRepository;
	
	@GetMapping(value="/All")
	public ResponseEntity<List<Maison>> GetAllMaison()
	{
		return ResponseEntity.ok(MaisonRepository.findAll());
	}
    @PostMapping(value="/create")
	public ResponseEntity<Maison> CreateMison(@RequestBody Maison maison)
	{
    	return ResponseEntity.ok(MaisonRepository.save(maison));
	}
    
     @GetMapping("/findMaisonBy/{codeMaison}")
	 public ResponseEntity<Optional<Maison>> getMaison(@PathVariable long codeMaison)
	 {
		 return ResponseEntity.ok(MaisonRepository.findById(codeMaison));
	 }
	@DeleteMapping(value="/delete/{codeMaison}")
	public ResponseEntity<Void> DeleteMaison( @PathVariable long codeMaison)
	{
		MaisonRepository.deleteById(codeMaison);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping(value="/maison/{codeMaison}")
	public ResponseEntity<Maison> update(@RequestBody Maison maison, @PathVariable("codeMaison") long codeMaison) {
		Maison M = MaisonRepository.findById(codeMaison)
	                .orElseThrow(()->new NotFoundException("Maison avec "+codeMaison+" n'existe pas!"));
	
		M.setNomMaison(maison.getNomMaison());
		MaisonRepository.save(maison);
        return ResponseEntity.ok(maison);
	}

}
