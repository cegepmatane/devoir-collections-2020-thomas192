package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ChaineDeMontagneDAO;
import donnee.SommetDAO;
import vue.Navigateur;
import vue.VueChaineDeMontagne;

public class ControleurChainesDeMontagnes extends Controleur {

	public ControleurChainesDeMontagnes() {
		Logger.logMsg(Logger.INFO, "new ControleurChainesDeMontagnes()");
	}
	
	// RECEPTION des EVENEMENTS
	public void actionConsulterChaineDeMontagne(int id) {
		
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionConsulterChaineDeMontagne("+id+")");
		
		VueChaineDeMontagne.getInstance().getControleur().actionConsulterChaineDeMontagne(id);
	}

}
