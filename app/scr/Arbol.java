package app.scr;

import java.util.List;

public class Arbol {

private static char letraActual = 'A';

    private static String nuevaLetra() {
        String letra = String.valueOf(letraActual);
        letraActual++;
        if (letraActual > 'Z') letraActual = 'A';
        return letra;
    }

    // recursiva del árbol
    public static Node<String> construirArbol(int niveles, int hijos) {
        if (niveles == 0) return null;

        Node<String> nodo = new Node<>(nuevaLetra());
        if (niveles == 1) return nodo;

        for (int i = 0; i < hijos; i++) {
            nodo.agregarHijo(construirArbol(niveles - 1, hijos));
        }
        return nodo;
    }



    
   public static void imprimirArbol(Node<String> nodo, int nivel, int espacios) {
        if (nodo == null) return;

        System.out.println(" ".repeat(espacios * nivel) + nodo.getData());

        List<Node<String>> hijos = nodo.getHijos();
        if (hijos.size() > 0) {
            StringBuilder lineas = new StringBuilder();
            for (int i = 0; i < hijos.size(); i++) {
                if (i == 0) lineas.append("/ ");
                else if (i == hijos.size() - 1) lineas.append("\\ ");
                else lineas.append("| ");
            }
            System.out.println(" ".repeat(espacios * nivel) + lineas);
        }

        for (Node<String> hijo : hijos) {
            imprimirArbol(hijo, nivel + 1, espacios);
        }
    }
}

//Pendiente por hacer para mañana: Corregir la impresion del arbol, que sea de izq o derecha
//pendientes : Inserta, eliminar, buscar (crear los metodos para los nodos)
// recorridos preorden, inorden y postorden. 
// Hacer un commit cada dia 
