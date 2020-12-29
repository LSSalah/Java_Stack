
public class Gorilla extends Mammal {
	public void throwSomething() {
		energyLevel -= 5;
		System.out.println("The gorilla has thrown something at you!");
		displayEnergy();
	}
	public void eatBananas() {
		energyLevel += 10;
		System.out.println("The gorilla ate some bananas and happy now.");
		displayEnergy();
	}
	public void climb() {
		energyLevel -= 10;
		System.out.println("The gorilla climbs a nearby tree and lost some energy.");
		displayEnergy();
	}
}
