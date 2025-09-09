package app;

import app.scr.Arbol;
import app.scr.Node;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Node<String> raiz;
    private static boolean izqADer = true;

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ÁRBOL ---");
        System.out.println("1. Construir árbol");
        System.out.println("2. Buscar nodo");
        System.out.println("3. Agregar hijo");
        System.out.println("4. Eliminar nodo");
        System.out.println("5. Imprimir árbol");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");

        int opcion;
        try {
            opcion = sc.nextInt();
        } catch (Exception e) {
            sc.nextLine(); 
            System.out.println(" Entrada inválida. Intenta de nuevo.");
            mostrarMenu(); 
            return;
        }

        switch (opcion) {
            case 1 -> construirArbol();
            case 2 -> buscarNodo();
            case 3 -> agregarNodo();
            case 4 -> eliminarNodo();
            case 5 -> imprimirArbol();
            case 6 -> {
                System.out.println("Saliendo...");
                return;
            }
            default -> System.out.println("Opción inválida.");
        }

        mostrarMenu(); 
    }

    private static void construirArbol() {
        int niveles = pedirNumero("\nNúmero de niveles (1-4): ", 1, 4, 2);
        int hijos = pedirNumero("Número de hijos por nodo (1-5): ", 1, 5, 2);
        int dir = pedirNumero("Dirección (1 = izq -> der, 2 = der - > izq): ", 1, 2, 1);
        izqADer = (dir != 2);

        raiz = Arbol.construirArbol(niveles, hijos);
        System.out.println("Árbol construido!");
    }

    private static void buscarNodo() {
        if (raiz == null) {
            System.out.println(" Primero construye un árbol.");
            return;
        }
        System.out.print("Valor a buscar: ");
        String valor = sc.next();
        Node<String> encontrado = raiz.buscar(valor);
        System.out.println(encontrado != null ? "Encontrado: " + encontrado : " No existe");
    }

    private static void agregarNodo() {
        if (raiz == null) {
            System.out.println(" Primero construye un árbol.");
            return;
        }
        System.out.print("Padre: ");
        String padre = sc.next();
        System.out.print("Nuevo hijo: ");
        String hijo = sc.next();
        boolean agregado = raiz.agregar(padre, hijo);
        System.out.println(agregado ? "Agregado!" : " Padre no encontrado");
    }

    private static void eliminarNodo() {
        if (raiz == null) {
            System.out.println(" Primero construye un árbol.");
            return;
        }
        System.out.print("Nodo a eliminar: ");
        String eliminar = sc.next();
        boolean eliminado = raiz.eliminar(eliminar);
        System.out.println(eliminado ? " Eliminado!" : " No encontrado");
    }

    private static void imprimirArbol() {
        if (raiz == null) {
            System.out.println(" Primero construye un árbol.");
            return;
        }
        System.out.println("\nÁrbol:");
        Arbol.imprimirArbol(raiz, 0, 4, izqADer);
    }

    private static int pedirNumero(String mensaje, int min, int max, int defecto) {
        System.out.print(mensaje);
        try {
            int num = sc.nextInt();
            if (num < min || num > max) {
                System.out.println(" Fuera de rango, usando valor por defecto: " + defecto);
                return defecto;
            }
            return num;
        } catch (Exception e) {
            sc.nextLine(); 
            System.out.println(" Entrada inválida, usando valor por defecto: " + defecto);
            return defecto;
        }
    }
}