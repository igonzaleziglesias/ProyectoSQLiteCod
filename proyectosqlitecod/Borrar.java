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
     * @param nombreTabla nombre de la tabla 1 
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo
     * el borrado o no existe esa busqueda devuelve 0
     */
    public int delete(int id, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        String sql = "DELETE FROM " + nombreTabla + " WHERE id = ?";//orden de borrado
        String sql2 = "DELETE FROM " + nombreTabla2 + " WHERE id = ?";//orden de borrado

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setInt(1, id);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {//realiza conexion
            pstmt.setInt(1, id);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        return devol;

    }

/**
     * Metodo para borrar datos en la tabla por clave primaria, que se
     * corresponden a los alumnos de la clase.
     *
     * @param name nombre de la persona
     * @param nombreTabla nombre de la tabla 1 
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo
     * el borrado o no existe esa busqueda devuelve 0
     */
    public int deleteNombre(String name, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        String sql = "DELETE FROM " + nombreTabla + " WHERE name = ?";//orden de borrado
        String sql2 = "DELETE FROM " + nombreTabla2 + " WHERE name = ?";//orden de borrado

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setString(1, name);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {//realiza conexion
            pstmt.setString(1, name);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        return devol;

    }

/**
     * Metodo para borrar datos en la tabla por clave primaria, que se
     * corresponden a los alumnos de la clase.
     *
     * @param secondName apellido de la apersona
     * @param nombreTabla nombre de la tabla 1 
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo
     * el borrado o no existe esa busqueda devuelve 0
     */
    public int deleteApellido(String secondName, String nombreTabla,String nombreTabla2) {
     int devol = 0;
        String sql = "DELETE FROM " + nombreTabla + " WHERE secondname = ?";//orden de borrado
        String sql2 = "DELETE FROM " + nombreTabla2 + " WHERE secondname = ?";//orden de borrado

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setString(1, secondName);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {//realiza conexion
            pstmt.setString(1, secondName);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        return devol;
    }
    /**
     * Metodo para borrar datos en la tabla por clave primaria, que se
     * corresponden a los alumnos de la clase.
     *
     * @param secondName apellido de la apersona
     * @param nombreTabla nombre de la tabla 1 
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo
     * el borrado o no existe esa busqueda devuelve 0
     */
    public int deletePais(String pais, String nombreTabla,String nombreTabla2) {
     int devol = 0;
        String sql = "DELETE FROM " + nombreTabla + " WHERE pais = ?";//orden de borrado
        String sql2 = "DELETE FROM " + nombreTabla2 + " WHERE pais = ?";//orden de borrado

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
            pstmt.setString(1, pais);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {//realiza conexion
            pstmt.setString(1, pais);
            devol = devol + pstmt.executeUpdate();//ejecuccion

        } catch (SQLException e) {
//            System.out.println(e.getMessage());

            try {
                this.connect().close();
            } catch (SQLException ex) {
            }

            devol = devol + 0;
        }

        return devol;
    }

}
