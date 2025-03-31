package org.william.repositories;

import org.william.entities.Tarefa;
import org.william.interfaces.ITarefaRepository;
import org.william.utils.MinhaPilha;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository implements ITarefaRepository {
    private MinhaPilha<Tarefa> pilhaTarefas;
    private int proximoId;

    public TarefaRepository() {
        this.pilhaTarefas = new MinhaPilha<>();
        this.proximoId = 1;
    }

    @Override
    public void salvar(Tarefa tarefa) {
        tarefa.setId(proximoId++);
        pilhaTarefas.push(tarefa);
    }

    @Override
    public void remover(int id) {
        MinhaPilha<Tarefa> temp = new MinhaPilha<>();
        boolean encontrou = false;

        while (!pilhaTarefas.isEmpty()) {
            Tarefa t = pilhaTarefas.pop();
            if (t.getId() == id) {
                encontrou = true;
                break;
            }
            temp.push(t);
        }

        // Reempilhar as tarefas mantendo a ordem original
        while (!temp.isEmpty()) {
            pilhaTarefas.push(temp.pop());
        }

        if (!encontrou) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
    }

    @Override
    public void alterar(Tarefa tarefa) {
        MinhaPilha<Tarefa> temp = new MinhaPilha<>();
        boolean encontrou = false;

        while (!pilhaTarefas.isEmpty()) {
            Tarefa t = pilhaTarefas.pop();
            if (t.getId() == tarefa.getId()) {
                temp.push(tarefa);
                encontrou = true;
            } else {
                temp.push(t);
            }
        }

        // Reempilhar as tarefas mantendo a ordem original
        while (!temp.isEmpty()) {
            pilhaTarefas.push(temp.pop());
        }

        if (!encontrou) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + tarefa.getId());
        }
    }

    @Override
    public List<Tarefa> listar() {
        // Retorna uma cópia dos elementos na pilha (do fundo para o topo)
        List<Tarefa> lista = new ArrayList<>();
        MinhaPilha<Tarefa> temp = new MinhaPilha<>();

        // Desempilhar para uma pilha temporária
        while (!pilhaTarefas.isEmpty()) {
            temp.push(pilhaTarefas.pop());
        }

        // Reempilhar e construir a lista na ordem correta
        while (!temp.isEmpty()) {
            Tarefa t = temp.pop();
            lista.add(t);
            pilhaTarefas.push(t);
        }

        return lista;
    }
}
