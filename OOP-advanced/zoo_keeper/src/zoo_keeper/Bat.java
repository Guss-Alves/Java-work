package zoo_keeper;

public class Bat extends Mammal {

	public int energyLevel = 300;
	
	//methods go here
	
	@Override
	public void displayEnergy() {
		System.out.println("Bat energy level:" + this.energyLevel);
	}
	
	public void fly() {
		System.out.println("fuuuuuuu");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Well, never mind");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("FIRE SOUND");
		this.energyLevel -= 100;
	}
}
