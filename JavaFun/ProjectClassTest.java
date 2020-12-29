
public class ProjectClassTest {

	public static void main(String[] args) {
		ProjectClass testProject = new ProjectClass("Add Helipad", "Al Irsal", 60000.99);
        testProject.setName("Ramallah HQ");
        testProject.setDescription("Located in Ramallah.");
        testProject.setCost(5000.99);
        System.out.println(testProject.elevatorPitch());
    
	}

}
