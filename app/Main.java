package app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 11/09/2025 
 * * Descripción: La clase Main sirve para mostrarle al usuario el menu principal con las distintas opciones
 * 
 * 
 * **/
import java.util.Scanner;
import app.scr.ArbolBinario;
import app.scr.Comparacion;
import app.scr.Empleado;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArbolBinario arbol = new ArbolBinario();

    
    /**
     * // Sistema de logging
     * @param operacion la operacion que se usa 
     * @param detalle resultado 
     */
    private static void log(String operacion, String detalle) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("arbol_empleados.log", true))) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.println("[" + ahora.format(formatter) + "] " + operacion + ": " + detalle);
        } catch (IOException e) {
            System.err.println("Error al escribir en el log: " + e.getMessage());
        }
    }
    /**
     * 
     * @param args Se manda a llamar la función del menú
     */
    public static void main(String[] args) {
        log("INICIO", "INICIADO...");
        mostrarMenu();
    }

    /**
     * Funcion para el menú
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ÁRBOL ---");
        System.out.println("1. Construir árbol");
        System.out.println("2. Buscar empleado");
        System.out.println("3. Agregar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Imprimir árbol");
        System.out.println("6. Comparar rendimientos");
        System.out.println("7. Salir");

        System.out.print("Elige una opción: ");

        int opcion;
        try {
            opcion = sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
            System.out.println(" Entrada inválida. Intenta de nuevo.");
            log("ERROR", "Entrada inválida en menú principal");
            mostrarMenu();
            return;
        }

        switch (opcion) {
            case 1:
                construirArbol();
                break;
            case 2:
                buscarNodo();
                break;
            case 3:
                agregarNodo();
                break;
            case 4:
                eliminarNodo();
                break;
            case 5:
                imprimirArbol();
                break;
            case 6:
                Comparacion.compararRendimiento();
                break;
            case 7: {
                System.out.println("Saliendo...");
                log("SALIDA", "TERMINADOO");
                return;
            }
            default:
                System.out.println("Opción inválida.");
                log("ERROR", "Opción de menú inválida: " + opcion);
        }

        mostrarMenu();
    }

    /**
     * Funcion para contruir el arbol, primero construye un nombre y después le
     * agrega el id
     */
    private static void construirArbol() {
        try {
            System.out.println("\n CONSTRUYENDO ÁRBOL CON 1000 EMPLEADOS...");
            log("CONSTRUCCION", "Iniciando construcción del árbol con 1000 empleados");
            arbol = new ArbolBinario();

            String[] nombres = {
                    "Ana", "Carlos", "María", "Juan", "Laura", "Pedro", "Sofía", "Diego",
                    "Carmen", "Luis", "Elena", "Roberto", "Patricia", "Miguel", "Rosa",
                    "Fernando", "Isabel", "Antonio", "Mónica", "Javier"
            };

            String[] apellidos = {
                    "García", "López", "Rodríguez", "Martínez", "Pérez", "Sánchez",
                    "Ramírez", "Cruz", "Flores", "Gómez", "Díaz", "Ruiz", "Hernández",
                    "Jiménez", "Morales", "Muñoz", "Álvarez", "Romero", "Navarro", "Torres"
            };

            for (int i = 1; i <= 1000; i++) {
                int id = 0 + i;
                String nombre = nombres[i % nombres.length] + " " +
                        apellidos[(i / nombres.length) % apellidos.length];

                Empleado empleado = new Empleado(id, nombre);
                arbol.insertar(empleado);
            }

            System.out.println(" Árbol construido ");
            System.out.println(" Se insertaron 1000 empleados (IDs: 1-1000)");
            log("CONSTRUCCION", "Árbol construido exitosamente con 1000 empleados");

        } catch (Exception e) {
            System.out.println(" Error al construir el árbol: " + e.getMessage());
            log("ERROR", "Error al construir el árbol: " + e.getMessage());
        }
    }

    /**
     * busca el empleado apartir del ID, si no existe un árbol no puede buscar
     */
    private static void buscarNodo() {
        if (arbol.isEmpty()) {
            System.out.println(" Primero construye un árbol.");
            log("ERROR", "Intento de búsqueda en árbol vacío");
            return;
        }

        try {
            System.out.print(" Ingrese el ID del empleado a buscar: ");
            int id = sc.nextInt();

            log("BUSQUEDA", "Iniciando búsqueda del empleado con ID: " + id);
            Empleado encontrado = arbol.buscar(id);

            if (encontrado != null) {
                System.out.println(" Encontrado: " + encontrado);
                log("BUSQUEDA", "Empleado encontrado: " + encontrado);
            } else {
                System.out.println(" Empleado con ID " + id + " no existe");
                log("BUSQUEDA", "Empleado con ID " + id + " no encontrado");
            }
        } catch (Exception e) {
            System.out.println(" Error: Ingrese un ID válido (número entero)");
            log("ERROR", "Error en búsqueda: entrada inválida");
            sc.nextLine();
        }
    }

    /**
     * Agregar empleado, primero debe constuir el arbol y despues pide el id y el
     * nombre
     */

    private static void agregarNodo() {
        if (arbol.isEmpty()) {
            System.out.println(" Primero construye un árbol.");
            log("ERROR", "Intento de agregar empleado en árbol vacío");
            return;
        }

        int id = 0;
        String nombre = "";
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.print("ID del nuevo empleado (número entero): ");
                id = sc.nextInt();

                if (id <= 0) {
                    System.out.println("El ID debe ser un número positivo mayor que 0");
                    continue;
                }

                if (arbol.buscar(id) != null) {
                    System.out.println(" Ya existe un empleado con ID " + id);
                    log("ERROR", "Intento de agregar empleado con ID duplicado: " + id);
                    continue;
                }

                idValido = true;

            } catch (Exception e) {
                System.out.println(" Error: El ID debe ser un número entero válido");
                log("ERROR", "Error al ingresar ID: entrada inválida");
                sc.nextLine();
            }
        }

        sc.nextLine();

        boolean nombreValido = false;
        while (!nombreValido) {
            try {
                System.out.print("Nombre del empleado: ");
                nombre = sc.nextLine().trim();

                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío");
                    continue;
                }
                nombreValido = true;

            } catch (Exception e) {
                System.out.println("Inválido ingresa un nombre");
            }
        }

        try {
            Empleado nuevoEmpleado = new Empleado(id, nombre);
            boolean agregado = arbol.insertar(nuevoEmpleado);

            if (agregado) {
                System.out.println("Empleado agregado exitosamente!");
                log("INSERCION", "Empleado agregado exitosamente: " + nuevoEmpleado);
            } else {
                System.out.println(" No se pudo agregar el empleado (ID ya existe)");
                log("ERROR", "No se pudo agregar empleado con ID " + id + " (ya existe)");
            }
        } catch (Exception e) {
            System.out.println(" Error al crear el empleado: " + e.getMessage());
            log("ERROR", "Error al crear empleado: " + e.getMessage());
        }
    }

    /**
     * Elimina el empleado, primero debe construir el arbol y despues pide el ID
     */
    private static void eliminarNodo() {
        if (arbol.isEmpty()) {
            System.out.println(" Primero construye un árbol.");
            log("ERROR", "Intento de eliminar empleado en árbol vacío");
            return;
        }

        try {
            System.out.print(" ID del empleado a eliminar: ");
            int id = sc.nextInt();

            Empleado empleado = arbol.buscar(id);
            if (empleado == null) {
                System.out.println(" Empleado con ID " + id + " no encontrado");
                log("ERROR", "Intento de eliminar empleado inexistente con ID: " + id);
                return;
            }

            System.out.println(" Empleado encontrado: " + empleado);
            System.out.print(" ¿Confirma la eliminación? (si o no ): ");
            String confirmacion = sc.next();

            if (confirmacion.toLowerCase().equals("si")) {
                boolean eliminado = arbol.eliminar(id);

                if (eliminado) {
                    System.out.println(" Empleado eliminado exitosamente!");
                    log("ELIMINACION", "Empleado eliminado exitosamente: " + empleado);
                } else {
                    System.out.println(" Error al eliminar el empleado");
                    log("ERROR", "Error al eliminar empleado con ID: " + id);
                }
            } else {
                System.out.println("Eliminación cancelada");
                log("CANCELACION", "Eliminación cancelada para empleado con ID: " + id);
            }
        } catch (Exception e) {
            System.out.println(" Error: Ingrese un ID válido (número entero)");
            log("ERROR", "Error en eliminación: entrada inválida");
            sc.nextLine();
        }
    }

    /**
     * Imprime el arbol de distintas maneras
     */
    private static void imprimirArbol() {
        if (arbol.isEmpty()) {
            System.out.println(" El árbol está vacío");
            log("AVISOO", "Intento de imprimir árbol vacío");
            return;
        }

        System.out.println("\n ESTRUCTURA DEL ÁRBOL:");
        log("IMPRESION", "Iniciando impresión de la estructura del árbol");

        System.out.println("\n Recorrido InOrden (ordenado por ID):");
        arbol.mostrarInorden();

        System.out.println("\n Recorrido PreOrden:");
        arbol.mostrarPreorden();

        System.out.println("\n Recorrido PostOrden:");
        arbol.mostrarPostorden();
        log("IMPRESION", "Estructura del árbol impresa exitosamente");
    }

}
