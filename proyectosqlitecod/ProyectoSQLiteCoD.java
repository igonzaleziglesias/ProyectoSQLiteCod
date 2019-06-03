package proyectosqlitecod;

import static proyectosqlitecod.Conectar.connect;

public class ProyectoSQLiteCoD {

    public static void main(String[] args) {
        connect();
        Crear base = new Crear("CLASE", "PROCEDENCIA");
        Insertar insert = new Insertar();
        System.out.println("Registros insertados: "+insert.insert(6468, "Iago", "Gonzalez", "España", "CLASE", "PROCEDENCIA"));
        System.out.println("Registros insertados: "+insert.insert(6480, "Cesar", "Romero", "España", "CLASE", "PROCEDENCIA"));
        System.out.println("Registros insertados: "+insert.insert(6467, "Samuel", "Gomez", "España", "CLASE", "PROCEDENCIA"));
        Borrar delete = new Borrar();
        System.out.println("Registros borrados "+delete.delete(6468, "CLASE", "PROCEDENCIA"));
        System.out.println("Registros borrados "+delete.delete(6469, "CLASE", "PROCEDENCIA"));
        System.out.println("Registros borrados "+delete.deleteNombre("Samuel", "CLASE", "PROCEDENCIA"));
        System.out.println("Registros borrados "+delete.delete(6467, "CLASE", "PROCEDENCIA"));
    }

}
