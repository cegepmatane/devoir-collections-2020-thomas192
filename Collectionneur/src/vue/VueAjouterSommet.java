package vue;

import com.sun.media.jfxmedia.logging.Logger;

public class VueAjouterSommet extends Vue {

	protected static VueAjouterSommet instance;
	public static VueAjouterSommet getInstance() {if(null == instance) instance = new VueAjouterSommet(); return instance;};
	
	private VueAjouterSommet() {
		super("ajouter-sommet.fxml");
		Logger.logMsg(Logger.INFO, "new VueAjouterSommet()");
	}
	
	public void activerControles() {
		super.activerControles();
	}
	
}
