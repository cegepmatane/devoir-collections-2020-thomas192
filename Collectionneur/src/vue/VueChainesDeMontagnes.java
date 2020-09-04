package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurChainesDeMontagnes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VueChainesDeMontagnes extends Vue {

	protected ControleurChainesDeMontagnes controleur;
	protected static VueChainesDeMontagnes instance = null; 
	public static VueChainesDeMontagnes getInstance() {if(null==instance)instance = new VueChainesDeMontagnes();return VueChainesDeMontagnes.instance;}; 
	
	private VueChainesDeMontagnes() 
	{
		super("chaines_de_montagnes.fxml"); 
		super.controleur = this.controleur = new ControleurChainesDeMontagnes();
		Logger.logMsg(Logger.INFO, "new VueChainesDeMontagnes()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherChainesDeMontagnes(List<modele.ChaineDeMontagne> collections)
	{
		int position = 1;
		for(modele.ChaineDeMontagne collection : collections)
		{
			Button libelle = (Button)lookup("#categorie-" + position);
			System.out.println(collection.getNom());
			libelle.setText(collection.getNom());
			libelle.setId(collection.getId()+""); // l'id est changé mais on n'a plus besoin de recuperer l'objet
			
			libelle.setOnAction(new EventHandler<ActionEvent>() 
			{
	            @Override public void handle(ActionEvent e) 
	            {
	            	Logger.logMsg(Logger.INFO, "Bouton Collection active");
	            	Button bouton = (Button)e.getSource();
	            	controleur.actionOuvrirChaineDeMontagne(Integer.parseInt(bouton.getId()));
	            }
	        });

			position++;
			if(position > 8) break;
		}
		
		
	}
	
	
}
