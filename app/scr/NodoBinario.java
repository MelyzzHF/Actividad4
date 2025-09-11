package app.scr;

class NodoBinario {
    private Empleado empleado;
    private NodoBinario izquierdo;
    private NodoBinario derecho;

    public Empleado getEmpleado() {
        return empleado;
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
