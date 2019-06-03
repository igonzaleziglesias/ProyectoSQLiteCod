package proyectosqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Iago
 */
public class Crear {

    /**
     * constructor para crear tablas de la base de datos por defecto.
     */
    public Crear() {

        String url = "jdbc:sqlite:tests.db";//nombre de la base de datos

        String sql = "CREATE TABLE IF NOT EXISTS tabladefecto ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	secondname text  NOT NULL"
                + ");";//setencia sql para crear la tabla

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {//conectar

            stmt.execute(sql);//ejecutar sentencia
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql2 = "CREATE TABLE IF NOT EXISTS tabladefecto2 ("
                + "	id integer PRIMARY KEY,"
                + "	pais text  NOT NULL"
                + ");";//setencia sql para crear la tabla

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {//conectar

            stmt.execute(sql2);//ejecutar sentencia
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Constructor para crear tablas de la base de datos especificando el nombre
     *
     * @param nombreTabla nombre de una tabla a crear.
     * @param nombreTabla2 nombre de otra tabla a crear
     */
    public Crear(String nombreTabla, String nombreTabla2) {

        String url = "jdbc:sqlite:tests.db";//nombre de la base de datos

        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	secondname text  NOT NULL"
                + ");";//setencia sql para crear la tabla

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {//conectar

            stmt.execute(sql);//ejecutar sentencia
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql2 = "CREATE TABLE IF NOT EXISTS " + nombreTabla2 + " ("
                + "	id integer PRIMARY KEY,"
                + "	pais text  NOT NULL"
                + ");";//setencia sql para crear la tabla

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {//conectar

            stmt.execute(sql2);//ejecutar sentencia
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
