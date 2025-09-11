package app.scr;

import java.util.*;

//Dado que queremos comparar que el arbol es más rápido que el arreglo, se tuvo que hacer un árbol binario, no n-nario (que es mi arbol original)
//ya que se pidio en la clase anterior, proximammente se cambiara de n-ario a binario para la actividad 4 

public class Comparacion {
    public static void main(String[] args) {
        String[] arreglo = new String[10000];
        for (int i = 0; i < 10000; i++) {
            arreglo[i] = "Elemento" + i;
        }
        Collections.shuffle(Arrays.asList(arreglo));

        ArbolBinario arbolBinario = new ArbolBinario();
        for (String elemento : arreglo) {
            arbolBinario.insertar(elemento);
        }

        // Buscar un elemento
        Random rand = new Random();
        String buscar = arreglo[rand.nextInt(arreglo.length)];
        System.out.println("Buscando: " + buscar);

        long inicioArreglo = System.nanoTime();
        boolean encontradoArreglo = false;
        for (String elemento : arreglo) {
            if (elemento.equals(buscar)) {
                encontradoArreglo = true;
                break;
            }
        }
        long finArreglo = System.nanoTime();

        // Buscar en árbol binario
        long inicioArbol = System.nanoTime();
        boolean encontradoArbol = arbolBinario.buscar(buscar);
        long finArbol = System.nanoTime();

        System.out.println("Arreglo: " + (finArreglo - inicioArreglo) + " ns - Encontrado: " + encontradoArreglo);
        System.out.println("Árbol: " + (finArbol - inicioArbol) + " ns - Encontrado: " + encontradoArbol);

        if ((finArbol - inicioArbol) < (finArreglo - inicioArreglo)) {
            System.out.println("EL ÁRBOL FUE MÁS RÁPIDO");
        } else {
            System.out.println("EL ARREGLO FUE MÁS RÁPIDO");
        }
    }
}

