/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ordenacaovetores;

import java.util.ArrayList;
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

        int opcao = -1;

        while (opcao != 0) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe a sua escolha!\n"
                    + "[1] - Ordenação por Inserção \n"
                    + "[2] - Ordenação por Seleção \n"
                    + "[3] - Ordenação Bolha \n"
                    + "[0] - Sair \n"));

            if (opcao == 1) {
                solicitacaoDados();
                exibirVetorSemOrdenacao();
                ordenacaoInsercao();
            } else if (opcao == 2) {
                solicitacaoDados();
                exibirVetorSemOrdenacao();
                ordenacaoSelecao();
            } else if (opcao == 3) {
                //ord; bolha

            }
        }
    }

    public static void solicitacaoDados() {
        Scanner entrada = new Scanner(System.in);

        qtddElementos = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do Vetor"));
        vetor = new int[qtddElementos];
        vetorSemOrdenacao = new int[qtddElementos];

        for (int i = 0; i < qtddElementos; i++) {

            System.out.printf(" Digite um número: ");
            vetor[i] = entrada.nextInt();
            vetorSemOrdenacao[i] = vetor[i];
            chave = vetor[i];

        }

    }

    public static void exibirVetorSemOrdenacao() {

        System.out.println("\nVETOR INFORMADO PELO USUÁRIO: ");

        for (i = 0; i < vetorSemOrdenacao.length; i++) {

            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetorSemOrdenacao[i]);

        }

    }

    public static void ordenacaoInsercao() {

        System.out.println("\n\nVETOR ORDENADO: ");
        Scanner entrada = new Scanner(System.in);
        for (int i = 1; i < qtddElementos; i++) {

            chave = vetor[i];

            for (j = i - 1; (j >= 0 && vetor[j] > chave); j--) {

                vetor[j + 1] = vetor[j];

            }
            vetor[j + 1] = chave;
        }

        for (int i = 0; i <= vetor.length - 1; i++) {
            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetor[i]);
        }

    }

    public static void ordenacaoSelecao() {

        for (int i = 0; i < vetor.length; i++) {
            int menor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }

            }
            troca(vetor, i, menor);

        }
            System.out.println("\n\nVETOR ORDENADO: ");
        for (int i = 0; i <= vetor.length - 1; i++) {
            System.out.println("Na posição: [" + i + "] Temos o valor = " + vetor[i]);
            
    }
    }

    public static void troca(int[] vetor, int i, int menor) {
        int aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;

    }

}

