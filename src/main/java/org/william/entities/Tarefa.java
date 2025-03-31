package org.william.entities;

public class Tarefa {
    private int id;
    private String descricao;
    private boolean concluida;

    public Tarefa() {
    }

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", descricao=" + descricao + ", concluida=" + concluida + "]";
    }
}
