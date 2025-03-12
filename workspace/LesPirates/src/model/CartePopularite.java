package model;

public class CartePopularite extends Carte {
    public int pointsPopularite;

    public CartePopularite(String nom, String description, int pointsPopularite) {
        super(nom, description);
        this.pointsPopularite = pointsPopularite;
    }

    @Override
    public void afficherCarte() {
        affichage.afficherCartePopularite(nom, description, pointsPopularite);
    }
    
    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
    	affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        joueurActuel.augmenterPopularite(pointsPopularite);
        affichage.afficherEffetCartePopularite(joueurActuel.getNom(), joueurActuel.getPopularite(), pointsPopularite);
        joueurActuel.retirerCarte(this);
    }
}
