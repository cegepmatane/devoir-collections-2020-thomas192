package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.VueAjouterSommet;

public class ControleurChaineDeMontagne extends Controleur{

	public ControleurChaineDeMontagne() {
		Logger.logMsg(Logger.INFO, "new ControleurChaineDeMontagne()");
	}
	
	public void actionAfficherVueAjouterSommet() {
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionAfficherVueAjouterSommet()");
		
		Navigateur.getInstance().afficherVue(VueAjouterSommet.getInstance());
	}

}
