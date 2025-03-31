package org.william.interfaces;

import org.william.entities.Tarefa;

import java.util.List;

public interface ITarefaRepository {
    void salvar(Tarefa tarefa);

    void remover(int id);

    void alterar(Tarefa tarefa);

    List<Tarefa> listar();
}
