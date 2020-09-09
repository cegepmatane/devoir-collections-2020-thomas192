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
	
}
