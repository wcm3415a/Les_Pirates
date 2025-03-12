package personnages;
import objets.Potion;

public class Gaulois extends Personnage {
	public float effetPotion = 1;
	
	public Gaulois(String nom, int force){
		super(nom, force);
	}
	
	
	@Override
	protected String donnerAuteur() {
		return "le gaulois ";
	}
	
	protected void boire(int effet) {
		effetPotion = effet;
	}
	
	@Override
	public void frapper(Personnage adversaire) {
		if (getForce()>0) {
		if (adversaire.getForce() - getForce()/3 > 0) {
		System.out.println(donnerAuteur() + getNom() + " envoie un grand coup de force " +getForce()+" dans la mâchoire de "+ adversaire.donnerAuteur() + adversaire.getNom());
		adversaire.recevoirCoup(Math.round(getForce()*effetPotion/3));
		effetPotion-=0.5;
		if(effetPotion<1) {
			effetPotion = 1;
		}
		}
		else {
			parler("Je ne frape les hommes a terre !!");
		}}
	}
}
