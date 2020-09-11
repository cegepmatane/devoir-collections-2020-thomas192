package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ChaineDeMontagneDAO;
import donnee.SommetDAO;
import vue.Navigateur;
import vue.VueChaineDeMontagne;

public class ControleurChainesDeMontagnes extends Controleur {
	
	protected ChaineDeMontagneDAO chaineDeMontagneDAO = new ChaineDeMontagneDAO();
	protected SommetDAO sommetDAO = new SommetDAO();

	public ControleurChainesDeMontagnes() {
		Logger.logMsg(Logger.INFO, "new ControleurChainesDeMontagnes()");
	}
	
	// RECEPTION des EVENEMENTS
	public void actionConsulterChaineDeMontagne(int id) {
		
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionConsulterChaineDeMontagne("+id+")");
		
		VueChaineDeMontagne.getInstance().afficherChaineDeMontagne(chaineDeMontagneDAO.detaillerChaineDeMontagne(id));
		VueChaineDeMontagne.getInstance().afficherSommets(sommetDAO.listerSommetsParChaineDeMontagne(id));
		
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}

}
