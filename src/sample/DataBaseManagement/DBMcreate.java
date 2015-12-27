package sample.DataBaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBMcreate {

    static String dbFichero = DBMmanager.dbRuta;
    static Connection connection = DBMmanager.conn;
    static Statement stmt = null;

    /**
     * Funcion que crea y lanza la query para crear la tabla que albergara informacion de los pokemons
     */
    public static void createTabla() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbFichero);
            System.out.println("Acceso correcto a BBDD");
            stmt = connection.createStatement();

            //Definimos la estructura de las tablas para pokemons
            String sql = "CREATE TABLE POKEMON"
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME                CHAR(100),"
                    + " LIFEPOINTS          CHAR(50),"
                    + " RESOURCE_URI        CHAR(250),"
                    + " IMAGE               CHAR(250))";

            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * funcion que borra la tabla de pokemons de la BBDD
     */
    public static void deleteTabla() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbFichero);
            stmt = connection.createStatement();

            String sql = "DROP TABLE POKEMON";

            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}