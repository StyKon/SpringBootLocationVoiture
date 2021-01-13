package com.location.location_voiture.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity 
@Table(name = "models")
public class Model implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeModel;

	@Column(name = "nomModel")
	private String nomModel;
	@OneToMany(mappedBy="model")
	private List<Voiture> voitures;

	public Model(){}

	public Model(String nomModel) {

		this.nomModel = nomModel;

	}

	public Model(Long codeModel, String nomModel) {
		this.codeModel = codeModel;
		this.nomModel = nomModel;
	}

	public Long getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(Long codeModel) {
		this.codeModel = codeModel;
	}

	public String getNomModel() {
		return nomModel;
	}

	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}

}
