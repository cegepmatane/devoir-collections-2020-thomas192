package controleur;

import donnee.ChaineDeMontagneDAO;
import vue.Vue;
import vue.VueChainesDeMontagnes;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		ChaineDeMontagneDAO collectionDAO = new ChaineDeMontagneDAO();
		VueChainesDeMontagnes.getInstance().afficherChainesDeMontagnes(collectionDAO.listerChainesDeMontagnes());
		return VueChainesDeMontagnes.getInstance();
	}
		
}
