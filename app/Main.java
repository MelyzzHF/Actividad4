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
            System.out.print("Dirección (1 = izquierda→derecha, 2 = derecha→izquierda): ");
            int dir = sc.nextInt();
            boolean izqADer = (dir != 2); 

            Node<String> raiz = Arbol.construirArbol(niveles, hijos);

            System.out.println("\nÁrbol:");
            Arbol.imprimirArbol(raiz, 0, 4, izqADer);

        }
    }
}
