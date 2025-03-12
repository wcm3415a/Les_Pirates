package model;

import affichages.IAffichage;
import affichages.Affichage;

public class JouerJeu {
    public static void main(String[] args) {
        IAffichage affichage = new Affichage();
        
        Jeu.setAffichage(affichage);

        Jeu jeu = new Jeu();
        jeu.lancerJeu();
    }
}
