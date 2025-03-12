package model;

import affichages.IAffichage;

abstract class Carte{
	public String nom;
	public String description;

	protected IAffichage affichage = Jeu.getAffichage();
	
	public Carte(String nom, String description) {
		this.nom = nom;
		this.description = description;

	}
	
	public void afficherCarte() {
	    affichage.afficherCarte(nom, description);
	}
	
	public abstract void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse);
}
