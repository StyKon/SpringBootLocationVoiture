package com.location.location_voiture.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity 
@Table(name = "maisons")
public class Maison implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeMaison;
	@Column(name = "nomMaison")
	private String nomMaison; 
	
	@OneToMany(mappedBy="maisonvoit")
	private List<Voiture> voitures; 
  
	/*
	@OneToMany(mappedBy="maisonmod")
	private List<Model> models;*/

	@OneToMany(mappedBy="maison")
	private List<Marque> marques;


	public Maison(){}

	public Maison(Long codeMaison, String nomMaison) {
		this.codeMaison = codeMaison;
		this.nomMaison = nomMaison;


	}

	public Long getCodeMaison() {
		return codeMaison;
	}


	public void setCodeMaison(Long codeMaison) {
		this.codeMaison = codeMaison;
	}


	public String getNomMaison() {
		return nomMaison;
	}


	public void setNomMaison(String nomMaison) {
		this.nomMaison = nomMaison;
	}


}