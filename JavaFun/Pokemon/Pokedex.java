import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	private ArrayList<Pokemon> pokemon =null;
	
	public Pokedex() {
		ArrayList<Pokemon> pokemon=new ArrayList<Pokemon>();
		
		
	}
	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}
	
	public void setPokemon(ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	@Override
	public void listPokemon() {
		for (Pokemon i : pokemon) {
			System.out.println(i.getName());
		}
		
		
	}

}
