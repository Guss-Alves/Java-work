package zoo_keeper;

public class Mammal {
	//here is the member variables or attributes
	public int energyLevel;
	
	//here is the constructor
	public Mammal() {
		this.energyLevel = 100;
	}
	
	//Methods are here
	public void displayEnergy() {
		System.out.println("Animal energy level:" + this.energyLevel);
	}
	
	
}
