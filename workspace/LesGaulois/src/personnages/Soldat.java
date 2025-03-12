package personnages;
import objets.Equipement;

public class Soldat extends Romain{
	private Grade grade;
	private Equipement[] listProtections = new Equipement[3];
	private int numEquipement = 0;
	
	public Soldat(Grade grade, String nom, int force) {
		super(nom, force);
		this.grade = grade;
	}
	
	public Grade getGrade(){
		return grade;
	}
	
	public boolean mettreEquipement(Equipement equipement) {
		boolean bsimi = false;
		for(int i=0; i<numEquipement; i++){
			if (listProtections[i].equals(equipement)) {
				bsimi = true;
			}
				
		}
		if (!bsimi) {
			listProtections[numEquipement] = equipement;
			System.out.println(donnerAuteur() + getNom() + " s'équipe avec un " + equipement.toString());
			numEquipement++;
		}
		
		return bsimi;
	}
	
	@Override
	public void recevoirCoup(int coup) {
		int i = 0;
		int coupPres;
		do {
			coupPres = coup;
			coup -= listProtections[i].toInt();
			System.out.println("Le " + listProtections[i].toString() + " absorbe " + (coupPres-coup) +" du coup");
			i++;
		}while(coup<=0 || i==3);
		
		int force = getForce() - coup;
		if (force > 0) {
			System.out.println(donnerAuteur() + getNom() + ": Aie ! ");
		} else {
			System.out.println(donnerAuteur() + getNom() + ": J'abandonne... ");
			force = 0;
		}
	}
	
}
