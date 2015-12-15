package sample.APIcontent;


import java.util.List;

/**
 * Created by Moises on 11/12/2015.
 */
public class Pokedex{


    private String created;
    private String modified;
    private String name;
    private List<Pokemon> pokemons;


    //CONSTRUCTORS

    public Pokedex(){}

    public Pokedex(String created, String modified, String name, List<Pokemon> pokemons) {
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.pokemons = pokemons;
    }


    //GETTERS y SETTERS
    public String getCreated() {return created;}
    public void setCreated(String created) {this.created = created;}

    public String getModified() {return modified;}
    public void setModified(String modified) {this.modified = modified;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Pokemon> getPokemon() {return pokemons;}
    public void setPokemon(List<Pokemon> pokemons) {this.pokemons = pokemons;}
}

