package model;

public class CarteAttaque extends Carte {
	
	public int degats;

	public CarteAttaque(String nom, String description, int degats) {
		super(nom, description);
		this.degats = degats;
	}
	
	@Override
	public void afficherCarte() {
	    affichage.afficherCarteAttaque(nom, description, degats);
	}
	
	@Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
		affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        joueurAdverse.subirDegats(degats);
        affichage.afficherEffetCarteAttaque(joueurAdverse.getNom(), joueurAdverse.getPointsDeVie(), degats);
        joueurActuel.retirerCarte(this);
    }
	
}
