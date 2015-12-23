package sample.DataBaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Moises on 23/12/2015.
 */
public class DBMselect {

    static String dbFichero = DBMmanager.dbRuta;
    static Connection connection;
    static Statement stmt = null;


    public static String[] getPokemon (int id) {
        String[] pokemonInfo = new String[2];
        pokemonInfo[0] = "unknown";
        pokemonInfo[1] = "-1";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbFichero);
            connection.setAutoCommit(false);

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM POKEMON WHERE ID = " + id);


            pokemonInfo[0] = rs.getString("NAME");
            pokemonInfo[1] = rs.getString("LIFEPOINTS");



            rs.close();
            stmt.close();
            connection.close();
            return pokemonInfo;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
