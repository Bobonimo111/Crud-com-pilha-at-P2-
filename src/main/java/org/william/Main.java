package org.william;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MinhaPilha<Integer> minhaPilha = new MinhaPilha<>();

        Scanner sc = new Scanner(System.in);


//        System.out.println("escolha uma opção abaixo");
//        System.out.println(" 1. adicionar\n 2. mostrar o topo\n 3. retirar do topo\n 4. está vazia?\n 5. tamanho\n 6. sair\n");

        int opcao = 0xffffffff;


        while(opcao != 6){

            System.out.println("escolha uma opção abaixo");
            System.out.println(" 1. adicionar\n 2. mostrar o topo\n 3. retirar do topo\n 4. está vazia?\n 5. tamanho\n 6. sair\n");
            if(opcao != -1){
                System.out.println("escolha um novo valor");
            }
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.print("adicione um valor ");
                    minhaPilha.adicionar(sc.nextInt());
                    break;

                case 2:
                    System.out.print("topo: ");
                    System.out.println(minhaPilha.topo());
                    break;

                case 3:
                    System.out.println(minhaPilha.tirarDoTopo());
                    break;

                case 4:
                    System.out.print("esta vazia? ");
                    System.out.println(minhaPilha.estaVazia());
                    break;

                case 5:
                    System.out.print("tamanho: ");
                    System.out.println(minhaPilha.tamanho());
                    break;

                default:
                    break;
            }


        }
//
//        minhaPilha.adicionar(10);
//
//        System.out.println("minha pilha esta vazia?");
//        System.out.println(minhaPilha.estaVazia());
//
//        System.out.println("qual o ultimo item?");
//        System.out.println(minhaPilha.topo());
//
//        minhaPilha.adicionar(20);
//
//        System.out.println("e agora, qual o ultimo item?");
//        System.out.println(minhaPilha.topo());
//
//
//        System.out.println("qual o tamanho?");
//        System.out.println(minhaPilha.tamanho());
//
//        minhaPilha.tirarDoTopo();
//
//        System.out.println("tirei o ultimo, qual fica agora?");
//        System.out.println(minhaPilha.topo());
//
//        System.out.println("qual o tamanho?");
//        System.out.println(minhaPilha.tamanho());
    }
}