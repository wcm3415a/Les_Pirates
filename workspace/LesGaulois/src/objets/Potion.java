package objets;
import java.util.Random;

public class Potion {
	public int quantite;
	public int force;
	
	public Random randomNumbers = new Random();
	
	public Potion(int min, int max, int quantite) {
		this.quantite = quantite;
		force = randomNumbers.nextInt(min,max);
	}

	public int getQuantite() {
		return quantite;
	}
	
	public int getForce() {
		return force;
	}
	
	public void boireUnPetitCoup(){
		if(quantite!=0){
			quantite-=1;
			}
		}
	}
	
	

