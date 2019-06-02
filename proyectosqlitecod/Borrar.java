package proyectosqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author igonzaleziglesias
 */
public class Borrar {

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
     * Metodo para borrar datos en la tabla por clave primaria, que se
     * corresponden a los alumnos de la clase.
     *
     * @param id clave primaria
     * @param nombreTabla nombre de la tabla donde quiere borrar
     * @return el numero de filas que borro y un -1 si hay algun error y no hizo
     * el borrado, si devuelve 0 es que no existia esa busqueda
     */
    public int delete(int id, String nombreTabla) {
        String sql = "DELETE FROM " + nombreTabla + " WHERE id = ?";//orden de borrado

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            return -1;
        }
    }

    /**
     * Metodo para borrar datos en la tabla por nombre, que se corresponden a
     * los alumnos de la clase.
     *
     * @param name nombre del alumno
     * @param nombreTabla nombre de la tabla donde quiere borrar
     * @return el numero de filas que borro y un -1 si hay algun error y no hizo
     * el borrado, si devuelve 0 es que no existia esa busqueda
     */
    public int deleteNombre(String name, String nombreTabla) {
        String sql = "DELETE FROM " + nombreTabla + " WHERE name = ?";//orden de b

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setString(2, name);
            return pstmt.executeUpdate();//ejecucion

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            return -1;
        }
    }

    /**
     * Metodo para borrar datos en la tabla por apellido que se corresponden a
     * los alumnos de la clase.
     *
     * @param secondName apellido del alumno
     * @param nombreTabla nombre de la tabla donde quiere borrar
     * @return el numero de filas que borro y un -1 si hay algun error y no hizo
     * el borrado, si devuelve 0 es que no existia esa busqueda
     */
    public int deleteApellido(String secondName, String nombreTabla) {
        String sql = "DELETE FROM " + nombreTabla + " WHERE secondname = ?";//orden de b

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setString(3, secondName);
            return pstmt.executeUpdate();//ejecucion

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            return -1;
        }
    }

}
