package personnages;

public abstract class Personnage {
	
	private String nom;
	private int force;
	
	protected Personnage(String nom, int force){
		this.nom  = nom;
		this.force = force;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(donnerAuteur() + nom + " : " + texte );
	}
	
	protected abstract String donnerAuteur();
	
	
	public void frapper(Personnage adversaire) {
		if (getForce()>0) {
		if (adversaire.getForce() - force/3 > 0) {
			System.out.println(donnerAuteur() + nom + " envoie un grand coup de force " +getForce()+" dans la mâchoire de "+ adversaire.donnerAuteur() + adversaire.getNom());
			adversaire.recevoirCoup(force/3);
		}
		else {
			parler("Je ne frape les hommes a terre !!");
		}
		}
	}

	public void recevoirCoup(int coup) {
		force = force - coup;
		if (force > 0) {
			System.out.println(donnerAuteur() + nom + ": Aie ! ");
		} else {
			System.out.println(donnerAuteur() + nom + ": J'abandonne... ");
			force = 0;
		}
	}
	
	
	public int getForce() {
		return force;
	}
}
