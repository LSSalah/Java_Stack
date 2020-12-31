import java.util.ArrayList;

public class PokemonTest {

	public static void main(String[] args) {
		Pokedex p= new Pokedex();
		
		ArrayList<Pokemon> pokemonList =new ArrayList<Pokemon>();
		Pokemon  pokemon = new Pokemon("Ahmad",10,"java");
		pokemonList.add(pokemon);
	    p.setPokemon(pokemonList);
	    p.listPokemon();
		
		

	}

}
