package app.scr;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 11/09/2025
 * * Descripción: La clase ArbolBinario simula ser el árbol, en ese existen
 * diferentes opciones como insertar, buscar, y eliminar por ID
 * estos se hacen de manera recursiva y también existen diferentes manera para
 * mostrarlo
 **/
public class ArbolBinario {
    private NodoBinario raiz; // nodo raiz

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
        log("CREACION", "Nuevo árbol binario creado");
    }
    
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

    private boolean insertadoExitosamente; // Variable de instancia

    /**
     * Inserta un nuevo empleado en el árbol binario de búsqueda
     * 
     * @param empleado El empleado a insertar en el árbol
     * @return true si se insertó exitosamente, false si ya existía un empleado con
     *         ese ID
     */
    public boolean insertar(Empleado empleado) {
        insertadoExitosamente = true; // Asumir éxito inicialmente
        raiz = insertarRecursivo(raiz, empleado);
        if (insertadoExitosamente) {
            log("INSERCION", "Empleado insertado en árbol: " + empleado);
        } else {
            log("ERROR", "Intento de insertar empleado duplicado: " + empleado);
        }
        
        return insertadoExitosamente;
    }

    /**
     * Método recursivo para insertar un empleado en el árbol y busca la posición
     * correcta según el ID del empleado
     * 
     * @param nodo     El nodo actual
     * @param empleado El empleado a insertar
     * @return El nodo modificado o creado
     */
    private NodoBinario insertarRecursivo(NodoBinario nodo, Empleado empleado) {
        if (nodo == null)
            return new NodoBinario(empleado);

        if (empleado.id < nodo.getID()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), empleado));
        } else if (empleado.id > nodo.getID()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), empleado));
        } else {
            insertadoExitosamente = false;
        }
        return nodo;
    }

    /**
     * Busca un empleado por su ID en el árbol
     * 
     * @param id El ID del empleado a buscar
     * @return El empleado encontrado o null si no existe
     */
    public Empleado buscar(int id) {
        Empleado resultado = buscarRecursivo(raiz, id);
        
        if (resultado != null) {
            log("BUSQUEDA", "Empleado encontrado en árbol - ID: " + id);
        } else {
            log("BUSQUEDA", "Empleado no encontrado en árbol - ID: " + id);
        }
        
        return resultado;
    }

    /**
     * Método recursivo para buscar un empleado por ID
     * 
     * @param nodo El nodo actual
     * @param id   El ID del empleado a buscar
     * @return El empleado encontrado o null si no existe
     */
    private Empleado buscarRecursivo(NodoBinario nodo, int id) {
        if (nodo == null)
            return null;
        if (id == nodo.getID())
            return nodo.getEmpleado();

        if (id < nodo.getID()) {
            return buscarRecursivo(nodo.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodo.getDerecho(), id);
        }
    }

    /**
     * Elimina un empleado del árbol por su ID
     * 
     * @param id El ID del empleado a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */

    public boolean eliminar(int id) {
        int tamañoAnterior = contarNodos();
        raiz = eliminarRecursivo(raiz, id);
        int tamañoActual = contarNodos();
        boolean eliminado = tamañoActual < tamañoAnterior;

        if (eliminado) {
            log("ELIMINACION", "Empleado eliminado del árbol - ID: " + id);
        } else {
            log("ERROR", "No se pudo eliminar empleado del árbol - ID: " + id);
        }

        return eliminado;
    }

    /**
     * Cuenta el número total de nodos en el árbol
     * 
     * @return El número total de empleados en el árbol
     */

    private int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    /**
     * Método recursivo para contar nodos
     * 
     * @param nodo El nodo actual
     * @return El número de nodos en el subárbol
     */
    private int contarNodosRecursivo(NodoBinario nodo) {
        if (nodo == null)
            return 0;
        return 1 + contarNodosRecursivo(nodo.getIzquierdo()) +
                contarNodosRecursivo(nodo.getDerecho());
    }

    /**
     * Método recursivo para eliminar un nodo del árbol
     * 
     * @param nodo El nodo actual
     * @param id   El ID del empleado a eliminar
     * @return El nodo modificado después de la eliminación
     */
    public NodoBinario eliminarRecursivo(NodoBinario nodo, int id) {
        if (nodo == null) {
            return null;
        }
        if (id < nodo.getID()) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), id));
        } else if (id > nodo.getID()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), id));
        } else {
            // Nodo a eliminar encontrado
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            Empleado sucesor = valorMinimo(nodo.getDerecho());
            nodo.setEmpleado(sucesor);
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.id));
        }

        return nodo;
    }

    /**
     * Encuentra el empleado con el menor ID en un subárbol
     * 
     * @param nodo La raíz del subárbol donde buscar
     * @return El empleado con el menor ID
     */
    private Empleado valorMinimo(NodoBinario nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo.getEmpleado();
        }
        return valorMinimo(nodo.getIzquierdo());
    }

    // Métodos para los orden del árbol
    /**
     * Sive para mostrar el preorden (Raíz-Izquierda-Derecha)
     */
    public void mostrarPreorden() {
        if (raiz == null) {
            System.err.println("El árbol esta vacío");
        }
        log("RECORRIDO", "Iniciando recorrido PreOrden");
        preorden(raiz);
        System.out.println();
    }

    /**
     * Método recursivo para recorrido PreOrden
     * 
     * @param nodo El nodo actual
     */
    private void preorden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.getEmpleado() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }

    /**
     * Sirve para mostrar el inorden
     */
    public void mostrarInorden() {
        if (raiz == null) {
            System.err.println("El árbol esta vacío");
        }
        log("RECORRIDO", "Iniciando recorrido InOrden");
        inorden(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo para el recorrido inorden
     * 
     * @param nodo El nodo actual
     */
    private void inorden(NodoBinario nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getEmpleado() + " ");
            inorden(nodo.getDerecho());
        }
    }

    /**
     * Sirve para mostrar el postorden
     */
    public void mostrarPostorden() {
        if (raiz == null) {
            System.err.println("El árbol esta vacío");
        }
        log("RECORRIDO", "Iniciando recorrido PostOrden");
        postorden(raiz);
        System.out.println();
    }

    /**
     * Sirve para mostrar el postorden de modo recursivo
     * 
     * @param nodo nodo actual
     */
    private void postorden(NodoBinario nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getEmpleado() + " ");
        }
    }

    /**
     * Verfica si esta vacia
     * 
     * @return si esta vací devuelve un true y si no un false
     */
    public boolean isEmpty() {
        if (raiz == null) {
            System.out.println("Esta vacío");
            return true;
        }
        return false;
    }
}
