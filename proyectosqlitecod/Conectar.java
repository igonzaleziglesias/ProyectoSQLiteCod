package proyectosqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Iago
 */
public class Conectar {

    private static Connection conn = null;
    /**
     * Metodo para conectarse a la base de datos
     *
     * @return Un boolean que espifica si realizo la conexion o no.
     */
    public static boolean connect() {

        try {
            String url = "jdbc:sqlite:tests.db";//nombre de la base de datos
            conn = DriverManager.getConnection(url);//realiza la conexion
            System.out.println("Connection to SQLite has been established.");///Conexion establecida
            return true;//devuelve true si realizo la conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());//mensaje de error al hacer la conexion
            return false;//debuelve false si no realizo la conexion
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Metodo para desconectarse a la base de datos
     *
     * @return Un boolean que espifica si realizo la desconexion o no.
     */
    public static boolean disconnect() {
        try {
            conn.close();//cierra la conexion a la base de datos
            return true;//devuelve true si realizo la desconexion
        } catch (SQLException ex) {
            return false;//devuelve false si no realizo la desconexion
        }
    }
}
