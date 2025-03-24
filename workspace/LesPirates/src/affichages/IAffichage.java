package affichages;

public interface IAffichage {
	void afficherBienvenue();
	void afficherRegles();
	void afficherCarte(String nomDeLaCarte, String description);
	void afficherCarteAttaque(String nomDeLaCarte, String description, int degats);
	void afficherCartePopularite(String nomDeLaCarte, String description, int pointsPopularite);
	void afficherCarteDiffamation(String nomDeLaCarte, String description, int pointsDiffamation);
	void afficherCarteSoin(String nomDeLaCarte, String description, int pointsSoin);
	void afficherEffetCarteAttaque(String nomJoueurAdverse, int degats, int pointsDeVieAdverse);
    void afficherEffetCartePopularite(String nomJoueurActuel, int pointsPopularite, int populariteActuelle);
    void afficherEffetCarteDiffamation(String nomJoueurAdverse, int pointsDiffamation, int populariteAdverse);
    void afficherEffetCarteSoin(String nomJoueurActuel, int pointsDeSoin, int pointsDeVieActuel);
    void afficherCarteJouee(String nomJoueur, String nomCarte, String descriptionCarte);
    void determineFinPartie(int pointsDeVieJoueurActuel, int pointsDeVieJoueurPres, int populariteJoueurActuel, int populariteJoueurPres, boolean piocheVide);
    void afficherNomTour(String nom);
    int selectionCarte();
    void affichageScore(String nomJoueur1, int pointsDeVieJoueur1, int populariteJoueur1,String nomJoueur2, int pointsDeVieJoueur2, int populariteJoueur2);
    void afficherNomPioche(String nom);
    void afficherCarteEspionnage(String nom, String description, int valeur);
    void afficherEffetCarteEspionnage(String nomJoueurCible, int valeur);
    void afficherCarteFinDuJeu(String nom, String description);
    void afficherFinPartie(String gagnant, int popularite, boolean egalite);
    void anoncerNumCarte(int num);
    int selectionCarteVoler();
    void afficherCartePrendreCarteChezAdversaire(String nomDeLaCarte, String description);
    
    

}
