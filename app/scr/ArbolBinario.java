package app.scr;

public class ArbolBinario {
    private NodoBinario raiz;

    public ArbolBinario(){
        this.raiz = null;
    }

    public void insertar(Empleado empleado) {
        raiz = insertarRecursivo(raiz, empleado);
    }

    private NodoBinario insertarRecursivo(NodoBinario nodo, Empleado empleado) {
        if (nodo == null)
            return new NodoBinario(empleado);

        if (empleado.id < nodo.getID()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), empleado));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), empleado));
        }
        return nodo;
    }

    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(NodoBinario nodo, int id) {
        if (nodo == null)
            return false;
        if (id == nodo.getID())
            return true;

        if (id < nodo.getID()) {
            return buscarRecursivo(nodo.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodo.getDerecho(), id);
        }
    }
    
    public void eliminar(int id){
        raiz = eliminarRecursivo(raiz, id);
    }

    public NodoBinario eliminarRecursivo(NodoBinario nodo, int id){
        if (nodo == null){
            return null;
        }


    }



    // Métodos para los orden del árbol 
    public void preorden() {
        System.out.print("Preorden: ");
        preorden(raiz);
        System.out.println();
    }
    
    private void preorden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.getEmpleado() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }
    
    public void inorden() {
        System.out.print("Inorden: ");
        inorden(raiz);
        System.out.println();
    }
    
    private void inorden(NodoBinario nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getEmpleado() + " ");
            inorden(nodo.getDerecho());
        }
    }
    
    public void postorden() {
        System.out.print("Postorden: ");
        postorden(raiz);
        System.out.println();
    }
    
    private void postorden(NodoBinario nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getEmpleado() + " ");
        }
    }
}

