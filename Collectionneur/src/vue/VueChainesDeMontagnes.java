package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurChainesDeMontagnes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modele.ChaineDeMontagne;

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
	
	public void afficherChainesDeMontagnes(List<ChaineDeMontagne> chainesDeMontagnes)
	{
		VBox vueChainesDeMontagnes = (VBox)lookup("#liste-chaines-de-montagnes");
		System.out.println(vueChainesDeMontagnes);
		vueChainesDeMontagnes.getChildren().clear();
		
		for(ChaineDeMontagne c : chainesDeMontagnes)
		{
			
			Logger.logMsg(Logger.INFO,"Chaine de montagne recue par la vue : " + c.getNom());
			
			Button actionConsulter = new Button("Consulter");
			
			actionConsulter.setId(c.getId()+"");
			actionConsulter.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Button source = (Button)e.getSource();
					Logger.logMsg(Logger.INFO, "Clic sur la chaine de montagne " + source.getId());
					controleur.actionConsulterChaineDeMontagne(Integer.parseInt(source.getId()));
				}
			});
			
			
			HBox nouvelleChaineDeMontagne = new HBox();
			nouvelleChaineDeMontagne.setAlignment(Pos.CENTER_LEFT);
			nouvelleChaineDeMontagne.getStyleClass().add("chaine-de-montagne");
			nouvelleChaineDeMontagne.getChildren().add(actionConsulter);
			nouvelleChaineDeMontagne.getChildren().add(new Label(c.getNom()));
			
			vueChainesDeMontagnes.getChildren().add((nouvelleChaineDeMontagne));
		}
		
	}
	
	
}
