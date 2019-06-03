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
     * hizo la insercion(Ej: clave primaria esta repetida)
     */
    public int insert(int id, String name, String secondname, String pais, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        String sql = "INSERT INTO " + nombreTabla + " (id,name,secondname) VALUES(?,?,?)";//sentencia para insertar en la tabla 1
        String sql2 = "INSERT INTO " + nombreTabla2 + " (id,pais) VALUES(?,?)";//sentencia para insertar en la tabla 2

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, secondname);
            devol = devol + pstmt.executeUpdate();//hacer insercion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            devol = devol+0;
        } finally {

            try {
                this.connect().close();
            } catch (SQLException ex) {

            }
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, pais);
            devol = devol + pstmt.executeUpdate();//hacer insercion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            devol = devol+ 0;
        } finally {

            try {
                this.connect().close();
            } catch (SQLException ex) {

            }
        }
        return devol;
    }

}
