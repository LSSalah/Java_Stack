import java.util.ArrayList;

public abstract class AbstractPokemon  implements PokemonInterface{
	
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p =new Pokemon(name,health,type);
		return p;
	}
	
	@Override
	public String pokemonInfo(Pokemon pokemon) {
		
		return "Pokemon Name :"+pokemon.getName()+":: "+pokemon.getHealth()+":: "+pokemon.getHealth();
	}


}
