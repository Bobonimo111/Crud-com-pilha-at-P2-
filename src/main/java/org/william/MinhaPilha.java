package org.william;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MinhaPilha<T> {
    private ArrayList<T> elementos;

    public MinhaPilha(){
        this.elementos = new ArrayList<>();
    }

    public void adicionar(T item){
        elementos.add(item);
    }

    public T tirarDoTopo(){
        if(estaVazia()){
            throw new EmptyStackException();
        }
        return elementos.remove(tamanho() - 1);
    }

    public T topo(){
        if(estaVazia()){
            throw new EmptyStackException();
        }
        return elementos.get(tamanho() - 1);
    }

    public boolean estaVazia(){
        return elementos.isEmpty();
    }

    public int tamanho(){
        return elementos.size();
    }
}