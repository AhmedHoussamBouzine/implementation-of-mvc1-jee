/**
 * 
 */
package com.gl.beans;


/**
 * @author houss
 *
 */
public class Etudiant {
	private String cne;
	private String nom;
	private String prenom;
	private Option option;
	
	public Etudiant() {
		super();
	}
	/**
	 * @param cne
	 * @param nom
	 * @param prenom
	 * @param option
	 */
	public Etudiant(String cne, String nom, String prenom) {
		super();
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * @param cne the cne to set
	 */
	public void setCne(String cne) {
		this.cne = cne;
	}
	/**
	 * @return the cne
	 */
	
	public String getCne() {
		return cne;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * 
	 */
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the option
	 */
	public Option getOption() {
		return option;
	}
	/**
	 * @param option the option to set
	 */
	public void setOption(Option option) {
		this.option = option;
	}
}
