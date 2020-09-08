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
		ChaineDeMontagneDAO chaineDeMontagneDAO = new ChaineDeMontagneDAO();
		VueChaineDeMontagne.getInstance().afficherChaineDeMontagne(chaineDeMontagneDAO.listerSommetsParChaineDeMontagne(numero));
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}

}
