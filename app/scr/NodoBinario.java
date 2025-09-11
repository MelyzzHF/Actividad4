package app.scr;


class NodoBinario<T> {
    private T data;
    private NodoBinario<T> izquierdo;
    private NodoBinario<T> derecho;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoBinario<T>  getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario<T>  izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario<T>  getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario<T>  derecho) {
        this.derecho = derecho;
    }

    public NodoBinario() {
        this.data = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoBinario(T data) {
        this.data = data;
    }

    public NodoBinario(T data,NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
        this.data = data;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }



}
