package app.scr;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data;
    private List<Node<T>> hijos ;


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

    public Node(T data, List<Node<T>>hijos) {
        this.data = data;
        this.hijos = hijos;

    }


    @Override
    public String toString() {
        return data.toString();
    }

}

