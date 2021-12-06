package com.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;

import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

public class BddConfig {
	
	private String url;
	private String username;
	private String password;
	private static final String DRIVER = "org.mysql.jdbc.Driver";
	
    public BddConfig(String fichier) {
    	loadBDDProperties(fichier);
    }

    //Méthode
    
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
	        ex.printStackTrace();
	    }
    }
	
	public static BddConfig getInstance() {
		try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
    
        }
        return new BddConfig("configBDD.properties");
        
    }


	@Bean
    public Connection getConnection() throws SQLException {
		Connection connexion = DriverManager.getConnection(this.url, this.username, this.password);
		connexion.setAutoCommit(false);
        return connexion;
		
    }  

    // Récupération du Dao
    public VilleDAO getVilleDao() {
        return new VilleDAOImpl(this);
    }

}
