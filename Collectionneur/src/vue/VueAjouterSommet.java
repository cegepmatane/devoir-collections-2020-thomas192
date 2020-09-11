package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurChaineDeMontagne;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Sommet;

public class VueAjouterSommet extends Vue {
	
	protected ControleurChaineDeMontagne controleur;

	protected static VueAjouterSommet instance;
	public static VueAjouterSommet getInstance() {if(null == instance) instance = new VueAjouterSommet(); return instance;};
	
	private VueAjouterSommet() {
		super("ajouter-sommet.fxml");
		Logger.logMsg(Logger.INFO, "new VueAjouterSommet()");
	}
	
	public void activerControles() {
		super.activerControles();
		
		Button actionAjouterSommet = (Button)lookup("#action-ajouter-sommet");
		actionAjouterSommet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Logger.logMsg(Logger.INFO, "Clic sur ajouter sommet");
				controleur.actionAjouterSommet();
				
			}});
	}
	
	public Sommet lireSommet() {
		Sommet sommet = new Sommet();
		TextField nom = (TextField)lookup("#nom-sommet");
		sommet.setNom(nom.getText());
	
		return sommet;
	}
	
}
