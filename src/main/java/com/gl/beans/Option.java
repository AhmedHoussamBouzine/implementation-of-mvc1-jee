/**
 * 
 */
package com.gl.beans;


import java.util.ArrayList;
import java.util.List;


/**
 * @author houss
 *
 */
public class Option {
	private String nom;
	private String Description;
	private List<Etudiant> etudiants;
	
	/**
	 * 
	 */
	public Option() {
		super();
		etudiants=new ArrayList<Etudiant>();
	}
	/**
	 * @param nom
	 * @param description
	 */
	public Option(String nom, String description) {
		super();
		this.nom = nom;
		this.Description = description;
		etudiants=new ArrayList<Etudiant>();
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the etudiants
	 */
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	/**
	 * @param etudiants the etudiants to set
	 */
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
}
