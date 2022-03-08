/**
 * 
 */
package com.gl.business;

import java.util.List;

import com.gl.beans.Etudiant;
import com.gl.beans.Option;
import com.gl.dao.EtudiantDao;
import com.gl.dao.EtudiantDaoJdbc;
import com.gl.dao.OptionDao;
import com.gl.dao.OptionDaoJdbc;


/**
 * @author houss
 *
 */
public class DefaultServices implements Services {
	
	  private static DefaultServices instance = null;
	  private EtudiantDao etudiantDao;
	  private OptionDao optionDao;
	  
	  /**
	 * @return the etudiantDao
	 */
	public EtudiantDao getEtudiantDao() {
		return etudiantDao;
	}

	private DefaultServices() {
		 etudiantDao = new EtudiantDaoJdbc();
		 optionDao = new OptionDaoJdbc();
	  }
	  
	public static DefaultServices getInstance(){

		  if(instance == null)
		    instance = new DefaultServices();

		  return instance;

		  }

   

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		return etudiantDao.addEtudiant(etudiant);
	}

	@Override
	public Etudiant deleteEtudiant(Etudiant etudiant) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.deleteEtudiant(etudiant);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.updateEtudiant(etudiant);
	}

	@Override
	public Etudiant getEtudiant(String cne) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.getEtudiant(cne);
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.getEtudiants();
	}

	@Override
	public List<Etudiant> getEtudiantsByName(String nom) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.getEtudiantsByName(nom);
	}

	@Override
	public Option addOption(Option option) throws Exception {
		// TODO Auto-generated method stub
		return optionDao.addOption(option);
	}

	@Override
	public Option deleteOption(Option option) throws Exception {
		// TODO Auto-generated method stub
		return optionDao.deleteOption(option);
	}

	@Override
	public Option updateOption(Option option) throws Exception {
		// TODO Auto-generated method stub
		return optionDao.updateOption(option);
	}

	@Override
	public Option getOption(String nom) throws Exception {
		// TODO Auto-generated method stub
		return optionDao.getOption(nom);
	}

	@Override
	public List<Option> getOptions() throws Exception {
		// TODO Auto-generated method stub
		return optionDao.getOptions();
	}


	@Override
	public boolean transferEtudiantOption(Etudiant etudiant, Option option) throws Exception {
        etudiant.setOption(option);
		return  etudiantDao.updateEtudiant(etudiant) != null;
	}

	@Override
	public List<Etudiant> getEtudiantsByOptions(String optionNAME) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.getEtudiantsByOptions(optionNAME);
	}

	@Override
	public Etudiant updateNomOption(Etudiant etudiant) throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.updateNomOption(etudiant);
	}

	@Override
	public List<Etudiant> getEtudiantsSansOption() throws Exception {
		// TODO Auto-generated method stub
		return etudiantDao.getEtudiantsSansOption();
	}

}
