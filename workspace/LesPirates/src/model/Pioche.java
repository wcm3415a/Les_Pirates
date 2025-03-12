package model;

import java.security.SecureRandom;

public class Pioche {
    private Carte[] cartes;  
    private int taillePioche = 69; 
    private SecureRandom random; 

    public Pioche() {
        cartes = new Carte[taillePioche]; 

       
        int index = 0;

       
        for (int i = 0; i < 4; i++) {
            cartes[index++] = new CarteAttaque("Attaque Sournoise", "Une attaque nette aux coudes", 1);
            cartes[index++] = new CarteAttaque("Coup de Crochet", "Une attaque puissante", 2);
            cartes[index++] = new CarteAttaque("Coup de Bouteille", "Attaque avec une bouteille", 1);
            cartes[index++] = new CarteAttaque("Lancer de Dague", "Lancer rapide de dague", 1);
        
            cartes[index++] = new CartePopularite("Discours Sincère", "Un discours charmant", 2);
            cartes[index++] = new CartePopularite("Chant de Pirate", "Chant motivant pour les troupes", 2);
            cartes[index++] = new CartePopularite("Discours Brutal", "Discours énergique", 1);
            cartes[index++] = new CartePopularite("Trahison Malicieuse", "Trahison pour augmenter la popularité", 1);
        
            cartes[index++] = new CarteDiffamation("Diffamation Publique", "Une rumeur dévastatrice contre l'adversaire", 2);
            cartes[index++] = new CarteDiffamation("Ragots", "Mensonges sur place publique", 1);
            cartes[index++] = new CarteDiffamation("Manipulation de Presse", "Scandale pour détruire la réputation", 1);
            cartes[index++] = new CarteDiffamation("Calomnie Stratégique", "Accusations infondées pour perdre de la popularité", 1);
       
            cartes[index++] = new CarteSoin("Potion de Vie", "Une potion qui soigne", 1);
            cartes[index++] = new CarteSoin("Bandages", "Panse les petits bobos", 1);
            cartes[index++] = new CarteSoin("Décoction de racines", "Remède revigorant à base de plante", 1);
            cartes[index++] = new CarteSoin("Grog", "Remède revigorant à base de rhum", 2);
            
            cartes[index++] = new CarteSubterfuge("Infiltration Secrète", "Permet d'obtenir des informations sur l'adversaire et lui voler de la popularité.", 1);
        
        }
        cartes[index++] = new CarteFinDuJeu();

        try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            e.printStackTrace();
        }

        melangerPioche();
    }

    
    private void melangerPioche() {
        for (int i = 0; i < cartes.length; i++) {
            int randomIndex = random.nextInt(cartes.length); 
            Carte temp = cartes[i];
            cartes[i] = cartes[randomIndex];
            cartes[randomIndex] = temp;
        }
    }

    public Carte piocherCarte() {
        if (taillePioche > 0) {
            Carte cartePiochee = cartes[taillePioche - 1];
            taillePioche--;
            return cartePiochee;
        } else {
            return null;  
        }
    }
    
    public Boolean piocheVide() {
        if(taillePioche != 0) {
        	return false;
        }
        else {
        	return true;
        }
    }
}
