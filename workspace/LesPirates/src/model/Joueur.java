package model;

import affichages.IAffichage;

public class Joueur {
    private String nom;
    private int pointsDeVie  = 3;
    private int popularite  = 0;
    Carte[] main;
    private int nombreDeCartes  = 0;
    private Pioche pioche;
    
    protected IAffichage affichage = Jeu.getAffichage();

    public Joueur(String nom, Pioche pioche) {
        this.nom = nom;
        this.pioche = pioche;
        this.main = new Carte[5];
        piocherCartesInitiales();
    }

    private void piocherCartesInitiales() {
        for (int i = 0; i < 4; i++) {
            piocherCarte();
        }
    }

    public void piocherCarte() {
        
        if (nombreDeCartes < main.length) {
            
            Carte cartePiochee = pioche.piocherCarte();
            if (cartePiochee != null) {
                
                if (main[nombreDeCartes] == null) {
                    main[nombreDeCartes] = cartePiochee;
                    nombreDeCartes++;
                    affichage.afficherNomPioche(nom);
                    cartePiochee.afficherCarte();
                    
                } else {
                    
                    for (int i = 0; i < main.length; i++) {
                        if (main[i] == null) {
                            main[i] = cartePiochee;
                            nombreDeCartes++;
                            affichage.afficherNomPioche(nom);
                            cartePiochee.afficherCarte();
                        }
                    }
                }
            } 
        } 
    }

    public void afficherMain() {
        System.out.println("Main de " + nom + " :");
        for (int i = 0; i < nombreDeCartes; i++) {
        	affichage.anoncerNumCarte(i);
            main[i].afficherCarte();
        }
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPopularite() {
        return popularite;
    }

    public void subirDegats(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
        }
    }

    public void augmenterPopularite(int points) {
        this.popularite += points;
        
    }

    public void diminuerPopularite(int points) {
        this.popularite -= points;
        if (this.popularite < 0) {
            this.popularite = 0;
        }
    }
    
    public void restaurerVie(int points) {
        this.pointsDeVie += points;
    }
    
    public void retirerCarte(Carte carte) {
        for (int i = 0; i < nombreDeCartes; i++) {
            if (main[i] == carte) {
                for (int j = i; j < nombreDeCartes - 1; j++) {
                    main[j] = main[j + 1];
                }
                main[nombreDeCartes - 1] = null; 
                nombreDeCartes--; 
                break;
            }
        }
    }
}
