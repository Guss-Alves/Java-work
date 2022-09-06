package zoo_keeper;

public class MammalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gorilla g1 = new Gorilla();
		g1.throwSomething();
		g1.throwSomething();
		g1.throwSomething();
		
		g1.eatBananas();
		g1.eatBananas();
		g1.climb();
		g1.displayEnergy();
		
		System.out.println("******separate*******");
		Bat b1 = new Bat();
		b1.attackTown();
		b1.attackTown();
		b1.attackTown();
		b1.eatHumans();
		b1.eatHumans();
		b1.eatHumans();
		b1.fly();
		b1.fly();
		
		b1.displayEnergy();
		
	}

}
