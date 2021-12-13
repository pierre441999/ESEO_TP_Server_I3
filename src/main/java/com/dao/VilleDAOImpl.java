package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.BddConfig;
import com.dto.Coordonnees;
import com.dto.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	private Logger logger = LoggerFactory.getLogger(VilleDAOImpl.class);
	private BddConfig bddconfig;

	PreparedStatement preparedStatement = null;
	ResultSet resultat = null;

	public VilleDAOImpl(BddConfig bddConfig) {
		this.bddconfig = bddConfig;
	}

	@Override
	public List<Ville> findAllVilles() throws SQLException {
		List<Ville> listVille = new ArrayList<>();
		Connection connection = this.bddconfig.getConnection();

		try {
			connection = bddconfig.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM ville_france ;");
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				String code_Commune = resultat.getString("Code_Commune_INSEE");
				String nomCommune = resultat.getString("Nom_Commune");
				String codePostal = resultat.getString("Code_postal");
				String libelle = resultat.getString("Libelle_acheminement");
				String ligne_5 = resultat.getString("Ligne_5");
				String latitude = resultat.getString("Latitude");
				String longitude = resultat.getString("Longitude");
				Coordonnees coor = new Coordonnees(latitude, longitude);

				Ville ville = new Ville(code_Commune, nomCommune, codePostal, libelle, ligne_5, coor);
				listVille.add(ville);

			}
			preparedStatement.close();
		}

		catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
		return listVille;
	}

	public ArrayList<Ville> findSpecificVille(String codeCommune) throws SQLException {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		Connection connection = this.bddconfig.getConnection();
		try {
			connection = bddconfig.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM ville_france WHERE Code_Commune_INSEE=?");
			preparedStatement.setString(1, codeCommune);
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				String code_Commune = resultat.getString("Code_Commune_INSEE");
				String nomCommune = resultat.getString("Nom_Commune");
				String codePostal = resultat.getString("Code_postal");
				String libelle = resultat.getString("Libelle_acheminement");
				String ligne_5 = resultat.getString("Ligne_5");
				String latitude = resultat.getString("Latitude");
				String longitude = resultat.getString("Longitude");
				Coordonnees coor = new Coordonnees(latitude, longitude);

				Ville ville = new Ville(code_Commune, nomCommune, codePostal, libelle, ligne_5, coor);
				listVille.add(ville);
			}

			preparedStatement.close();
		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}

		return listVille;
	}

	public void addVille(Ville ville) throws SQLException {
		Connection connection = this.bddconfig.getConnection();

		try {
			connection = bddconfig.getConnection();
			preparedStatement = connection
					.prepareStatement("INSERT INTO ville_france " + "(Code_Commune_INSEE, Nom_Commune, Code_postal,"
							+ "Libelle_acheminement, Ligne_5, Latitude, Longitude)" + "VALUES (?, ?, ?, ?, ?, ?, ?);");

			preparedStatement.setString(1, ville.getCodeCommune());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getCodePostale());
			preparedStatement.setString(4, ville.getLibelle());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getCoord().getLatitude());
			preparedStatement.setString(7, ville.getCoord().getLongitude());
			preparedStatement.executeUpdate();
			connection.commit();
			preparedStatement.close();
		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}

	}

	public void updateVille(Ville ville, String codeCommune) throws SQLException {
		Connection connection = this.bddconfig.getConnection();

		try {
			connection = bddconfig.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE ville_france SET " + "Code_Commune_INSEE = ?, Nom_Commune = ?, Code_postal = ?,"
							+ "Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?," + "Longitude = ?"
							+ "where Code_Commune_INSEE = ?;");
			preparedStatement.setString(1, ville.getCodeCommune());
			preparedStatement.setString(2, ville.getNomCommune());
			preparedStatement.setString(3, ville.getCodePostale());
			preparedStatement.setString(4, ville.getLibelle());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getCoord().getLatitude());
			preparedStatement.setString(7, ville.getCoord().getLongitude());
			preparedStatement.setString(8, codeCommune);
			preparedStatement.executeUpdate();
			connection.commit();
			preparedStatement.close();
		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}
	}

	public void removeVille(String codeCommune) throws SQLException {
		Connection connection = this.bddconfig.getConnection();

		try {
			connection = bddconfig.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM ville_france where Code_Commune_INSEE = ?;");
			preparedStatement.setString(1, codeCommune);
			preparedStatement.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			this.logger.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Impossible de se déconnecter.", e);
			}
		}

	}

}