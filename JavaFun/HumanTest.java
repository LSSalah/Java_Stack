public class HumanTest {

	public static void main(String[] args) {
			Human ninja = new Human("Salah");
			Human samurai = new Human("Manar");
			Human wizard = new Human("Mohammad");
			
			wizard.attack(ninja);
			samurai.attack(ninja);
			ninja.attack(samurai);
	}
}