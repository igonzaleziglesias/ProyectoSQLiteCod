package proyectosqlitecod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author igonzaleziglesias
 */
public class Borrar {

    static Object[] alumno;

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
     * Metodo para borrar datos en la tabla por id (clave primaria, que se
     * corresponden a los alumnos de la clase.
     *
     * @param id clave primaria
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo el
     * borrado o no existe esa busqueda devuelve 0
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
     * Metodo para selecionar el id dada una sentencia sql
     *
     * @param sql sentencia sql
     * @return el id
     */
    private int select(String sql) {
        int result = 0;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    result = rs.getInt("id");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = -1;
                }

            }

        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            result = -1;
        }
        return result;
    }

    /**
     * Metodo para borrar datos en la tabla por nombre, que se
     * corresponden a los alumnos de la clase.
     *
     * @param name nombre de la persona
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo el
     * borrado o no existe esa busqueda devuelve 0
     */
    public int deleteNombre(String name, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        int id = select("SELECT id FROM CLASE WHERE name = '" + name + "'");
        System.out.println(id);
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
     * Metodo para borrar datos en la tabla por apellido, que se
     * corresponden a los alumnos de la clase.
     *
     * @param secondname apellido de la persona
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo el
     * borrado o no existe esa busqueda devuelve 0
     */
    public int deleteApellido(String secondname, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        int id = select("SELECT id FROM CLASE WHERE secondname = '" + secondname + "'");
        System.out.println(id);
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
     * Metodo para selecionar el id dada una sentencia sql
     *
     * @param sql sentencia sql
     * @return el id
     */
    private ArrayList select2(String sql) {
        int result = 0;
        ArrayList<Integer> ids = new ArrayList<>();
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    result = rs.getInt("id");
                    ids.add(result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = -1;
                }

            }

        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            result = -1;
        }
        return ids;
    }

    /**
     * Metodo para borrar datos en la tabla por pais de procedencia, que se
     * corresponden a los alumnos de la clase.
     *
     * @param pais pais de la persona
     * @param nombreTabla nombre de la tabla 1
     * @param nombreTabla2 nombre de la tabla 2
     * @return el numero de registros que borro, si hay algun error y no hizo el
     * borrado o no existe esa busqueda devuelve 0
     */
    public int deletePais(String pais, String nombreTabla, String nombreTabla2) {
        int devol = 0;
        int i = 0;
        ArrayList<Integer> id = select2("SELECT id FROM PROCEDENCIA WHERE pais = '" + pais + "'");
        System.out.println(id);
        String sql = "DELETE FROM " + nombreTabla + " WHERE id = ?";//orden de borrado
        String sql2 = "DELETE FROM " + nombreTabla2 + " WHERE id = ?";//orden de borrado

        for (int ele : id) {
            try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {//realiza conexion
                pstmt.setInt(1, id.get(i));
                i++;
                devol = devol + pstmt.executeUpdate();//ejecuccion

            } catch (SQLException e) {
//            System.out.println(e.getMessage());

                try {
                    this.connect().close();
                } catch (SQLException ex) {
                }

                devol = devol + 0;
            }
        }
        i = 0;
        for (int ele : id) {
            try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql2)) {//realiza conexion
                pstmt.setInt(1, id.get(i));
                devol = devol + pstmt.executeUpdate();//ejecuccion
                i++;
            } catch (SQLException e) {
//            System.out.println(e.getMessage());

                try {
                    this.connect().close();
                } catch (SQLException ex) {
                }

                devol = devol + 0;
            }
        }
        return devol;

    }
}
