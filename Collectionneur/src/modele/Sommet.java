package modele;

public class Sommet {
	
	protected int id;
	protected String nom;
	protected int altitude;
	protected int idChaineDeMontagne; // a remplacer par reference vers l'objet de flotte
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getIdChaineDeMontagne() {
		return idChaineDeMontagne;
	}
	public void setIdChaineDeMontagne(int idChaineDeMontagne) {
		this.idChaineDeMontagne = idChaineDeMontagne;
	}

}
