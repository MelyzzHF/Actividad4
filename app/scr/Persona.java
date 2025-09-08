package app.scr;

public class Persona {
    int id;
        String nombre;

        public Persona(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "[" + id + "] " + nombre;
        }
    
}
// Sirve para la act 4