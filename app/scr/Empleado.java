package app.scr;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 11/09/2025 
 * * Descripción: La clase Empleado simula ser un empleado, contiene el ID que es un numero único para cada empleado y el nombre
 * 
 * **/

public class Empleado {
    int id; //Número único de identificación
    String nombre; // Nombre del empleado

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //Constructores 
      public Empleado() {
        this.id = 0000;
        this.nombre = " ";
    }

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre;
    }

}
// Sirve para la act 4