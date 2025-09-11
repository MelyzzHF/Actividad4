package app.scr;

public class ArbolBinario<T> {
    private NodoBinario<T> raiz;

    public void insertar(String data) {
        raiz = insertarRecursivo(raiz, data);
    }

    private NodoBinario<T> insertarRecursivo(NodoBinario<T> nodo, String data) {
        if (nodo == null)
            return new NodoBinario<T>();

        if (data.compareTo((String) nodo.getData()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), data));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), data));
        }
        return nodo;
    }

    public boolean buscar(String valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoBinario<T> nodo, String data) {
        if (nodo == null)
            return false;
        if (data.equals(nodo.getData()))
            return true;

        if (data.compareTo((String) nodo.getData()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), data);
        } else {
            return buscarRecursivo(nodo.getDerecho(), data);
        }
    }

    // Métodos para los orden del árbol 
    public void preorden() {
        System.out.print("Preorden: ");
        preorden(raiz);
        System.out.println();
    }
    
    private void preorden(NodoBinario<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getData() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }
    
    public void inorden() {
        System.out.print("Inorden: ");
        inorden(raiz);
        System.out.println();
    }
    
    private void inorden(NodoBinario<T> nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getData() + " ");
            inorden(nodo.getDerecho());
        }
    }
    
    public void postorden() {
        System.out.print("Postorden: ");
        postorden(raiz);
        System.out.println();
    }
    
    private void postorden(NodoBinario<T> nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getData() + " ");
        }
    }
}

