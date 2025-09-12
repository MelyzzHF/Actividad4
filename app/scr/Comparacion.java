package app.scr;

/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 11/09/2025 
 * * Descripción: La clase Comparacion compara el arreglo normal vs arbol binario
 * 
 * **/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Comparacion {
    // Sistema de logging
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
     * Compara el arreglo vs el arbol
     */
    public static void compararRendimiento() {
        log("COMPARACION", "Iniciando comparación de rendimiento arreglo vs árbol");

        // Crear arreglo de empleados
        Empleado[] arreglo = new Empleado[10000];

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

        for (int i = 0; i < 10000; i++) {
            int id = 1000 + i;
            String nombre = nombres[i % nombres.length] + " " +
                    apellidos[(i / nombres.length) % apellidos.length];
            arreglo[i] = new Empleado(id, nombre);
        }

        Collections.shuffle(Arrays.asList(arreglo));
        log("COMPARACION", "Arreglo de 10000 empleados creado y mezclado");

        ArbolBinario arbolBinario = new ArbolBinario();
        for (Empleado empleado : arreglo) {
            arbolBinario.insertar(empleado);
        }
        log("COMPARACION", "Árbol binario construido con 10000 empleados");

        // Buscar un empleado aleatorio
        Random rand = new Random();
        Empleado buscar = arreglo[rand.nextInt(arreglo.length)];
        System.out.println("Buscando: " + buscar);
        log("COMPARACION", "Empleado seleccionado para búsqueda: " + buscar);

        long inicioArreglo = System.nanoTime();
        boolean encontradoArreglo = false;
        for (Empleado empleado : arreglo) {
            if (empleado.getId() == buscar.getId()) {
                encontradoArreglo = true;
                break;
            }
        }
        long finArreglo = System.nanoTime();

        long inicioArbol = System.nanoTime();
        Empleado encontradoArbol = arbolBinario.buscar(buscar.getId());
        boolean existeEnArbol = (encontradoArbol != null);
        long finArbol = System.nanoTime();

        long tiempoArreglo = finArreglo - inicioArreglo;
        long tiempoArbol = finArbol - inicioArbol;

        // Mostrar resultados
        System.out.println("Arreglo: " + tiempoArreglo + " ns - Encontrado: " + encontradoArreglo);
        System.out.println("Árbol: " + tiempoArbol + " ns - Encontrado: " + existeEnArbol);

        if (tiempoArbol < tiempoArreglo) {
            System.out.println("EL ÁRBOL FUE MÁS RÁPIDO");
            log("COMPARACION",
                    "Resultado: Árbol más rápido - Árbol: " + tiempoArbol + "ns, Arreglo: " + tiempoArreglo + "ns");
        } else {
            System.out.println("EL ARREGLO FUE MÁS RÁPIDO");
            log("COMPARACION",
                    "Resultado: Arreglo más rápido - Árbol: " + tiempoArbol + "ns, Arreglo: " + tiempoArreglo + "ns");
        }

        log("COMPARACION", "Comparación de rendimiento completada");
    }
}