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
 * @author Usuario
 */
public class Modificar {

    /**
     * Metodo para conectarse a la base de datos
     *
     * @return Un objeto Connection.
     */
    private Connection connect() {

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
     * Metodo para modificar datos en la tabla que se corresponden a los alumnos
     * de la clase.
     *
     * @param id clave primaria
     * @param name nombre del alumno
     * @param secondname apellido del alumno
     * @param pais pais de procedencia
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de filas que inserto y un -1 si hay algun error y no
     * hizo la insercion(Ej: clave primaria esta repetida)
     */
    public int update(int id, String name, String secondname, String pais, String nombreTabla, String nombreTabla2) {
        int contador = 0;
        String sql = "UPDATE " + nombreTabla + " SET name = ? , "
                + "secondname = ? "
                + "WHERE id = ?";

        String sql2 = "UPDATE " + nombreTabla2 + " SET pais = ?  "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(3, id);
            pstmt.setString(1, name);
            pstmt.setString(2, secondname);

            contador = contador + pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setInt(2, id);
            pstmt.setString(1, pais);

            contador = contador + pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            this.connect().close();
        } catch (SQLException ex) {
        }
        return contador;
    }
}
