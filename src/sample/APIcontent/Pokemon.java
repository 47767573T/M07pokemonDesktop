package sample.APIcontent;


/**
 * Created by Moises on 14/12/2015.
 */

public class Pokemon {

    private int id;
    private String name;
    private String lifepoints;
    private String resourceUri;
    private String image;


    //CONSTRUCTORES
    public Pokemon(int id, String name, String lifepoints, String resourceUri, String image) {
        this.id = id;
        this.name = name;
        this.lifepoints = lifepoints;
        this.resourceUri = resourceUri;
        this.image = image;
    }

    public Pokemon() {}


    //SETTERS y GETTERS
    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setLifepoints(String lifepoints) {this.lifepoints = lifepoints;}

    public void setResourceUri(String resourceUri) {this.resourceUri = resourceUri;}

    public void setImage(String image) {this.image = image;}
}
