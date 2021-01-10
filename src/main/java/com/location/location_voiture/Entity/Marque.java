package com.location.location_voiture.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity 
@Table(name = "marques")
public class Marque implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeMarque;
	@Column(name = "nomMarque")
	@Size(max = 50)
	private String nomMarque; 
	
	@OneToMany(mappedBy="marque")
	private List<Voiture> voitures;
	@ManyToOne
	@JoinColumn(name="codeMaison")
	private Maison maison;
	public Marque() {}

	public Marque(Long codeMarque, String nomMarque, Maison maison) {
		this.codeMarque = codeMarque;
		this.nomMarque = nomMarque;
		this.maison = maison;
	}

	public Long getCodeMarque() {
		return codeMarque;
	}

	public void setCodeMarque(Long codeMarque) {
		this.codeMarque = codeMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}
}
