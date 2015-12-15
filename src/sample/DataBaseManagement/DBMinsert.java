package sample.DataBaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBMinsert {

    static String dbFichero = DBMmanager.dbRuta;
    static Connection connection = DBMmanager.conn;
    static Statement stmt = null;

    public static void insertPokemons(int id, String name, String lp, String resURI, String img) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbFichero);
            connection.setAutoCommit(false);

            stmt = connection.createStatement();

            //Formar el estamento para insertar en las tablas por cada pokemon
            String sql = "INSERT INTO POKEMON "
                            +"(ID,NAME,LIFEPOINTS,RESOURCE_URI,IMAGE) "
                        +"VALUES "
                            +"("+id+",'"+name+"','"+lp+"','"+resURI+"','"+img+"');";

            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insertado ("+id+")"+name+"");
    }
}
