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
