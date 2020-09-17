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
import vue.VueModifierSommet;

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
		sommet.setIdChaineDeMontagne(this.chaineDeMontagne.getId());
		
		Logger.logMsg(Logger.INFO, "Informations sur le sommet qui va être ajouté : "+sommet.getNom()+
				" "+sommet.getAltitude()+" "+sommet.getIdChaineDeMontagne());
		
		SommetDAO sommetDAO = new SommetDAO();
		sommetDAO.ajouterSommet(sommet);
		this.sommets.add(sommet);
		VueChaineDeMontagne.getInstance().afficherSommets(sommets);
		
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}
	
	protected Sommet sommet;
	public void actionAfficherVueModifierSommet(int id) {
		SommetDAO sommetDAO = new SommetDAO();
		this.sommet = sommetDAO.detaillerSommet(id);
		
		Logger.logMsg(Logger.INFO, "ControleurChaineDeMontagne.actionAfficherVueModifierSommet("+id+")");
		VueModifierSommet.getInstance().afficherSommet(sommet);
		VueModifierSommet.getInstance().afficherChaineDeMontagne(chaineDeMontagne);
		
		Navigateur.getInstance().afficherVue(VueModifierSommet.getInstance());
	}
	
	public void actionModifierSommet() {
		Logger.logMsg(Logger.INFO, "ControleurChainesDeMontagnes.actionModifierSommet()");
		
		Sommet sommet = VueModifierSommet.getInstance().lireSommet();
		sommet.setIdChaineDeMontagne(chaineDeMontagne.getId());
		sommet.setId(this.sommet.getId());
		
		Logger.logMsg(Logger.INFO, "Informations sur le sommet qui va être modifié : "+sommet.getId()+" "+sommet.getNom()+
				" "+sommet.getAltitude()+" "+sommet.getIdChaineDeMontagne());
		
		SommetDAO sommetDAO = new SommetDAO();
		sommetDAO.modifierSommet(sommet);
		this.sommets = sommetDAO.listerSommetsParChaineDeMontagne(chaineDeMontagne.getId()); // A optimiser plus tard
		VueChaineDeMontagne.getInstance().afficherSommets(sommets);
		
		Navigateur.getInstance().afficherVue(VueChaineDeMontagne.getInstance());
	}

}
