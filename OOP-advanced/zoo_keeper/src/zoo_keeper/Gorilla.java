package zoo_keeper;

public class Gorilla extends Mammal {

	//methods go here
	public void throwSomething() {
		System.out.println("ooh no the Gorilla threw something");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("hmmm, now Gorilla is full");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla will climb the tree because needs exercise");
		this.energyLevel -= 10;
	}
}
