package model;

public class CartePrendreCarteAdverse extends Carte {

    public CartePrendreCarteAdverse(String nom, String description) {
        super(nom, description);
    }

    @Override
    public void afficherCarte() {
        affichage.afficherCartePrendreCarteChezAdversaire(nom, description);
    }

    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
    	affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
    	joueurAdverse.afficherMain();
    	
    	Carte carteVoler = joueurAdverse.main[affichage.selectionCarteVoler()];
    	
    	carteVoler.afficherCarte();
    	
    	joueurActuel.remplacerCarte(this,carteVoler);
    	
    	joueurAdverse.retirerCarte(carteVoler);
    	joueurAdverse.piocherCarte();
    }
}
