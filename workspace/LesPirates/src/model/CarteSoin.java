package model;

public class CarteSoin extends Carte {

    public int pointsDeSoin;

    public CarteSoin(String nom, String description, int pointsDeSoin) {
        super(nom, description);
        this.pointsDeSoin = pointsDeSoin;
    }

    @Override
    public void afficherCarte() {
        affichage.afficherCarteSoin(nom, description, pointsDeSoin);
    }

    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
    	
    	affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        joueurActuel.restaurerVie(pointsDeSoin);
        affichage.afficherEffetCarteSoin(joueurActuel.getNom(), joueurActuel.getPointsDeVie(), pointsDeSoin);
        
        joueurActuel.retirerCarte(this);
    }
}

