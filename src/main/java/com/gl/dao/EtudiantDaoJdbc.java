/**
 * 
 */
package com.gl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gl.utils.*;
import com.gl.beans.Etudiant;
import com.gl.beans.Option;

/**
 * @author houss
 *
 */
public class EtudiantDaoJdbc implements EtudiantDao {
    
	 Mysqlsession mysqlsession;
	 
	 public EtudiantDaoJdbc() {
		 mysqlsession= Mysqlsession.getInstance();
	 }
		@Override
		public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
			
			Connection connection=mysqlsession.getConnection();
			String query="insert into etudiant values(?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, etudiant.getCne());
			statement.setString(2, etudiant.getNom());
			statement.setString(3, etudiant.getPrenom());
			statement.setString(4, etudiant.getOption().getNom());
			statement.execute();
			connection.close();
			return etudiant;
		}

	@Override
	public Etudiant deleteEtudiant(Etudiant etudiant) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="delete from etudiant where cne = ?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, etudiant.getCne());
		statement.execute();   
		connection.close();
		return etudiant;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="update etudiant set nom = ? ,prenom=?,optionNom = ? where cne = ? ;";
		PreparedStatement statement=connection.prepareStatement(query);	
		statement.setString(1, etudiant.getNom());
		statement.setString(2, etudiant.getPrenom());
		statement.setString(3, etudiant.getOption().getNom());
		statement.setString(4, etudiant.getCne());
		statement.executeUpdate();
		connection.close();
		return etudiant;
	}

	@Override
	public Etudiant getEtudiant(String cne) throws Exception {
		
		Connection connection=mysqlsession.getConnection();
		String query="Select * from etudiant where cne=?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, cne);
		ResultSet resultSet=statement.executeQuery();
		if(!resultSet.next())
			return null;
		Etudiant etudiant=new Etudiant();
		etudiant.setCne(resultSet.getString("cne"));
		etudiant.setNom(resultSet.getString("nom"));
		etudiant.setPrenom(resultSet.getString("prenom"));
		//recuperation de l'option
		String optionId=resultSet.getString("optionNom");
		if(optionId != null) {
		String query2="Select * from options where nom=?";
		PreparedStatement statement2=connection.prepareStatement(query2);
		statement2.setString(1, optionId);
		ResultSet resultSet2=statement2.executeQuery();
		resultSet2.next();
		Option option=new Option();
		option.setNom(resultSet2.getString("nom"));
		option.setDescription(resultSet2.getString("description"));
		
		etudiant.setOption(option);
		connection.close();}
		else {
			etudiant.setOption(null);
			connection.close();
		}
		return etudiant;
		
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		
       List<Etudiant> etudiants=new ArrayList<Etudiant>();
		
       String request = "select * from etudiant;";
	    Statement smt = mysqlsession.getConnection().createStatement();
	    ResultSet rs = smt.executeQuery(request);
       while (rs.next()) {
       	String cne = rs.getString("cne");
       	String nom = rs.getString("nom");
           String prenom = rs.getString("prenom");
           String nom_option = rs.getString("optionNom");
           Etudiant etudiant = new Etudiant(nom, prenom, cne);
           if(nom_option != null) {
           String request2 = "select * from options where nom =  '"+ nom_option +"' ;";
		    Statement smt2 = mysqlsession.getConnection().createStatement();
		    ResultSet rs1 = smt2.executeQuery(request2);
		    Option option =  new Option();
		    while (rs1.next()) {
           	String nomOp = rs1.getString("nom");
               String description = rs1.getString("description");
               option.setNom(nomOp);
               option.setDescription(description);
               
           }
		    etudiant.setOption(option);
		    //System.out.println(etudiant.getOption().getNom());
           etudiants.add(etudiant);
		
	   }
           
       else {
    	   etudiant.setOption(null);
		    //System.out.println(etudiant.getOption().getNom());
          etudiants.add(etudiant);
       }
       }
       return etudiants;
	}

	@Override
	public List<Etudiant> getEtudiantsByName(String nomE) throws Exception {
		
		 List<Etudiant> etudiants=new ArrayList<Etudiant>();
			
			Connection connection=mysqlsession.getConnection();
			String query="Select * from etudiant where nom = ?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, nomE);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
			Etudiant etudiant=new Etudiant();
			etudiant.setCne(resultSet.getString("cne"));
			etudiant.setNom(resultSet.getString("nom"));
			etudiant.setPrenom(resultSet.getString("prenom"));
			//recuperation de l'option
			String optionId=resultSet.getString("optionNom");
			String query2="Select * from options where nom=?";
			PreparedStatement statement2=connection.prepareStatement(query2);
			statement2.setString(1, optionId);
			ResultSet resultSet2=statement2.executeQuery();
			while (resultSet2.next()) {
				Option option=new Option();
				option.setNom(resultSet2.getString("nom"));
				option.setDescription(resultSet2.getString("description"));
				 
				etudiant.setOption(option);
				}
			etudiants.add(etudiant);
			}
			connection.close();
			return etudiants;
	}
	@Override
	public List<Etudiant> getEtudiantsByOptions(String optionNAME) throws Exception {
		 List<Etudiant> etudiants=new ArrayList<Etudiant>();
			
			Connection connection=mysqlsession.getConnection();
			String query="Select * from etudiant where optionNom = ?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, optionNAME);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
			Etudiant etudiant=new Etudiant();
			etudiant.setCne(resultSet.getString("cne"));
			etudiant.setNom(resultSet.getString("nom"));
			etudiant.setPrenom(resultSet.getString("prenom"));
			//recuperation de l'option
			String optionId=resultSet.getString("optionNom");
			String query2="Select * from options where nom=?";
			PreparedStatement statement2=connection.prepareStatement(query2);
			statement2.setString(1, optionId);
			ResultSet resultSet2=statement2.executeQuery();
			while (resultSet2.next()) {
				Option option=new Option();
				option.setNom(resultSet2.getString("nom"));
				option.setDescription(resultSet2.getString("description"));
				 
				etudiant.setOption(option);
				}
			etudiants.add(etudiant);
			}
			connection.close();
			return etudiants;
	}
	@Override
	public Etudiant updateNomOption(Etudiant etudiant) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="update etudiant set optionNom = ? where optionNom = ? ;";
		PreparedStatement statement=connection.prepareStatement(query);	
		statement.setString(1,null);
		statement.setString(2, etudiant.getOption().getNom());
		statement.executeUpdate();
		return etudiant;
	}
	
	@Override
	public List<Etudiant> getEtudiantsSansOption() throws Exception {
		  List<Etudiant> etudiants=new ArrayList<Etudiant>();
			
			Connection connection=mysqlsession.getConnection();
			String query="Select * from etudiant where optionNom is null ";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
			Etudiant etudiant=new Etudiant();
			etudiant.setCne(resultSet.getString("cne"));
			etudiant.setNom(resultSet.getString("nom"));
			etudiant.setPrenom(resultSet.getString("prenom"));
			etudiants.add(etudiant);
			}
			connection.close();
			return etudiants;
	}
	@Override
	public ResultSet afficheEtudiants() throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="Select * from etudiant";
		PreparedStatement statement=connection.prepareStatement(query);
		ResultSet resultSet=statement.executeQuery();		
		return resultSet;
	}

}
