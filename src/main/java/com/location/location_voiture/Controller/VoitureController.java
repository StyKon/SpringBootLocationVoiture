package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Voiture;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Voiture")
public class VoitureController {

	@Autowired
    private VoitureRepository VoitureRepository;
    
    @GetMapping(value="/All")
	public ResponseEntity<List<Voiture>> GetAllVoitures()
	{
       return ResponseEntity.ok(VoitureRepository.findAll());
	}
    @PostMapping(value="/create")
	public ResponseEntity<Voiture> CreateVoiture(@RequestBody Voiture voiture)
	{
    	return ResponseEntity.ok(VoitureRepository.save(voiture));
	}
	@GetMapping("/findVoitureBy/{idVoiture}")
	public ResponseEntity<Optional<Voiture>> getVoiture(@PathVariable long idVoiture)
	{
		 return ResponseEntity.ok(VoitureRepository.findById(idVoiture));
	}
	@DeleteMapping(value="/delete/{idVoiture}")
	public ResponseEntity<Void> DeleteVoiture(@PathVariable long idVoiture)
	{
		VoitureRepository.deleteById(idVoiture);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping(value="/voiture/{idVoiture}")
	public ResponseEntity<Voiture> update(@RequestBody Voiture voiture, @PathVariable("idVoiture") long idVoiture) {
		Voiture V = VoitureRepository.findById(idVoiture)
	                .orElseThrow(()->new NotFoundException("Voiture avec "+idVoiture+" n'existe pas!"));
		V.setDatemisecirculation(voiture.getDatemisecirculation());
		V.setKilometrage(voiture.getKilometrage());
		V.setMatricule(voiture.getMatricule());
		V.setNumcartegrise(voiture.getNumcartegrise());
		V.setMaison(voiture.getMaison());
		V.setMarque(voiture.getMarque());
		V.setModel(voiture.getModel());
		VoitureRepository.save(voiture);
        return ResponseEntity.ok(voiture);
    }

	
}
