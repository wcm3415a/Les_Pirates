package model;

public class CarteDiffamation extends Carte {
	
	public int valeur;
	
    public CarteDiffamation(String nom, String description, int valeur) {
        super(nom, description);
        this.valeur = valeur;
    }

    @Override
    public void afficherCarte() {
    	affichage.afficherCarteDiffamation(nom, description, valeur);
    }
    
    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
    	affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        joueurAdverse.diminuerPopularite(valeur);
        affichage.afficherEffetCarteDiffamation(joueurAdverse.getNom(), joueurAdverse.getPopularite(), valeur);
        joueurActuel.retirerCarte(this);
    }

}
