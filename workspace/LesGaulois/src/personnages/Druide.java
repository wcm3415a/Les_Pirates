package personnages;
import objets.Potion;
import java.util.Random;


public class Druide extends Gaulois{
	Potion potion;
	public Random randomNumbers = new Random();

	public Druide(String nom, int force) {
		super(nom, force);
	}
	
	public void concocterPotion(){
		potion = new Potion(2,4,randomNumbers.nextInt(1,3));
		parler("J'ai concoct� "+ potion.getQuantite()+" doses de potion magique. Elle a une force de "+ potion.getForce());	
	}
	
	public void doperGaulois(Gaulois gauloi){
		if (potion.getQuantite()>0) {
			String nom = "Obelix";
			if (nom.equals(gauloi.getNom())){
				parler("Non, Ob�lix Non !... Et tu le sais tr�s bien !");
			}
			else {
				parler("Tiens "+ gauloi.getNom()+" un peu de potion magique.");
				gauloi.boire(potion.getForce());
				potion.boireUnPetitCoup();
			}}
		else {
			parler("D�sol� "+ gauloi.getNom()+" il n'y a plus une seule goutte de potion.");
		}
	}
}
