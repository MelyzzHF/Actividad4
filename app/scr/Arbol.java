package app.scr;

import java.util.List;

public class Arbol {

    private static char letraActual = 'A';

    private static String nuevaLetra() {
        String letra = String.valueOf(letraActual);
        letraActual++;
        if (letraActual > 'Z')
            letraActual = 'A';
        return letra;
    }

    public static Node<String> construirArbol(int niveles, int hijos) {
        if (niveles <= 0)
            return null;

        Node<String> nodo = new Node<>(nuevaLetra());
        if (niveles == 1)
            return nodo;

        for (int i = 0; i < hijos; i++) {
            Node<String> child = construirArbol(niveles - 1, hijos);
            nodo.agregarHijo(child);
        }
        return nodo;
    }

    public static void imprimirArbol(Node<String> nodo, int nivel, int espacios) {
        imprimirArbol(nodo, nivel, espacios, true);
    }

    public static void imprimirArbol(Node<String> nodo, int nivel, int espacios, boolean izqADer) {
        if (nodo == null)
            return;

        System.out.println(" ".repeat(espacios * nivel) + nodo.getData());

        List<Node<String>> hijos = nodo.getHijos();
        int n = hijos.size();
        System.out.println("Cantidad de hijos " + n);

        if (n > 0) {
            StringBuilder lineas = new StringBuilder();

            if (n == 1) {
                lineas.append("| ");
            } else {
                String primero = izqADer ? "/ " : "\\ ";
                String medio = "| ";
                String ultimo = izqADer ? "\\ " : "/ ";

                for (int i = 0; i < n; i++) {
                    if (i == 0)
                        lineas.append(primero);
                    else if (i == n - 1)
                        lineas.append(ultimo);
                    else
                        lineas.append(medio);
                }
            }
            System.out.println(" ".repeat(espacios * nivel) + lineas);
        }

        if (izqADer) {
            for (int i = 0; i < n; i++) {
                imprimirArbol(hijos.get(i), nivel + 1, espacios, izqADer);
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                imprimirArbol(hijos.get(i), nivel + 1, espacios, izqADer);
            }
        }
    }
}

// Pendiente por hacer para mañana: Corregir la impresion del arbol(corregirla), que sea de
// izq o derecha (integrado)
// pendientes : Inserta, eliminar, buscar (crear los metodos para los nodos)
// recorridos preorden, inorden y postorden.
// Hacer un commit cada dia