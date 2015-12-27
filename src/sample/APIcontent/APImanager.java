package sample.APIcontent;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import sample.DataBaseManagement.DBMmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moises on 14/12/2015.
 */
public class APImanager {

    public static String baseURL = "http://pokeapi.co/";
    private static String pokedexURL = baseURL + "api/v1/pokedex/1";
    private static Pokedex pokedex;
    private static List<Pokemon> pokemons;


    /**
     * Extraer la informacion del JSON de pokedex a informacion para crear los objetos pokedex
     * @throws IOException
     */
    public static void jsonToPokedex() throws IOException {

        pokedex = new Pokedex();

        //Creamos objeto json para extraer informacion del json
        JSONObject jo = (JSONObject) JSONValue.parse(getJSON(pokedexURL));

        pokedex.setName(jo.get("name").toString());
        pokedex.setCreated(jo.get("created").toString());
        pokedex.setModified(jo.get("modified").toString());

        //Llamamos al metodo para crear los objetos pokemons de la pokedex
        jsonToPokemon(jo);

        System.out.println("2");
        pokedex.setPokemon(pokemons);
    }

    /**
     * Extraer la informacion del JSON de pokemon a informacion para crear los objetos pokemon
     * y, por ultimo, lo guarda en la tabla
     * @param jObj objeto json para extraer informacion para crear objetos pokemon
     * @throws IOException
     */
    public static void jsonToPokemon(JSONObject jObj) throws IOException {

        String prueba = fixUrl(jObj.get("pokemon").toString());
        System.out.println(prueba);

        pokemons = new ArrayList<>();
        //Creamos array de objetos Json
        JSONArray ja = (JSONArray) JSONValue.parse(prueba);

        //Recorremos el array creado para extraer informacion del json
        for (int i = 0; i < 25; i++) {
            //Creamos objeto json padre para extraer nombre

            String preJson = getJSON("http://pokeapi.co/api/v1/pokemon/" + (i+1));

            JSONObject padreJO = (JSONObject) JSONValue.parse(preJson);

            String name = padreJO.get("name").toString();
            System.out.println(name);

            String pokemonURL = baseURL + padreJO.get("resource_uri").toString();

            //Creamos objeto json hijo para extraer informacion
            JSONObject hijoJO = (JSONObject) JSONValue.parse(getJSON(pokemonURL));
            int id = Integer.parseInt(hijoJO.get("pkdx_id").toString());
            String lifePoints = hijoJO.get("hp").toString();
            String imageURL = baseURL+"media/img/"+id+".png";

            //Tras extraer informacion necesaria rellenamos el objeto pokemon y lo añadimo al array de pokemons
            Pokemon pokemon = new Pokemon();
            pokemon.setId(id);
            pokemon.setName(name);
            pokemon.setLifepoints(lifePoints);
            pokemon.setResourceUri(pokemonURL);
            pokemon.setImage(imageURL);

            pokemons.add(pokemon);

            //Lo insertamos en la BD directamente
            DBMmanager.insertDB(id, name, lifePoints, pokemonURL, imageURL);
        }
    }

    /**
     * método para conseguir el json de una Url que introduciremos como jsonURL
     * @param jsonURL url de la que extraeremos el string json
     * @return el string json extraido de la url
     * @throws IOException
     */
    public static String getJSON (String jsonURL) throws IOException {
        URL url = new URL(jsonURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        StringBuilder result = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            result.append(line);
        }

        System.out.println(line);
        reader.close();
        return result.toString();
    }

    public static String fixUrl (String urlToFix){
        String fixed = urlToFix.replace("\\","");


        return fixed;
    }
}
