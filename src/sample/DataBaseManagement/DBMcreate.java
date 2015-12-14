package sample.DataBaseManagement;

import java.sql.Connection;
import java.sql.Statement;


public class DBMcreate {

    static Connection connection = DBMmanager.conn;
    static Statement stmt = null;


    public static void createTabla() {
        try {

            System.out.println("Acceso correcto a BBDD");
            stmt = connection.createStatement();

            //Definimos la estructura de las tablas para pokemons
            String sqlPoke = "CREATE TABLE POKEMON "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME                CHAR(100),"
                    + "                 CHAR(100),"


                    + " FECHA               CHAR(20))";

            stmt.executeUpdate(sqlPoke);

            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    private String id;
    private String name;
    private String resourceUri;
    private String image;
    private String weight;
    private String lifepoints;

}