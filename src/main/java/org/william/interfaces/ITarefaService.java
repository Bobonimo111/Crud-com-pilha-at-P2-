package org.william.interfaces;

import org.william.entities.Tarefa;

import java.util.List;

public interface ITarefaService {
    void cadastrarTarefa(Tarefa tarefa);
    Tarefa buscarTarefa(int id);
    void atualizarTarefa(Tarefa tarefa);
    void removerTarefa(int id);
    List<Tarefa> listarTarefas();
    void marcarComoConcluida(int id);
}
