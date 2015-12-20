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
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLifepoints() {return lifepoints;}
    public void setLifepoints(String lifepoints) {this.lifepoints = lifepoints;}

    public String getResourceUri() {return resourceUri;}
    public void setResourceUri(String resourceUri) {this.resourceUri = resourceUri;}

    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
}
