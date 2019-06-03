package proyectosqlitecod;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Iago
 */
public class Consultar {

    /**
     * Metodo para conectarse a la base de datos
     *
     * @return Un objeto Connection.
     */
    private Connection connect() {
        String url = "jdbc:sqlite:tests.db";//conectar a la base de datos
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Metodo para consultar datos en la tabla que se corresponden a los alumnos
     * de la clase.
     *
     * @param datosSeparadosComas datos a consutlar en la primera tabla
     * @param datosSeparadosComas2 datos a consultar en la segunda tabla
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de filas que consulto y un 0 si hay algun error o no
     * hizo la consulta
     */
    public int select(String datosSeparadosComas, String datosSeparadosComas2, String nombreTabla, String nombreTabla2) {
        int devolver = 0;
        int resultado = 0;
        String sql = "SELECT " + datosSeparadosComas + " FROM " + nombreTabla;
        String sql2 = "SELECT " + datosSeparadosComas2 + " FROM " + nombreTabla2;
        System.out.println(nombreTabla);
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    System.out.print(rs.getInt("id") + " ");
                    devolver++;
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("name") + " ");
                    devolver++;
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("secondname"));
                    devolver++;
                } catch (Exception e) {

                }
                System.out.println("");System.out.println("");
            }
            if (devolver != 0) {
                resultado++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            devolver = 0;
        }
        System.out.println(nombreTabla2);
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql2)) {
            while (rs.next()) {
                try {
                    System.out.print(rs.getInt("id") + " ");
                    devolver++;
                } catch (Exception e) {

                }
                try {
                    System.out.print(rs.getString("pais"));
                    devolver++;
                } catch (Exception e) {

                }

                System.out.println("");
                System.out.println("");
            }
            if (devolver != 0) {
                resultado++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            devolver = 0;
        }
        try {
            this.connect().close();
        } catch (SQLException ex) {
        }
        return resultado;
    }
}
