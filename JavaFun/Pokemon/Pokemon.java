public class Pokemon {
	private String name = "";
	
	private int  health = 0;
	
	private String type = "";	
	
	private int count = 0 ;
	
	
	public Pokemon () {
		setCount(++count);
		
		}	
	public Pokemon(String name ,int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void attackPokemon(Pokemon pokemon) {
		pokemon.health = pokemon.health -10;
	}
	
}
