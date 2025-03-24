package model;

public class CarteFinDuJeu extends Carte {

    public CarteFinDuJeu(String nom, String description) {
        super(nom, description);
    }

    @Override
    public void afficherCarte() {
        affichage.afficherCarteFinDuJeu(nom, description);
    }

    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {
        affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        terminerPartie(joueurActuel, joueurAdverse);
    }

    private void terminerPartie(Joueur joueur1, Joueur joueur2) {
        Joueur gagnant;
        Boolean egalite = false;
        if (joueur1.getPopularite() > joueur2.getPopularite()) {
            gagnant = joueur1;
        } else if (joueur2.getPopularite() > joueur1.getPopularite()) {
            gagnant = joueur2;
        } else {
        	gagnant = joueur1;
        	egalite = true;
        }

        affichage.afficherFinPartie(gagnant.getNom(),gagnant.getPopularite(),egalite);
        
    }
}
