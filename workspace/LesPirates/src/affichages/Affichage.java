package affichages;

import java.util.Scanner;

public class Affichage implements IAffichage {
	
	@Override
	public void afficherBienvenue() {
		System.out.println("=========================");
		System.out.println("Bienveneue sur le jeu des Pirates!");
		System.out.println("=========================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	@Override
	public void afficherRegles() {
		System.out.println("");
		System.out.println("Les règles du jeu sont les suivantes :");
		System.out.println("Le Jeu des Pirates est un jeu de société de cartes dans lequel deux joueurs s'affrontent.");
		System.out.println("Chaque joueur pioche quatre cartes. À tour de rôle, un pirate pioche une nouvelle carte et l'ajoute à sa main.");
		System.out.println("Il doit ensuite décider s'il attaque son adversaire ou s'il s'attribue des points de popularité.");
		System.out.println("Chaque pirate possède cinq cœurs rouges correspondant à ses points de vie.");
		System.out.println("S'il n'a plus de cœur, alors il a perdu et son adversaire gagne.");
		System.out.println("Le but du jeu est que son pirate atteigne cinq points de popularité ou simplement survive plus longtemps que son adversaire !");
		System.out.println("");
		System.out.println("");
	}

	
	@Override
	public void afficherCarte(String nomDeLaCarte, String description) {
	    System.out.println(nomDeLaCarte);
	    System.out.println("Effet : ");
	    System.out.println(description + ".");
	}

	@Override
	public void afficherCarteAttaque(String nomDeLaCarte, String description, int degats) {
	    afficherCarte(nomDeLaCarte, description);
	    System.out.println("Cette carte inflige " + degats + " points de dégâts a l'adversaire.");
	    System.out.println("=========================");
	    System.out.println("");
	}
	
	@Override
	public void afficherCartePopularite(String nomDeLaCarte, String description, int pointsPopularite) {
	    afficherCarte(nomDeLaCarte, description); 
	    System.out.println("Cette carte accorde " + pointsPopularite + " points de popularité.");
	    System.out.println("=========================");
	    System.out.println("");
	}
	
	@Override
	public void afficherCarteDiffamation(String nomDeLaCarte, String description, int pointsDiffamation) {
	    afficherCarte(nomDeLaCarte, description); 
	    System.out.println("Cette carte fais perdre " + pointsDiffamation + " points de popularité a l'adversaire.");
	    System.out.println("=========================");
	    System.out.println("");
	}
	
	@Override
	public void afficherCarteSoin(String nomDeLaCarte, String description, int pointsSoin) {
	    afficherCarte(nomDeLaCarte, description); 
	    System.out.println("Cette carte soigne " + pointsSoin + " points de vie.");
	    System.out.println("=========================");
	    System.out.println("");
	}
	
	@Override
	public void afficherEffetCarteDiffamation(String nomJoueurAdverse, int pointsDePopulariteJoueurAdverse, int pointsDiffamation) {
	    System.out.println(nomJoueurAdverse + " perd " + pointsDiffamation + " points de popularité.");
	    System.out.println(nomJoueurAdverse + " a désormais " + pointsDePopulariteJoueurAdverse + " points de popularité.");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("");
	}


	@Override
	public void afficherEffetCarteAttaque(String nomJoueurAdverse, int pointsDeVieJoueurAdverse, int degats) {
	    System.out.println("L'attaque inflige " + degats + " points de dégâts à " + nomJoueurAdverse + ".");
	    System.out.println(nomJoueurAdverse + " a désormais " + pointsDeVieJoueurAdverse + " points de vie.");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("");
	}


	@Override
	public void afficherEffetCartePopularite(String nomJoueur, int pointsDePopularite, int pointsPopulariteGagnes) {
	    System.out.println(nomJoueur + " gagne " + pointsPopulariteGagnes + " points de popularité.");
	    System.out.println(nomJoueur + " a désormais " + pointsDePopularite + " points de popularité.");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("");
	}


	@Override
	public void afficherEffetCarteSoin(String nomJoueur, int pointsDeVieJoueur, int pointsDeSoin) {
	    System.out.println(nomJoueur + " récupère " + pointsDeSoin + " points de vie.");
	    System.out.println(nomJoueur + " a désormais " + pointsDeVieJoueur + " points de vie.");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("");
	}
    
    @Override
    public void afficherCarteJouee(String nomJoueur, String nomCarte, String descriptionCarte) {
        System.out.println(nomJoueur + " joue la carte : " + nomCarte);
        System.out.println("Description de la carte : " + descriptionCarte);
        System.out.println("");
        System.out.println("");
    }
	
    @Override
    public void determineFinPartie(int pointsDeVieJoueurActuel, int pointsDeVieJoueurPres, int populariteJoueurActuel, int populariteJoueurPres, boolean piocheVide) {
        if (pointsDeVieJoueurActuel <= 0 || populariteJoueurPres >= 5) {
        	System.out.println("--- FIN DE LA PARTIE ---");
            System.out.println("Le joueur de " + populariteJoueurPres + " a gagné !");
        } else if (pointsDeVieJoueurPres <= 0 || populariteJoueurActuel >= 5) {
        	System.out.println("--- FIN DE LA PARTIE ---");
            System.out.println("Le joueur de " + populariteJoueurActuel + " a gagné !");
        } else if (piocheVide) {
        	System.out.println("--- FIN DE LA PARTIE ---");
            System.out.println("Fin de partie, il n'y a plus de carte dans la pioche.");
        }
    }
    
    @Override
    public void afficherNomTour(String nom) {
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
	    System.out.println("C'est à " + nom + " de jouer.");
	    System.out.println("");
	    }
    
    @Override
    public int selectionCarte() {
        Scanner scan = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Veuillez sélectionner une carte à jouer (1 à 5) : ");
            choix = Integer.parseInt(scan.next());  
            if (choix < 1 || choix > 5) {
                System.out.println("Choix invalide, veuillez choisir un nombre entre 1 et 5.");
            }
        } while (choix < 1 || choix > 5);
        return (choix-1); 
    }
    
    @Override
    public void affichageScore(String nomJoueur1, int pointsDeVieJoueur1, int populariteJoueur1,String nomJoueur2, int pointsDeVieJoueur2, int populariteJoueur2) {
			System.out.println("Pour rappel, les scores sont les suivant :");
			System.out.println("- "+ nomJoueur1 + " : Points de Vie: " + pointsDeVieJoueur1 + ", Popularité: " + populariteJoueur1);
			System.out.println("- "+ nomJoueur2 + " : Points de Vie: " + pointsDeVieJoueur2 + ", Popularité: " + populariteJoueur2);
			System.out.println("");
	}
   
    @Override
    public void afficherNomPioche(String nom) {
    System.out.println(nom + " a pioché :");}
    
    @Override
    public void afficherCarteEspionnage(String nom, String description, int valeur) {
    	afficherCarte(nom, description);
        System.out.println("Cette carte vole " + valeur + " points de popularité à son adversaire.");
        System.out.println("=========================");
        System.out.println("");
    }

    @Override
    public void afficherEffetCarteEspionnage(String nomJoueurCible, int valeur) {
        System.out.println(nomJoueurCible + " perd " + valeur + " points de popularité au profit de son adversaire.");
        System.out.println("");
	    System.out.println("");
	    System.out.println("");
    }
    
    @Override
    public void afficherCarteFinDuJeu(String nom, String description) {
    	afficherCarte(nom, description);
        System.out.println("=========================");
        System.out.println("");
    }
    
    @Override
    public void afficherFinPartie(String gagnant, int popularite, boolean egalite) {
        System.out.println("\n--- FIN DE LA PARTIE ---");
        if (!egalite) {
            System.out.println("Le joueur " + gagnant + " remporte la partie avec une popularité de " + popularite + " !");
        } else {
            System.out.println("La partie se termine sur une égalité !");
        }
    }
    
    @Override
    public void anoncerNumCarte(int num) {
    	System.out.println("=========================");
        System.out.print("La carte " + (num+1) + " est : ");

    }
    
    @Override
    public int selectionCarteVoler(){
        Scanner scan = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Veuillez sélectionner une carte à voler a votre adversaire (1 à 4) : ");
            choix = Integer.parseInt(scan.next());  
            if (choix < 1 || choix > 4) {
                System.out.println("Choix invalide, veuillez choisir un nombre entre 1 et 4.");
            }
        } while (choix < 1 || choix > 4);
        return (choix-1); 
    }
    
    @Override
    public void afficherCartePrendreCarteChezAdversaire(String nomDeLaCarte, String description) {
	    afficherCarte(nomDeLaCarte, description); 
	    System.out.println("=========================");
	    System.out.println("");
	}
}
