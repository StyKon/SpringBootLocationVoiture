package com.location.location_voiture.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voitures")
public class Voiture implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  datemisecirculation;
	
	@Column(name = "numcartegrise")
	private String numcartegrise;

	@Column(name = "kilometrage")
	private int kilometrage;

	@Column(name = "matricule")
	private String matricule;

	@ManyToOne
	@JoinColumn(name = "codeMarque" )
	private Marque marque;

	@ManyToOne
	@JoinColumn(name = "codeModel" )
	private Model model;

	@ManyToOne
	@JoinColumn(name = "codeMaison")
	private Maison maison;
	

	@OneToMany(mappedBy="voitures")
	private List<Contrat> contrats;
	public Voiture(){}

	public Voiture(Long idVoiture, Date datemisecirculation, String numcartegrise,
				   int kilometrage, String matricule, Marque marque, Model model,
				   Maison maison) {
		this.idVoiture = idVoiture;
		this.datemisecirculation = datemisecirculation;
		this.numcartegrise = numcartegrise;
		this.kilometrage = kilometrage;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
		this.maison = maison;
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public Date getDatemisecirculation() {
		return datemisecirculation;
	}

	public void setDatemisecirculation(Date datemisecirculation) {
		this.datemisecirculation = datemisecirculation;
	}

	public String getNumcartegrise() {
		return numcartegrise;
	}

	public void setNumcartegrise(String numcartegrise) {
		this.numcartegrise = numcartegrise;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	



	
	
}
