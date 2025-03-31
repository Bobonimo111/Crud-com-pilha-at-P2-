package org.william;

import org.william.entities.Tarefa;
import org.william.services.TarefaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarTarefa(scanner, tarefaService);
                    break;
                case 2:
                    listarTarefas(tarefaService);
                    break;
                case 3:
                    buscarTarefaPorId(scanner, tarefaService);
                    break;
                case 4:
                    atualizarTarefa(scanner, tarefaService);
                    break;
                case 5:
                    removerTarefa(scanner, tarefaService);
                    break;
                case 6:
                    marcarComoConcluida(scanner, tarefaService);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Gerenciador de Tarefas (Pilha) ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Buscar Tarefa por ID");
        System.out.println("4. Atualizar Tarefa");
        System.out.println("5. Remover Tarefa");
        System.out.println("6. Marcar como Concluída");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa novaTarefa = new Tarefa(0, descricao);
        service.cadastrarTarefa(novaTarefa);
        System.out.println("✅ Tarefa adicionada à pilha!");
    }

    private static void listarTarefas(TarefaService service) {
        System.out.println("\n=== Tarefas (da base ao topo da pilha) ===");
        if (service.listarTarefas().isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            service.listarTarefas().forEach(t -> System.out.println("- " + t));
        }
    }

    private static void buscarTarefaPorId(Scanner scanner, TarefaService service) {
        System.out.print("Digite o ID da tarefa: ");
        int id = scanner.nextInt();
        Tarefa tarefa = service.buscarTarefa(id);
        System.out.println(tarefa != null ? "🔍 " + tarefa : "⚠️ Tarefa não encontrada!");
    }

    private static void atualizarTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Digite o ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        Tarefa tarefa = service.buscarTarefa(id);

        if (tarefa != null) {
            System.out.print("Nova descrição: ");
            tarefa.setDescricao(scanner.nextLine());
            service.atualizarTarefa(tarefa);
            System.out.println("✏️ Tarefa atualizada!");
        } else {
            System.out.println("⚠️ Tarefa não encontrada!");
        }
    }

    private static void removerTarefa(Scanner scanner, TarefaService service) {
        System.out.print("Digite o ID da tarefa a remover: ");
        int id = scanner.nextInt();
        try {
            service.removerTarefa(id);
            System.out.println("🗑️ Tarefa removida da pilha!");
        } catch (Exception e) {
            System.out.println("⚠️ Erro: " + e.getMessage());
        }
    }

    private static void marcarComoConcluida(Scanner scanner, TarefaService service) {
        System.out.print("Digite o ID da tarefa concluída: ");
        int id = scanner.nextInt();
        try {
            service.marcarComoConcluida(id);
            System.out.println("✔️ Tarefa marcada como concluída!");
        } catch (Exception e) {
            System.out.println("⚠️ Erro: " + e.getMessage());
        }
    }
}