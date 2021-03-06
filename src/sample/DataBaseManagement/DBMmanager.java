package sample.DataBaseManagement;

import sample.APIcontent.APImanager;
import sample.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Moises on 14/12/2015.
 */
public class DBMmanager {

    static public int idReciente = 1;
    static public String dbRuta;
    static public Connection conn;
    static public String[] pokemonReciente = new String[4];

    /**
     * m�todo para crear la base de datos y la tabla de pokemons si �sta no existe.
     * * @param nombre del archivo de la BBDD
     */
    public static void createDB(){
        dbRuta = "jdbc:sqlite:pokedex.db";

        if (dbRutaExist("pokedex")) {
            System.out.println("DataBase ya existe");
            deleteDB();
        }
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(dbRuta);
            DBMcreate.createTabla();                    //CREAMOS LA TABLA DE POKEMONS
            APImanager.jsonToPokedex();                 //Realizamos la llamada para guardar pokemons en BD

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * m�todo de control de insercion de pokemons en la base de datos y el listado del programa
     * @param id identificador del pokemon
     * @param name nombre del pokemon
     * @param lifePoint puntos de vida del pokemon
     * @param resURI url de la fuente del pokemon
     * @param img url de la imagen del pokemon
     */
    public static void insertDB(int id, String name, String lifePoint, String resURI, String img) {
        DBMinsert.insertPokemons(id, name, lifePoint, resURI, img);
        Controller.items.add(id+" - "+name);
    }

    /**
     * Metodo que busca el pokemon segun ID en BBDD
     * @param id identificador para buscar pokemon en BBDD
     * @return Array conn informacion necesaria del pokemon
     */
    public static String[] getPokemon (int id){
        if (id == idReciente) return pokemonReciente;
        else{
            idReciente = id;
            pokemonReciente = DBMselect.getPokemon(id);
            return pokemonReciente;
        }
    }

    /**
     * funcion para borrar la tabla de pokemon en la BBDD
     */
    public static void deleteDB(){ DBMcreate.deleteTabla(); }

    /**
     * m�todo que comprueba si la BBDD que se va a crear, existe
     * @param nombre archivo que comprobar�.
     * @return true si existe, false si no existe
     */
    private static boolean dbRutaExist(String nombre) {
        String ruta = "C:\\Users\\Moises\\Desktop\\Git\\M07pokemonDesktop\\"+nombre+".db";
        File fichero = new File (ruta);

        if (fichero.exists()) return true;
        else return false;
    }
}
