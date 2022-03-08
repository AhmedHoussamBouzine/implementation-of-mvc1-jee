/**
 * 
 */
package com.gl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gl.beans.Etudiant;
import com.gl.beans.Option;
import com.gl.business.DefaultServices;
import com.gl.business.Services;
import com.gl.utils.Mysqlsession;

/**
 * @author houss
 */
public class OptionDaoJdbc implements OptionDao {
	private Mysqlsession mysqlsession ;
	private EtudiantDao etudiantDao ;
	public OptionDaoJdbc() {
		 mysqlsession= Mysqlsession.getInstance();
		 etudiantDao = new EtudiantDaoJdbc();
	}
	
	
	@Override
	public Option deleteOption(Option option) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="update etudiant set optionNom = ? where optionNom = ? ;";
		PreparedStatement statement=connection.prepareStatement(query);	
		statement.setString(1,null);
		statement.setString(2,option.getNom());
		statement.executeUpdate();
		
		String query2="delete from options where nom = ?";
		PreparedStatement statement2=connection.prepareStatement(query2);
		statement2.setString(1, option.getNom());
		statement2.execute();   
		connection.close();
		return option;
	}

	@Override
	public Option updateOption(Option option) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="update options set description = ? where nom = ? ;";
		PreparedStatement statement=connection.prepareStatement(query);	
		statement.setString(1, option.getDescription());
		statement.setString(2, option.getNom());
		statement.executeUpdate();
		connection.close();
		return option;
	}

	@Override
	public Option getOption(String nomO) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query2="Select * from options where nom=?";
		PreparedStatement statement=connection.prepareStatement(query2);
		statement.setString(1, nomO);
		ResultSet resultSet=statement.executeQuery();
		if(!resultSet.next())
			return null;
		Option option=new Option();
		option.setNom(resultSet.getString("nom"));
		option.setDescription(resultSet.getString("description"));
		option.setEtudiants(etudiantDao.getEtudiantsByOptions(nomO));
		connection.close();
		return option;
	}

	@Override
	public List<Option> getOptions()  throws Exception  {
		 List<Option> options=new ArrayList<Option>();
			
			Connection connection=mysqlsession.getConnection();
			String query="Select * from options";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
			Option option=new Option();
			option.setNom(resultSet.getString("nom"));
			option.setDescription(resultSet.getString("description"));
			
			options.add(option);
			}
			connection.close();
			return options;
	}



	@Override
	public Option addOption(Option option) throws Exception {
		Connection connection=mysqlsession.getConnection();
		String query="insert into options values(?,?)";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, option.getNom());
		statement.setString(2, option.getDescription());
		statement.execute();
		connection.close();
		connection.close();
		return option;
		
	}



}
