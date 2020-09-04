package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ChaineDeMontagneDAO;
import vue.Navigateur;
import vue.VueChaineDeMontagne;

public class ControleurChainesDeMontagnes extends Controleur{

	public ControleurChainesDeMontagnes()
	{
		Logger.logMsg(Logger.INFO, "new ControleurChainesDeMontagnes()");
	}
	
	// RECEPTION des EVENEMENTS
	public void actionOuvrirChaineDeMontagne(int numero)
	{
		ChaineDeMontagneDAO collectionDAO = new ChaineDeMontagneDAO();
		VueChaineDeMontagne.getInstance().afficherChaineDeMontagne(collectionDAO.detaillerChaineDeMontagne(numero));
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}

}
