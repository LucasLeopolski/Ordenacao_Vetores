/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ordenacaovetores;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Lucas Leopolski
 */
public class OrdenacaoVetores {

    public static int[] vetor = {};
    public static int[] vetorSemOrdenacao;
    public static int chave, j, i, qtddElementos;
    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        solicitacaoDados();

        int opcao = -1;

        while (opcao != 0) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "[1] - Ordenação por Inserção \n"
                    + "[2] - Ordenação por Seleção \n"
                    + "[3] - Ordenação Bolha \n"
                    + "[4] - Pesquisa Linear \n"
                    + "[5] - Pesquisa Binaria \n"
                    + "[0] - Sair \n"
            ));

            if (opcao == 1) {
                exibirVetorSemOrdenacao();
                ordenacaoInsercao();
            } else if (opcao == 2) {
                exibirVetorSemOrdenacao();
                ordenacaoSelecao();
            } else if (opcao == 3) {
                exibirVetorSemOrdenacao();
                bubleSort();
            } else if (opcao == 4) {

                int pesquisa = Integer.parseInt(
                        JOptionPane.showInputDialog("Informe o número a ser pesquisado: "));

                int posicao = pesquisaLinear(pesquisa, vetor);

                if (posicao >= 0) {
                    System.out.println("O número " + pesquisa + " está localizado na posição: " + posicao);

                } else {
                    System.out.println("O Elemento " + pesquisa + " não foi localizado na lista");
                }
            } else if (opcao == 5) {
                int pesquisa = Integer.parseInt(
                        JOptionPane.showInputDialog("Informe o número a ser pesquisado: "));
                int posicao = pesquisaBinaria(pesquisa, vetor);
                if (posicao >= 0) {
                    System.out.println("O número " + pesquisa + " está localizado na posição: " + posicao);

                } else {
                    System.out.println("O Elemento " + pesquisa + " não foi localizado na lista");
                }
            }
        }

    }

    public static void solicitacaoDados() {

        Random numerosVetor = new Random();
        qtddElementos = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do Vetor"));
        vetor = new int[qtddElementos];
        vetorSemOrdenacao = new int[qtddElementos];

        for (int i = 0; i < vetor.length; i++) {

            vetor[i] = numerosVetor.nextInt(700000);
            vetorSemOrdenacao[i] = vetor[i];

        }

    }

    public static void exibirVetorSemOrdenacao() {

        System.out.println("\nVETOR INFORMADO PELO USUÁRIO: ");

        for (i = 0; i < vetorSemOrdenacao.length; i++) {

            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetorSemOrdenacao[i]);

        }

    }

    public static void ordenacaoInsercao() {

        long tempoInicial = System.currentTimeMillis();
        System.out.println("\n\nVETOR ORDENADO PELO MÉTODO INSERTIONSORT: ");

        for (int i = 1; i < vetor.length; i++) {

            chave = vetor[i];

            for (j = i - 1; (j >= 0 && vetor[j] > chave); j--) {

                vetor[j + 1] = vetor[j];

            }
            vetor[j + 1] = chave;
        }

        for (int i = 0; i <= vetor.length - 1; i++) {
            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetor[i]);
        }

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\nTEMPO DE EXECUÇÃO DO MÉTODO: " + (tempoFinal - tempoInicial) + " MS");
        System.out.println("\nTEMPO DE EXECUÇÃO: " + (tempoFinal - tempoInicial) / 1000 + " SEGUNDOS");

    }

    public static void ordenacaoSelecao() {
        long tempoInicial = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            int menor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }

            }
            troca(vetor, i, menor);

        }
        System.out.println("\n\nVETOR ORDENADO PELO MÉTODO SELECTIONSORT: ");
        for (int i = 0; i <= vetor.length - 1; i++) {
            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetor[i]);

        }
        long tempoFinal = System.currentTimeMillis();
        System.out.println("\nTEMPO DE EXECUÇÃO DO MÉTODO: " + (tempoFinal - tempoInicial) + " MS");
        System.out.println("\nTEMPO DE EXECUÇÃO: " + (tempoFinal - tempoInicial) / 1000 + " SEGUNDOS");
    }

    public static void troca(int[] vetor, int i, int menor) {
        int aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;

    }

    public static void bubleSort() {
        long tempoInicial = System.currentTimeMillis();

        System.out.println("\nVETOR ORDENADO PELO MÉTODO BUBBLESORT:");
        boolean troca = true;

        while (troca) {
            troca = false;
            for (i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetor[i]);
        }
        long tempoFinal = System.currentTimeMillis();
        System.out.println("\nTEMPO DE EXECUÇÃO DO MÉTODO: " + (tempoFinal - tempoInicial) + " MS");
        System.out.println("\nTEMPO DE EXECUÇÃO: " + (tempoFinal - tempoInicial) / 1000 + " SEGUNDOS");

    }

    public static int pesquisaLinear(int chave, int[] vet) {

        for (int i = 0; i < vetor.length; i++) {
            if (chave == vet[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int chave, int[] vet) {
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;
        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (chave == vet[meio]) {
                return meio;
            }
            if (chave > vet[meio]) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}
