package sample.APIcontent;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Moises on 14/12/2015.
 */
public class APImanager {

    private static String baseURL = "http://pokeapi.co/";
    private static String pokedexURL = baseURL + "api/v1/pokedex/1/";
    private static String resource_URI = "";
    private static Pokedex pokedex;
    private static ArrayList<Pokemon> pokemons;



    public static void jsonToPokedex() throws IOException {

        pokedex = new Pokedex();
        JSONObject jo = (JSONObject) JSONValue.parse(getJSON(pokedexURL));

        pokedex.setName(jo.get("name").toString());
        pokedex.setCreated(jo.get("created").toString());
        pokedex.setModified(jo.get("modified").toString());

        jsonToPokemon(jo);
    }

    public static void jsonToPokemon(JSONObject jObj) throws IOException {

        pokemons = new ArrayList<>();
        JSONArray ja = (JSONArray) JSONValue.parse(jObj.get("pokemon").toString());

        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = new Pokemon();
            JSONObject jo = (JSONObject) JSONValue.parse(getJSON(ja.get(i).toString()));



            pokemon.setId(i);
            pokemon.setName(jo.get("name").toString());
            //pokemon.setLifepoints(jo.get(""));
        }

    }


    public static String getJSON (String jsonURL) throws IOException {
        URL url = new URL(jsonURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        StringBuilder result = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        return result.toString();
    }
}
