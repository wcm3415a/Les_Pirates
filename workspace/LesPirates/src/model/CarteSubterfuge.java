package model;

public class CarteSubterfuge extends Carte{
    private int populariteVolee;  


    public CarteSubterfuge(String nom, String description, int populariteVolee) {
        super(nom, description);  
        this.populariteVolee = populariteVolee;
    }


    @Override
    public void afficherCarte() {
        affichage.afficherCarteEspionnage(nom, description, populariteVolee);
    }

 
    @Override
    public void jouerCarte(Joueur joueurActuel, Joueur joueurAdverse) {

        affichage.afficherCarteJouee(joueurActuel.getNom(), nom, description);
        

        joueurActuel.augmenterPopularite(populariteVolee);
        joueurAdverse.diminuerPopularite(populariteVolee);
        
        affichage.afficherEffetCarteEspionnage(joueurAdverse.getNom(), populariteVolee);
        
        joueurActuel.retirerCarte(this);
    }


}
