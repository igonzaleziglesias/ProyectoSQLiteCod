package proyectosqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Iago
 */
public class Insertar {

    /**
     * Metodo para conectarse a la base de datos
     *
     * @return Un objeto Connection.
     */
    private static Connection connect() {
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
     * Metodo para insertar datos en la tabla que se corresponden a los alumnos
     * de la clase.
     *
     * @param id clave primaria
     * @param name nombre del alumno
     * @param secondname apellido del alumno
     * @return el numero de filas que inserto y un -1 si hay algun error y no
     * hizo la insercion, si devuelve 0 es que la clave primaria esta repetida
     */
    public int insert(int id, String name, String secondname, String nombreTabla) {
        String sql = "INSERT INTO " + nombreTabla + " (id,name,secondname) VALUES(?,?,?)";//sentencia para insertar en la tabla

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, secondname);
            return pstmt.executeUpdate();//hacer insercion

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        } finally {

            try {
                this.connect().close();
            } catch (SQLException ex) {

            }
        }
    }

}
