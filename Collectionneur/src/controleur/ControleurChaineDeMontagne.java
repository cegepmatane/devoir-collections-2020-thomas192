package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ChaineDeMontagneDAO;
import donnee.SommetDAO;
import modele.ChaineDeMontagne;
import modele.Sommet;
import vue.Navigateur;
import vue.VueAjouterSommet;
import vue.VueChaineDeMontagne;

public class ControleurChaineDeMontagne extends Controleur {
	
	
	protected ChaineDeMontagneDAO chaineDeMontagneDAO = new ChaineDeMontagneDAO();
	protected SommetDAO sommetDAO = new SommetDAO();
	
	protected ChaineDeMontagne chaineDeMontagne = null;
	protected List<Sommet> sommets = null;

	public ControleurChaineDeMontagne() {
		Logger.logMsg(Logger.INFO, "new ControleurChaineDeMontagne()");
	}
	
	public void actionConsulterChaineDeMontagne(int id) {
		
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionConsulterChaineDeMontagne("+id+")");
		this.chaineDeMontagne = chaineDeMontagneDAO.detaillerChaineDeMontagne(id);
		VueChaineDeMontagne.getInstance().afficherChaineDeMontagne(this.chaineDeMontagne);
		this.sommets = sommetDAO.listerSommetsParChaineDeMontagne(id);
		VueChaineDeMontagne.getInstance().afficherSommets(this.sommets);
		
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}
	
	public void actionAfficherVueAjouterSommet() {
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionAfficherVueAjouterSommet()");
		
		Navigateur.getInstance().afficherVue(VueAjouterSommet.getInstance());
	}
	
	public void actionAjouterSommet() {
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionAjouterSommet()");
		
		Sommet sommet = VueAjouterSommet.getInstance().lireSommet();
		sommet.setIdChaineDeMontagne(chaineDeMontagne.getId());
		SommetDAO sommetDAO = new SommetDAO();
		sommetDAO.ajouterSommet(sommet);
		this.sommets.add(sommet);
		VueChaineDeMontagne.getInstance().afficherSommets(sommets);
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}

}
