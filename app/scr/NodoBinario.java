package app.scr;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 11/09/2025 
 * * Descripción: La clase NodoBinario sirve para hacer los nodos que contiene el arbol, adentro de os nodos esta la información del empleado
 * 
 * **/

class NodoBinario {

    private Empleado empleado; // El nodo contiene la información del Empleado
    private NodoBinario izquierdo; // Simula el nodo izquierdo (hijo)
    private NodoBinario derecho; //Simula el nodo derecho (hijo)

    //Get´s y Set´s de los atributos y constructores
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado; 
    }

    public int getID() {
        return empleado.id;
    }

    public NodoBinario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario derecho) {
        this.derecho = derecho;
    }

    public NodoBinario(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoBinario(Empleado empleado, NodoBinario izquierdo, NodoBinario derecho) {
        this.empleado = empleado;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    

}
