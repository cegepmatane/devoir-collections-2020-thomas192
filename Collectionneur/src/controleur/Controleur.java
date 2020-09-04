package controleur;

import donnee.ChaineDeMontagneDAO;
import vue.Vue;
import vue.VueChainesDeMontagnes;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		ChaineDeMontagneDAO chaineDeMontagneDAO = new ChaineDeMontagneDAO();
		VueChainesDeMontagnes.getInstance().afficherChainesDeMontagnes(chaineDeMontagneDAO.listerChainesDeMontagnes());
		return VueChainesDeMontagnes.getInstance();
	}
		
}
