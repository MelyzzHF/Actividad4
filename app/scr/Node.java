package app.scr;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data;
    private List<Node<T>> hijos;

    public List<Node<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<Node<T>> hijos) {
        this.hijos = hijos;
    }

    public void agregarHijo(Node<T> hijo) {
        hijos.add(hijo);
    }

    public boolean agregar(T padre, T hijo) {
        if (this.data.equals(padre)) {
            this.hijos.add(new Node<>(hijo));
            return true;
        }
        for (Node<T> n : hijos) {
            if (n.agregar(padre, hijo)) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(T valor) {
        for (int i = 0; i < hijos.size(); i++) {
            Node<T> hijo = hijos.get(i);
            if (hijo.getData().equals(valor)) {
                hijos.remove(i); 
                return true;
            } else if (hijo.eliminar(valor)) {
                return true;
            }
        }
        return false;
    }

    public Node<T> buscar(T valor) {
        if (this.data.equals(valor)) {
            return this;
        }
        for (Node<T> hijo : hijos) {
            Node<T> encontrado = hijo.buscar(valor);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
        this.hijos = new ArrayList<>();
    }

    public Node(T data) {
        this.data = data;
        this.hijos = new ArrayList<>();
    }

    public Node(T data, List<Node<T>> hijos) {
        this.data = data;
        this.hijos = hijos;

    }

    @Override
    public String toString() {
        return data.toString();
    }

}
