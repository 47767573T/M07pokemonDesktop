package sample.DataBaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBMinsert {

    static String dbFichero = DBMmanager.dbRuta;
    static Connection connection;
    static Statement stmt = null;

    /**
     * metodo que crea la QUERY de insercion a la BBDD e introduce los valores dados
     * @param id identificador del pokemon
     * @param name nombre del pokemon
     * @param lp puntos de vida del pokemon
     * @param resURI url de la fuente del pokemon
     * @param img url de la imagen del pokemon
     */
    public static void insertPokemons(int id, String name, String lp, String resURI, String img) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbFichero);
            connection.setAutoCommit(false);

            stmt = connection.createStatement();

            //Formar la query para insertar en las tablas por cada pokemon
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
