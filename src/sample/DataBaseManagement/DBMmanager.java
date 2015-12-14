package sample.DataBaseManagement;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Moises on 14/12/2015.
 */
public class DBMmanager {

    static public String dbRuta;
    static public Connection conn;

    /**
     * método para crear la base de datos y la tabla de pokemons si ésta no existe.
     * * @param nombre. el nombre que tomara el archivo de la BBDD
     */
    public void createDB(String nombre){
        this.dbRuta = "jdbc:sqlite:"+nombre+".db";

        if (!dbRutaExist(nombre)){
            System.out.println("DataBase no existe");

            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(dbRuta); //CREAMOS LA BBDD
                DBMcreate.createTabla();                    //CREAMOS LA TABLA DE POKEMOS
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else System.out.println("DataBase existe");

    }

    public void insertDB(){

    }

    /**
     * método que comprueba si la BBDD que se va a crear, existe
     * @param nombre archivo que comprobará.
     * @return true si existe, false si no existe
     */
    private boolean dbRutaExist(String nombre) {
        String ruta = "C:\\Users\\Moises\\Desktop\\Git\\M07pokemonDesktop\\"+nombre+".db";
        File fichero = new File (ruta);

        if (fichero.exists()) return true;
        else return false;
    }


}
