package app;

import java.util.Scanner;


import app.scr.Arbol;
import app.scr.Node;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nNúmero de niveles: ");
            int niveles = sc.nextInt();

            System.out.print("Número de hijos por nodo: ");
            int hijos = sc.nextInt();

            Node<String> raiz = Arbol.construirArbol(niveles, hijos);

            System.out.println("\nArbol:");
            Arbol.imprimirArbol(raiz, 0, 4);
        } 
    }
}
