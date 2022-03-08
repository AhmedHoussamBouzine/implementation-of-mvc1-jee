/**
 * 
 */
package com.gl.business;

import java.sql.ResultSet;
import java.util.List;

import com.gl.beans.Etudiant;
import com.gl.beans.Option;

/**
 * @author houss
 *
 */
public interface Services {
	//etudiant
	 public Etudiant addEtudiant(Etudiant etudiant) throws Exception;
	 public Etudiant deleteEtudiant(Etudiant etudiant) throws Exception ;
	 public Etudiant updateEtudiant(Etudiant etudiant) throws Exception;
	 public Etudiant getEtudiant(String cne) throws Exception;
	 public List<Etudiant> getEtudiants() throws Exception;
	 public List<Etudiant> getEtudiantsByName(String nom) throws Exception;
	 public List<Etudiant> getEtudiantsByOptions(String optionNAME) throws Exception;
	 public Etudiant updateNomOption(Etudiant etudiant) throws Exception;
	 public List<Etudiant> getEtudiantsSansOption() throws Exception;
    	 
     
	 
	 //option 
	 
	 public Option addOption(Option option) throws Exception;
	 public Option deleteOption(Option option) throws Exception;
	 public Option updateOption(Option option) throws Exception;
	 public Option getOption(String nom) throws Exception;
	 public List<Option> getOptions() throws Exception;

	 
	 //divers 
	 
	 public boolean transferEtudiantOption(Etudiant etudiant , Option option) throws Exception;
}
