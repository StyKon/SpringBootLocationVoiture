package com.location.location_voiture.Controller;

import com.location.location_voiture.Entity.Model;
import com.location.location_voiture.Exception.NotFoundException;
import com.location.location_voiture.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Model")
public class ModelController {
	
	@Autowired
    private ModelRepository ModelRepository;
    
	 @GetMapping(value="/All")
	 public ResponseEntity<List<Model>> GetAllModel()
	 {
		return ResponseEntity.ok(ModelRepository.findAll());
	 }
	 @PostMapping(value="/create")
	 public ResponseEntity<Model> CreateModel(@RequestBody Model model)
	 {
		return  ResponseEntity.ok(ModelRepository.save(model));
	 }
	    
	 @GetMapping("/findModelBy/{codeModel}")
	 public ResponseEntity<Optional<Model>> getModel(@PathVariable long codeModel)
	 {

		 return ResponseEntity.ok(ModelRepository.findById(codeModel));
	 }
	@DeleteMapping(value="/delete/{codeModel}")
	public ResponseEntity<Void> DeleteVoiture( @PathVariable long codeModel)
	{
		ModelRepository.deleteById(codeModel);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping(value="/model/{codeModel}")
	public ResponseEntity<Model> update(@RequestBody Model model, @PathVariable("codeModel") long codeModel) {
		Model M = ModelRepository.findById(codeModel)
					.orElseThrow(()->new NotFoundException("Voiture avec "+codeModel+" n'existe pas!"));

		M.setNomModel(model.getNomModel());
		ModelRepository.save(model);
		return ResponseEntity.ok(model);
	}
}
