package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurChaineDeMontagne;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class VueChaineDeMontagne extends Vue {

	protected ControleurChaineDeMontagne controleur;
	protected static VueChaineDeMontagne instance = null; 
	public static VueChaineDeMontagne getInstance() {if(null==instance)instance = new VueChaineDeMontagne();return VueChaineDeMontagne.instance;}; 
	
	private VueChaineDeMontagne() 
	{
		super("chaine_de_montagne.fxml"); 
		super.controleur = this.controleur = new ControleurChaineDeMontagne();
		Logger.logMsg(Logger.INFO, "new VueChaineDeMontagne()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherChaineDeMontagne(modele.ChaineDeMontagne collection)
	{
		TextArea affichageDescription = (TextArea)lookup("#collection-description");
		affichageDescription.setText(collection.getDescription());

		Label affichageTitre = (Label)lookup("#titre-page");
		affichageTitre.setText(collection.getNom());
	}
}
