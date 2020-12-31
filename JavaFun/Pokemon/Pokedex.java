import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	
	private ArrayList<Pokemon> pokemon =null;
	
	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}
	public void setPokemon(ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	public Pokedex() {
		ArrayList<Pokemon> pokemon=new ArrayList<Pokemon>();
		
		
	}
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p =new Pokemon(name,health,type);
		pokemon.add(p);
		return p;
	}

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		
		return "Pokemon Name :"+pokemon.getName()+":: "+pokemon.getHealth()+":: "+pokemon.getHealth();
	}

	@Override
	public void listPokemon() {
		for (Pokemon i : pokemon) {
			System.out.println(i.getName());
		}
		
		
	}

}
