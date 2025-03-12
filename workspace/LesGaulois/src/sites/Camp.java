package sites;

import personnages.Grade;
import personnages.Gaulois;
import personnages.Soldat;

public class Camp {
	private Soldat commandant;
	private Soldat[] listSoldat = new Soldat[4];
	private int nbSoldat = 0;
	
	public Camp(Soldat commandant) {
		this.commandant = commandant;
		ajouterSoldat(commandant);
	}
	
	public Soldat getCommandant() {
		return commandant;
	}
	
	public void ajouterSoldat(Soldat soldat) {
		if (nbSoldat < listSoldat.length) {
			listSoldat[nbSoldat] = soldat;
			nbSoldat++;
			if (nbSoldat != 1) {
			commandant.parler("Bienvenue " + soldat.getNom());}
			else {
				commandant.parler(" Je suis en charge de créer un nouveau camp romain ");
			}
		}
		else {
			commandant.parler(" Désolé mon village est déjà bien rempli, " + soldat.getNom());
		}
	}
	
	
	public void  afficherCamp() {
		System.out.println("Le camp dirigé par "+commandant.getNom()+" contient les soldats :");
		for(int i = 1; nbSoldat>i; i++ ) {
			System.out.println(" - " + listSoldat[i].getNom());
		}
	}
	
	public boolean changerCommandant(Soldat newCommandant) {
		boolean commandantChange = newCommandant.getGrade() == Grade.CENTURION;
		if (commandantChange){
			commandant.parler(" Je ne suis pas suffisamment gradé pour prendre la direction du camp romain.");
			commandant = newCommandant;
			commandant.parler(" Je prends la direction du camp romain ");
			listSoldat[0] = newCommandant;
		}
		return commandantChange;
	}

}
