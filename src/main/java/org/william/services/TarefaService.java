package org.william.services;

import org.william.entities.Tarefa;
import org.william.interfaces.ITarefaRepository;
import org.william.interfaces.ITarefaService;
import org.william.repositories.TarefaRepository;

import java.util.List;

public class TarefaService implements ITarefaService {
    private ITarefaRepository repository;

    public TarefaService() {
        this.repository = new TarefaRepository();
    }

    @Override
    public void cadastrarTarefa(Tarefa tarefa) {
        repository.salvar(tarefa);
    }

    @Override
    public Tarefa buscarTarefa(int id) {
        List<Tarefa> tarefas = repository.listar();
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        repository.alterar(tarefa);
    }

    @Override
    public void removerTarefa(int id) {
        repository.remover(id);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    @Override
    public void marcarComoConcluida(int id) {
        Tarefa tarefa = buscarTarefa(id);
        if (tarefa != null) {
            tarefa.setConcluida(true);
            atualizarTarefa(tarefa);
        } else {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
    }
}
