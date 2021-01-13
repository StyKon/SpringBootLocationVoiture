package com.location.location_voiture.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Contrat")
public class Contrat  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numContrat;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  dateContrat;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   dateDebutLocation;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  dateFinLocation;
	@Column(name = "prixUnitaireJour")
	private Double prixUnitaireJour;
	@Column(name = "prixTotal")
	private Double prixTotal;
	@Column(name = "montantAvance")
	private Double montantAvance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date  dateCreationContrat;



	@ManyToOne
    @JoinColumn(name="numSociete")
    private Societe societe;

	@ManyToOne
	@JoinColumn(name="idVoiture")
	private Voiture voitures;
	@ManyToOne
	@JoinColumn(name="codeConducteur")
    private Conducteur conducteurs;
	public Contrat() {}
	public Contrat(Long numContrat, Date dateContrat, Date dateDebutLocation, Date dateFinLocation,
			Double prixUnitaireJour, Double prixTotal, Double montantAvance, Date dateCreationContrat, Societe societe,
			Voiture voitures, Conducteur conducteurs) {
		super();
		this.numContrat = numContrat;
		this.dateContrat = dateContrat;
		this.dateDebutLocation = dateDebutLocation;
		this.dateFinLocation = dateFinLocation;
		this.prixUnitaireJour = prixUnitaireJour;
		this.prixTotal = prixTotal;
		this.montantAvance = montantAvance;
		this.dateCreationContrat = dateCreationContrat;
		this.societe = societe;
		this.voitures = voitures;
		this.conducteurs = conducteurs;
	}
	public Long getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(Long numContrat) {
		this.numContrat = numContrat;
	}
	public Date getDateContrat() {
		return dateContrat;
	}
	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}
	public Date getDateDebutLocation() {
		return dateDebutLocation;
	}
	public void setDateDebutLocation(Date dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}
	public Date getDateFinLocation() {
		return dateFinLocation;
	}
	public void setDateFinLocation(Date dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}
	public Double getPrixUnitaireJour() {
		return prixUnitaireJour;
	}
	public void setPrixUnitaireJour(Double prixUnitaireJour) {
		this.prixUnitaireJour = prixUnitaireJour;
	}
	public Double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public Double getMontantAvance() {
		return montantAvance;
	}
	public void setMontantAvance(Double montantAvance) {
		this.montantAvance = montantAvance;
	}
	public Date getDateCreationContrat() {
		return dateCreationContrat;
	}
	public void setDateCreationContrat(Date dateCreationContrat) {
		this.dateCreationContrat = dateCreationContrat;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	public Voiture getVoitures() {
		return voitures;
	}
	public void setVoitures(Voiture voitures) {
		this.voitures = voitures;
	}
	public Conducteur getConducteurs() {
		return conducteurs;
	}
	public void setConducteurs(Conducteur conducteurs) {
		this.conducteurs = conducteurs;
	}
	

	@PrePersist
	private void onCreate() {
		dateCreationContrat = new Date();
	}
	




	
}
