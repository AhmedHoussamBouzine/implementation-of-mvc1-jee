/**
 * 
 */
package com.gl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gl.beans.Etudiant;


/**
 * @author houss
 *
 */
public interface EtudiantDao {
	 public Etudiant addEtudiant(Etudiant etudiant) throws  Exception;
	 public Etudiant deleteEtudiant(Etudiant etudiant) throws Exception;
	 public Etudiant updateEtudiant(Etudiant etudiant) throws Exception;
	 public Etudiant updateNomOption(Etudiant etudiant) throws Exception;
	 public Etudiant getEtudiant(String cne) throws Exception;
	 public List<Etudiant> getEtudiants() throws Exception;
	 public List<Etudiant> getEtudiantsByName(String nom) throws Exception;
	 public List<Etudiant> getEtudiantsByOptions(String optionNAME) throws Exception;
	 public List<Etudiant> getEtudiantsSansOption() throws Exception;
     public ResultSet afficheEtudiants() throws Exception;

	
}
