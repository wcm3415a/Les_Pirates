package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;
import objets.Equipement;
import personnages.Druide;
import personnages.Grade;
import personnages.Soldat;

public class TestGaulois {
	
	
	public static void main(String[] arg) {
		
		
		Gaulois asterix = new Gaulois("Asterix", 3);
		System.out.println(asterix.getNom());

		Soldat minus = new Soldat(Grade.SOLDAT,"Minus", 6);
		System.out.println(minus.getNom());
		
		Gaulois obelix = new Gaulois("Obelix",9);
		System.out.println(obelix.getNom()); 

		Druide panoramix = new Druide("Panoramix",2);
		Gaulois agecanonix = new Gaulois("Agecanonix ", 1);
		Gaulois assurancetourix = new Gaulois("Assurancetourix ", 2);
		
		panoramix.concocterPotion();
		
		panoramix.doperGaulois(asterix);
		panoramix.doperGaulois(obelix);
		panoramix.doperGaulois(agecanonix);
		panoramix.doperGaulois(assurancetourix);
		
		minus.mettreEquipement(Equipement.BOUCLIER);
		minus.mettreEquipement(Equipement.CASQUE);
		minus.mettreEquipement(Equipement.PLASTRON);
		minus.mettreEquipement(Equipement.BOUCLIER);
		
		asterix.frapper(minus);
		minus.frapper(asterix);
		asterix.frapper(minus);
		minus.frapper(asterix);
		asterix.frapper(minus);
		minus.frapper(asterix);
		asterix.frapper(minus);
		minus.frapper(asterix);
		
		

	}
	
}
