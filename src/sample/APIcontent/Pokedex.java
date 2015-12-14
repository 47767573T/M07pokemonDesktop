package sample.APIcontent;


import java.util.List;

/**
 * Created by Moises on 11/12/2015.
 */
public class Pokedex{


    private String created;
    private String modified;
    private String name;
    private List<Pokemon> pokemon;

    public Pokedex(String created, String modified, String name, List<Pokemon> pokemon) {
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.pokemon = pokemon;
    }

    public String getCreated() {return created;}
    public void setCreated(String created) {this.created = created;}
    public String getModified() {return modified;}
    public void setModified(String modified) {this.modified = modified;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Pokemon> getPokemon() {return pokemon;}
    public void setPokemon(List<Pokemon> pokemon) {this.pokemon = pokemon;}
}

