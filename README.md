# Actividad4
Repositorio para la Actividad 4 MYHF
Es un sistema de Empleados, en los cuales se puede insertar, eliminar, buscar y mostrar, cada empleado tiene su nombre y el id.

CARACTERISTICAS 
Se crearon 5 clases: 
Se creo Comparacion : en esta clase está la creación del arreglo y se hace la comparación entre el arreglo y el árbol
Se creo ArbolBinario : en esta clase se crea el árbol binario y sus métodos como insertar y buscar y aparte tiene los metodos de diferente tipos de orden (preorden, inorden y postorden)
Se creo NodoBinario : contiene el valor y el nodo izquierdo y derecho
Se creo Main: sirve para mostrar el menú al usuario 
Se creo Empleado: Simula ser un empleado, contiene el nombre y id 
Y se validaron los posibles errores en los datos

ARCHIVOS  IMPLEMENTADOS 
arbol_empleados.log - Archivo de log con todas las operaciones del sistema

COMANDOS PARA EJECUTAR
Para ejecutar el programa primero se debe compilar las clases, esto se hace con el comando: javac -cp . (Directorio donde se encuentra el main.java)\Main.java, (en mi caso es javac -cp . app\Main.java)

y una vez hecho esto, se corre el Main con: java -cp . app.Main

Menú Principal
Al ejecutar el programa, se mostrará el siguiente menú:
--- MENÚ ÁRBOL ---
1. Construir árbol
2. Buscar empleado
3. Agregar empleado
4. Eliminar empleado
5. Imprimir árbol
6. Comparar rendimientos
7. Salir