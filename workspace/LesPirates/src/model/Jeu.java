package model;

import affichages.IAffichage;

public class Jeu {
    private static IAffichage affichage;
    private Pioche pioche;
    private Joueur joueurActuel;
    private Joueur joueurPres;
    boolean finDuJeuTrouvee = false;

    public static IAffichage getAffichage() {
        return affichage;
    }

    public static void setAffichage(IAffichage affichage) {
        Jeu.affichage = affichage;
    }

    public void lancerJeu() {

        affichage.afficherBienvenue();
        affichage.afficherRegles();
        pioche = new Pioche();
        joueurActuel = new Joueur("Jack le Borgne", pioche);
        joueurPres = new Joueur("Bill Jambe-de-Bois", pioche);
        
        System.out.println("\n--- Début de la partie ---");
        
        demarrerTour();
        Joueur temp = joueurPres;
        joueurPres = joueurActuel;
        joueurActuel = temp;
        affichage.determineFinPartie(joueurActuel.getPointsDeVie(),joueurPres.getPointsDeVie(),joueurActuel.getPopularite(),joueurPres.getPopularite(),pioche.piocheVide());
        
    }
    
    public void demarrerTour() {
        
        while (joueurActuel.getPointsDeVie() > 0 && joueurPres.getPointsDeVie() > 0 && joueurPres.getPopularite() < 3 && joueurActuel.getPopularite() < 3 && !pioche.piocheVide() && !finDuJeuTrouvee) {
            
            affichage.afficherNomTour(joueurActuel.getNom());
            
            affichage.affichageScore(joueurActuel.getNom(), joueurActuel.getPointsDeVie(), joueurActuel.getPopularite(), joueurPres.getNom(), joueurPres.getPointsDeVie(), joueurPres.getPopularite());
            
            joueurActuel.afficherMain();
            
            joueurActuel.piocherCarte();
            
            for (int i = 0; i < joueurActuel.main.length; i++) {
                if (joueurActuel.main[i] instanceof CarteFinDuJeu) {
                    joueurActuel.main[i].jouerCarte(joueurActuel, joueurPres);
                    finDuJeuTrouvee = true;
                }
            }
            if (!finDuJeuTrouvee) {

	            Carte carteAJouer = joueurActuel.main[affichage.selectionCarte()]; 
	
	            carteAJouer.jouerCarte(joueurActuel, joueurPres);
	
	            Joueur temp = joueurPres;
	            joueurPres = joueurActuel;
	            joueurActuel = temp;
	            }
        }}
    
   

}
