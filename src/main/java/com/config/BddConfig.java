package com.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

public class BddConfig {

	private String url;
	private String username;
	private String password;
	private static final String DRIVER = "org.mysql.jdbc.Driver";
	private Logger logger1 = LoggerFactory.getLogger(VilleDAOImpl.class);
	private static Logger logger2 = LoggerFactory.getLogger(VilleDAOImpl.class);

	public BddConfig(String fichier) {
		loadBDDProperties(fichier);
	}

	// Méthode

	public void loadBDDProperties(String path) {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(path)) {
			Properties prop = new Properties();
			if (input != null) {
				prop.load(input);
			} else {
				throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
			}
			this.url = prop.getProperty("url");
			this.username = prop.getProperty("login");
			this.password = prop.getProperty("password");
		} catch (IOException ex) {
			this.logger1.error("Impossible d'accéder à la bdd.", ex);

		}
	}

	public static BddConfig getInstance() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			logger2.error("Impossible d'accéder à la bdd.", e);

		}
		return new BddConfig("configBDD.properties");

	}

	@Bean
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(this.url, this.username, this.password);;
		try {
			
			connection.setAutoCommit(false);

		} catch (SQLException e) {
			this.logger1.error("Impossible d'exécuter la requête.", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger1.error("Impossible de se déconnecter.", e);
			}
		}
		return connection;
	}

	// Récupération du Dao
	public VilleDAO getVilleDao() {
		return new VilleDAOImpl(this);
	}

}
