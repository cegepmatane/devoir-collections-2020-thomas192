package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurChaineDeMontagne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.ChaineDeMontagne;
import modele.Sommet;

public class VueChaineDeMontagne extends Vue {

	protected ControleurChaineDeMontagne controleur;
	public ControleurChaineDeMontagne getControleur() {return this.controleur;}
	
	protected static VueChaineDeMontagne instance = null; 
	public static VueChaineDeMontagne getInstance() {if(null==instance)instance = new VueChaineDeMontagne();return VueChaineDeMontagne.instance;}; 
	
	private VueChaineDeMontagne() {
		super("chaine-de-montagne.fxml"); 
		super.controleur = this.controleur = new ControleurChaineDeMontagne();
		Logger.logMsg(Logger.INFO, "new VueChaineDeMontagne()");
	}
		
	public void activerControles() {
		super.activerControles();

		Button actionAfficherVueAjouterSommet = (Button)lookup("#action-afficher-vue-ajouter-sommet");

		
		actionAfficherVueAjouterSommet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Logger.logMsg(Logger.INFO, "Clic sur afficher vue ajouter sommet");
				controleur.actionAfficherVueAjouterSommet();
			}});
	}
	
	public void afficherChaineDeMontagne(ChaineDeMontagne chaineDeMontagne) {
		Logger.logMsg(Logger.INFO, "VueChaineDeMontagne.afficherChaineDeMontagne()");
		
		TextArea affichageDescription = (TextArea)lookup("#description-chaine-de-montagne");
		affichageDescription.setText(chaineDeMontagne.getDescription());

		Label affichageNomChaineDeMontagne = (Label)lookup("#chaine-de-montagne-titre");
		affichageNomChaineDeMontagne.setText(chaineDeMontagne.getNom());
	}
	
	public void afficherSommets(List<Sommet> sommets) {
		Logger.logMsg(Logger.INFO, "VueChaineDeMontagne.afficherSommets()");
		
		VBox vueListeSommets = (VBox)lookup("#liste-sommets");
		System.out.println(vueListeSommets);
		vueListeSommets.getChildren().clear();
		
		for (Sommet s: sommets) {
			Logger.logMsg(Logger.INFO, "Sommet "+s.getNom());
			
			Button actionModifier = new Button("Modifier");
			
			HBox vueSommet = new HBox();
			vueSommet.getStyleClass().add("sommet");
			vueSommet.getChildren().add(actionModifier);
			vueSommet.getChildren().add(new Label(s.getNom()+" ("+s.getAltitude()+"m)"));
			
			vueListeSommets.getChildren().add(vueSommet);
		}
		
	}
}
