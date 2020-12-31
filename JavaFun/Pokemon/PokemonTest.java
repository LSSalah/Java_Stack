import java.util.ArrayList;

public class PokemonTest {

	public static void main(String[] args) {
		Pokedex p= new Pokedex();
		
		ArrayList<Pokemon> pokemonList =new ArrayList<Pokemon>();
		Pokemon  pokemon = new Pokemon("Salah",10,"java");
		Pokemon  pokemonA = new Pokemon("Ahmad",10,"Spring");
		pokemonList.add(pokemon);
		pokemonList.add(pokemonA);
	    p.setPokemon(pokemonList);
	    p.listPokemon();
		
		

	}

}
