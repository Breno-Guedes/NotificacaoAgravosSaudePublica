import enums.*;
import entidades.Notificacao;
import entidades.NotificacaoHanseniase;
import entidades.NotificacaoMalaria;
import entidades.NotificacaoTuberculose;
import util.GerenciadorDeArquivos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeArquivos.carregarNotificacoes();

        Scanner sc = new Scanner(System.in);
        int opcaoInt = 4;

        do {
            exibirMenu();
            String opcao = sc.nextLine().trim();

            if (opcao.isEmpty()) {
                System.out.println("\nCampo vazio! Tente novamente.");
                continue;
            }

            try {
                opcaoInt = Integer.parseInt(opcao);

                switch (opcaoInt) {
                    case 1 -> registrarNotificacao(sc);
                    case 2 -> consultarNotificacao(sc);
                    case 3 -> gerarRelatorio(sc);
                    case 0 -> System.out.println("\nEncerrando o sistema...");
                    default -> {
                        System.out.println("\nOpção inválida! Digite uma opção válida do menu.");
                        opcaoInt = 4;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nEntrada inválida! Digite apenas números correspondentes ao menu.");
                opcaoInt = 4;
            }

        } while (opcaoInt != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE NOTIFICAÇÃO DE AGRAVOS DE SAÚDE PÚBLICA    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("1 - Registrar notificação");
        System.out.println("2 - Consultar notificação");
        System.out.println("3 - Gerar relatório");
        System.out.println("0 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static void registrarNotificacao(Scanner sc) {
        System.out.println("\n=== SELECIONE O TIPO DE AGRAVO ===");
        System.out.println("1 - Malária");
        System.out.println("2 - Hanseníase");
        System.out.println("3 - Tuberculose");
        System.out.print("Escolha uma opção: ");

        String entrada = sc.nextLine().trim();
        int tipoAgravo;

        try {
            tipoAgravo = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida! Digite apenas números.");
            return;
        }

        switch (tipoAgravo) {
            case 1 -> new NotificacaoMalaria().registrarNotificacao(sc);
            case 2 -> new NotificacaoHanseniase().registrarNotificacao(sc);
            case 3 -> new NotificacaoTuberculose().registrarNotificacao(sc);
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void consultarNotificacao(Scanner sc) {
        System.out.println("\n=== SELECIONE O TIPO DE AGRAVO PARA CONSULTA ===");
        System.out.println("1 - Malária");
        System.out.println("2 - Hanseníase");
        System.out.println("3 - Tuberculose");
        System.out.print("Escolha uma opção: ");

        String entrada = sc.nextLine().trim();
        int tipoAgravo;

        try {
            tipoAgravo = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida! Digite apenas números.");
            return;
        }

        switch (tipoAgravo) {
            case 1 -> Notificacao.consultarNotificacoes(sc, Doenca.MALARIA);
            case 2 -> Notificacao.consultarNotificacoes(sc, Doenca.HANSENIASE);
            case 3 -> Notificacao.consultarNotificacoes(sc, Doenca.TUBERCULOSE);
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void gerarRelatorio(Scanner sc) {
        System.out.println("\n=== SELECIONE O TIPO DE AGRAVO PARA RELATÓRIO ===");
        System.out.println("1 - Malária");
        System.out.println("2 - Hanseníase");
        System.out.println("3 - Tuberculose");
        System.out.print("Escolha uma opção: ");

        String entrada = sc.nextLine().trim();
        int tipoAgravo;

        try {
            tipoAgravo = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida! Digite apenas números.");
            return;
        }

        switch (tipoAgravo) {
            case 1 -> Notificacao.gerarRelatorio(Doenca.MALARIA);
            case 2 -> Notificacao.gerarRelatorio(Doenca.HANSENIASE);
            case 3 -> Notificacao.gerarRelatorio(Doenca.TUBERCULOSE);
            default -> System.out.println("Opção inválida!");
        }
    }
}