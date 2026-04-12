package com.financeirofacil;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static GastoService servico = new GastoService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== FinanceiroFacil ===");

        int opcao = -1;
        while (opcao != 5) {
            System.out.println("1 - Adicionar gasto");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Ver por categoria");
            System.out.println("5 - Sair");
            System.out.print(">> ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("opcao invalida\n");
                continue;
            }

            switch (opcao) {
                case 1 -> adicionar();
                case 2 -> listar();
                case 3 -> remover();
                case 4 -> porCategoria();
                case 5 -> System.out.println("tchau!");
                default -> System.out.println("opcao invalida\n");
            }
        }
    }

    private static void adicionar() {
        System.out.print("descricao: ");
        String descricao = sc.nextLine();

        System.out.print("valor: ");
        double valor;
        try {
            valor = Double.parseDouble(sc.nextLine().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("valor invalido\n");
            return;
        }

        System.out.print("categoria: ");
        String categoria = sc.nextLine();

        try {
            servico.adicionar(descricao, valor, categoria);
            System.out.println("adicionado!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("erro: " + e.getMessage() + "\n");
        }
    }

    private static void listar() {
        List<Gasto> gastos = servico.listar();
        if (gastos.isEmpty()) {
            System.out.println("nenhum gasto ainda\n");
            return;
        }
        for (Gasto g : gastos) {
            System.out.println(g);
        }
        System.out.printf("total: R$ %.2f\n\n", servico.totalGasto());
    }

    private static void remover() {
        System.out.print("qual ID? ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if (servico.remover(id)) {
                System.out.println("removido!\n");
            } else {
                System.out.println("nao achei esse ID\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID invalido\n");
        }
    }

    private static void porCategoria() {
        System.out.print("qual categoria? ");
        String categoria = sc.nextLine();
        List<Gasto> gastos = servico.buscarPorCategoria(categoria);
        if (gastos.isEmpty()) {
            System.out.println("nada nessa categoria\n");
            return;
        }
        double total = 0;
        for (Gasto g : gastos) {
            System.out.println(g);
            total += g.getValor();
        }
        System.out.printf("total: R$ %.2f\n\n", total);
    }
}
