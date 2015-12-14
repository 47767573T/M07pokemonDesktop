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


    public void createDB(String nombre){
        this.dbRuta = "jdbc:sqlite:"+nombre+".db";

        if (!dbRutaExist(nombre)){
            System.out.println("DataBase no existe");

            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(dbRuta);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else System.out.println("DataBase ya existe");

        DBMcreate.createTabla();
    }

    private boolean dbRutaExist(String nombre) {
        String ruta = "C:\\Users\\Moises\\Desktop\\Git\\M07pokemonDesktop\\"+nombre+".db";
        File fichero = new File (ruta);

        if (fichero.exists()) return true;
        else return false;
    }


}
