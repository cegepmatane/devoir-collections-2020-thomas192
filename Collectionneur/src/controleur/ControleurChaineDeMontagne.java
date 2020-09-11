package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;

public class ControleurChaineDeMontagne extends Controleur{

	public ControleurChaineDeMontagne() {
		Logger.logMsg(Logger.INFO, "new ControleurChaineDeMontagne()");
	}
	
	public void notifierClicAjouterChaineDeMontagne() {
		//Navigateur.getInstance().afficherVueAjouter(VueAjouterChaineDeMontagne.getInstance());
	}

}
