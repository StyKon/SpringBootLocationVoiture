package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Marque;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Marque")
public class MarqueController {
	
	@Autowired
	private MarqueRepository MarqueRepository;
	
	@GetMapping(value="/All")
	public ResponseEntity<List<Marque>> GetAllMarque()
	{
		return ResponseEntity.ok(MarqueRepository.findAll());
	}
    @PostMapping(value="/create")
	public ResponseEntity<Marque> CreateMarque(@RequestBody Marque marque)
	{
    	 return  ResponseEntity.ok(MarqueRepository.save(marque));
	}
    
    @GetMapping("/findMarqueBy/{codeMarque}")
	 public ResponseEntity<Optional<Marque>> getMarque(@PathVariable long codeMarque)
	 {
		 return  ResponseEntity.ok(MarqueRepository.findById(codeMarque));
	 }
	@DeleteMapping(value="/delete/{codeMarque}")
	public ResponseEntity<Void> DeleteMarque( @PathVariable long codeMarque)
	{
		MarqueRepository.deleteById(codeMarque);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	@PutMapping(value="/marque/{codeMarque}")
	public ResponseEntity<Marque> update(@RequestBody Marque marque, @PathVariable("codeMarque") long codeMarque) {
		Marque M = MarqueRepository.findById(codeMarque)
	                .orElseThrow(()->new NotFoundException("Marque avec "+codeMarque+" n'existe pas!"));
	
		M.setNomMarque(marque.getNomMarque());
		MarqueRepository.save(marque);
        return ResponseEntity.ok(marque);
	}

}
