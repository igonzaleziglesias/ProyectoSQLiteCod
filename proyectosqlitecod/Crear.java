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
     * constructor para crear una tablar por defecto.
     */
    public Crear() {

        String url = "jdbc:sqlite:tests.db";

        String sql = "CREATE TABLE IF NOT EXISTS tabladefecto ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	secondname text  NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Constructor para crear una tabla especificando el nombre de la tabla
     *
     * @param nombreTabla nombre de la tabla a crear.
     */
    public Crear(String nombreTabla) {

        String url = "jdbc:sqlite:tests.db";

        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "	id integer PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	secondname text  NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
