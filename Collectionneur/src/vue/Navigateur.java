package vue;

import com.sun.media.jfxmedia.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

// Classe qui regroupe toutes les vues et permet de changer de page
public abstract class Navigateur extends Application{ // Application de javafx est en réalité une fenêtre
	
	protected Stage stade;
		
	private static Navigateur instance = null;
	public static Navigateur getInstance() {return instance;}	
	protected Navigateur()
	{
		instance = this;
		Logger.setLevel(Logger.INFO);
		VueChainesDeMontagnes.getInstance().activerControles();
		VueChaineDeMontagne.getInstance().activerControles();
		VueAjouterSommet.getInstance().activerControles();
		VueAjouterSommet.getInstance().controleur = VueChaineDeMontagne.getInstance().controleur;
	}
	
	public void afficherVue(Vue vue)
	{
		stade.setScene(vue);
		stade.show();				
	}
}
