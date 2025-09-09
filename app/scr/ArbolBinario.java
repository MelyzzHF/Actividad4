package app.scr;

public class ArbolBinario {
    private NodoBinario raiz;

    public void insertar(String valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoBinario insertarRecursivo(NodoBinario nodo, String valor) {
        if (nodo == null)
            return new NodoBinario(valor);

        if (valor.compareTo(nodo.getValor()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        }
        return nodo;
    }

    public boolean buscar(String valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoBinario nodo, String valor) {
        if (nodo == null)
            return false;
        if (valor.equals(nodo.getValor()))
            return true;

        if (valor.compareTo(nodo.getValor()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } else {
            return buscarRecursivo(nodo.getDerecho(), valor);
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
            System.out.print(nodo.getValor() + " ");
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
            System.out.print(nodo.getValor() + " ");
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
            System.out.print(nodo.getValor() + " ");
        }
    }
}

