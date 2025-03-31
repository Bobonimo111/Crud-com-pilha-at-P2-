package org.william.utils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MinhaPilha<T> {
    private List<T> elementos;
    private int topo;

    public MinhaPilha() {
        this.elementos = new ArrayList<>();
        this.topo = -1;
    }

    public void push(T elemento) {
        elementos.add(elemento);
        topo++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T elemento = elementos.remove(topo);
        topo--;
        return elemento;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(topo);
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public List<T> getAllElements() {
        return new ArrayList<>(elementos);
    }
}