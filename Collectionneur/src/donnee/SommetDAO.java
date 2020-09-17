package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import modele.Sommet;

public class SommetDAO {
	
	public Sommet detaillerSommet(int id) {
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		Sommet sommet = new Sommet();
		PreparedStatement requete;
		try {
			requete = connection.prepareStatement("SELECT * FROM sommet WHERE id = ?");
			requete.setInt(1, id);
			ResultSet curseur = requete.executeQuery();
			curseur.next();
			String nom = curseur.getString("nom");
			int altitude = curseur.getInt("altitude");
			sommet.setNom(nom);
			sommet.setAltitude(altitude);
			sommet.setId(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return sommet;
	}
	
	public List<Sommet> listerSommetsParChaineDeMontagne(int id) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		List<Sommet> listeSommets = new ArrayList<Sommet>();
		
		try {
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM sommet WHERE id_chainedemontagne = ?");
			requete.setInt(1, id);
			ResultSet curseur = requete.executeQuery();
			Logger.logMsg(Logger.INFO, "Chaine de montagne id = "+id);
			while (curseur.next()) {
				id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				int altitude = curseur.getInt("altitude");
				
				Sommet sommet = new Sommet();
				sommet.setId(id);
				sommet.setNom(nom);
				sommet.setAltitude(altitude);
				
				listeSommets.add(sommet);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listeSommets;
	}
	
	public void ajouterSommet(Sommet sommet) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		try {
			PreparedStatement requete = connection.prepareStatement("INSERT INTO sommet(nom,altitude) VALUES(?,?)");
			requete.setString(1, sommet.getNom());
			requete.setInt(2, sommet.getAltitude());
			requete.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void modifierSommet(Sommet sommet) {
		
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		try {
			PreparedStatement requete = connection.prepareStatement("UPDATE sommet SET nom = ?, altitude = ? WHERE id = ?");
			requete.setString(1, sommet.getNom());
			requete.setInt(2, sommet.getAltitude());
			requete.setInt(3, sommet.getId());
			requete.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
