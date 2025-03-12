package sites;

import personnages.Gaulois;

public class Village {
	private Gaulois chef;
	private Gaulois[] listGaulois = new Gaulois[5];
	private int nbGaulois = 0;

	public Village(Gaulois chef) {
		this.chef = chef;
		ajouterGaulois(chef);
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterGaulois(Gaulois gaulois) {
		if (nbGaulois < listGaulois.length) {
			listGaulois[nbGaulois] = gaulois;
			nbGaulois++;
			if (nbGaulois != 1) {
				chef.parler("Bienvenue " + gaulois.getNom());
			} else {
				chef.parler(" Je suis un grand guerrier et je vais créer mon village ");
			}
		} else {
			chef.parler(" Désolé mon village est déjà bien rempli, " + gaulois.getNom());
		}
	}

	public void afficherVillageois() {
		System.out.println("Le village de " + chef.getNom() + " est habité par :");
		for (int i = 1; nbGaulois > i; i++) {
			System.out.println(" - " + listGaulois[i].getNom());
		}

	}

	public void changerChef(Gaulois newChef) {
		chef.parler(" Je laisse mon grand bouclier au grand " + newChef.getNom());
		chef = newChef;
		chef.parler(" Merci !");
		listGaulois[0] = newChef;
	}

}
