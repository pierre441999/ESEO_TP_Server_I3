package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.BddConfig;
import com.dto.Coordonnees;
import com.dto.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	private Logger logger = LoggerFactory.getLogger(VilleDAOImpl.class);
	private BddConfig bddconfig;


	public VilleDAOImpl(BddConfig bddConfig) {
		this.bddconfig = bddConfig;
	}

	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<>();

		try (Connection connexion = bddconfig.getConnection();
				PreparedStatement preparedStatement = connexion
						.prepareStatement("SELECT * FROM ville_france ;")) {

			try (ResultSet resultat = preparedStatement.executeQuery()) {
				while (resultat.next()) {
					String code_Commune = resultat.getString("Code_Commune_INSEE");
					String nomCommune = resultat.getString("Nom_Commune");
					String codePostal = resultat.getString("Code_postal");
					String libelle = resultat.getString("Libelle_acheminement");
					String ligne_5 = resultat.getString("Ligne_5");
					String latitude = resultat.getString("Latitude");
					String longitude = resultat.getString("Longitude");
					Coordonnees coor = new Coordonnees(latitude, longitude);
					
			
					Ville ville = new Ville(code_Commune, nomCommune, codePostal,
							libelle, ligne_5, coor);
					listVille.add(ville);
					
				}
				
				
			}

		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		}
		
		

		return listVille;
	}
	
	public ArrayList<Ville> findSpecificVille(String codeCommune) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try (Connection connexion = bddconfig.getConnection();
				PreparedStatement preparedStatement = connexion
						.prepareStatement("SELECT * FROM ville_france WHERE Code_Commune_INSEE=?")) {
			preparedStatement.setString(1, codeCommune);
			try (ResultSet resultat = preparedStatement.executeQuery()) {
				while (resultat.next()) {
					String code_Commune = resultat.getString("Code_Commune_INSEE");
					String nomCommune = resultat.getString("Nom_Commune");
					String codePostal = resultat.getString("Code_postal");
					String libelle = resultat.getString("Libelle_acheminement");
					String ligne_5 = resultat.getString("Ligne_5");
					String latitude = resultat.getString("Latitude");
					String longitude = resultat.getString("Longitude");
					Coordonnees coor = new Coordonnees(latitude, longitude);
					
			
					Ville ville = new Ville(code_Commune, nomCommune, codePostal,
							libelle, ligne_5, coor);
					listVille.add(ville);
				}
			}

		} 
		
		catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		}

		return listVille;
	}

	public void addVille(Ville ville){
		try (Connection connexion = bddconfig.getConnection();
				PreparedStatement preparedStatement = connexion
						.prepareStatement("INSERT INTO ville_france "
								+ "(Code_Commune_INSEE, Nom_Commune, Code_postal,"
								+ "Libelle_acheminement, Ligne_5, Latitude, Longitude)"
								+ "VALUES (?, ?, ?, ?, ?, ?, ?);"))
		{
			preparedStatement.setString(1, ville.getCodeCommune());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getCodePostale());
			preparedStatement.setString(4, ville.getLibelle());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getCoord().getLatitude());
			preparedStatement.setString(7, ville.getCoord().getLongitude());
			preparedStatement.executeUpdate();
			connexion.commit();
			
			
		} 
		
		catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		}
		
		
	}
	
	public void updateVille(Ville ville, String codeCommune){
		try (Connection connexion = bddconfig.getConnection();
				PreparedStatement preparedStatement = connexion
						.prepareStatement("UPDATE ville_france SET "
								+ "Code_Commune_INSEE = ?, Nom_Commune = ?, Code_postal = ?,"
								+ "Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?,"
								+ "Longitude = ?"
								+ "where Code_Commune_INSEE = ?;")){     
			preparedStatement.setString(1, ville.getCodeCommune());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getCodePostale());
			preparedStatement.setString(4, ville.getLibelle());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getCoord().getLatitude());
			preparedStatement.setString(7, ville.getCoord().getLongitude());
			preparedStatement.setString(8, codeCommune);
			preparedStatement.executeUpdate();
			connexion.commit();
		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		}
	}
	
	public void removeVille(String codeCommune) {
		
		try (Connection connexion = bddconfig.getConnection();
				PreparedStatement preparedStatement = connexion
						.prepareStatement("DELETE FROM ville_france where Code_Commune_INSEE = ?;")){     
			preparedStatement.setString(1, codeCommune);
			preparedStatement.executeUpdate();
			connexion.commit();
		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		}
		
	}





}