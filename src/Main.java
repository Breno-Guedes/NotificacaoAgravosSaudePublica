import entidades.*;
import java.util.Scanner;
import GerenciadorDeArquivos.GerenciadorDeArquivos;


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

        Notificacao notificacao;
        switch (tipoAgravo) {
            case 1 -> notificacao = new NotificacaoMalaria();
            case 2 -> notificacao = new NotificacaoHansieniase();
            case 3 -> notificacao = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        notificacao.registrarNotificacao(sc);
    }

    private static void consultarNotificacao(Scanner sc) {

        GerenciadorDeArquivos.carregarNotificacoes();

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

        Notificacao notificacaoConsulta;
        switch (tipoAgravo) {
            case 1 -> notificacaoConsulta = new NotificacaoMalaria();
            case 2 -> notificacaoConsulta = new NotificacaoHansieniase();
            case 3 -> notificacaoConsulta = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        notificacaoConsulta.consultarNotificacao(sc);
    }

    private static void gerarRelatorio(Scanner sc) {

        GerenciadorDeArquivos.carregarNotificacoes();

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

        Notificacao notificacaoRelatorio;
        switch (tipoAgravo) {
            case 1 -> notificacaoRelatorio = new NotificacaoMalaria();
            case 2 -> notificacaoRelatorio = new NotificacaoHansieniase();
            case 3 -> notificacaoRelatorio = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        notificacaoRelatorio.gerarRelatorio();
    }
}