/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        // SQLite connection string
        String url = "jdbc:sqlite:tests.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * Metodo para insertar datos en la tabla que se corresponden a los alumnos de la clase.
     * @param id clave primaria
     * @param name nombre del alumno
     * @param secondname apellido del alumno
     * @return un int positivo si hizo la insercion, un 0 si la clave primaria ya existe y no realizo la insercion y un -1 si hay algun error y no hizo la insercion
     */
    public int insert(int id, String name, String secondname, String nombreTabla) {
        String sql = "INSERT INTO " + nombreTabla + " (id,name,secondname) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, secondname);
            pstmt.executeUpdate();
            return 1;
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
