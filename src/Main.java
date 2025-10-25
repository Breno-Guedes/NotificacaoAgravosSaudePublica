import entidades.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> registrarNotificacao(sc);
                case 2 -> consultarNotificacao(sc);
                case 3 -> gerarRelatorio(sc);
                case 0 -> System.out.println("\nEncerrando o sistema...");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 0);

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
        
        int tipoAgravo = sc.nextInt();
        sc.nextLine(); // Consumir quebra de linha

        Notificacao notificacao = null;

        switch (tipoAgravo) {
            case 1 -> notificacao = new NotificacaoMalaria();
            case 2 -> notificacao = new NotificacaoHansieniase();
            case 3 -> notificacao = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        try {
            notificacao.registrarNotificacao(sc);
        } catch (Exception e) {
            System.out.println("\nErro ao registrar notificação: " + e.getMessage());
            System.out.println("Por favor, verifique os dados informados.");
        }
    }

    private static void consultarNotificacao(Scanner sc) {
        System.out.println("\n=== SELECIONE O TIPO DE AGRAVO PARA CONSULTA ===");
        System.out.println("1 - Malária");
        System.out.println("2 - Hanseníase");
        System.out.println("3 - Tuberculose");
        System.out.print("Escolha uma opção: ");
        
        int tipoAgravo = sc.nextInt();
        sc.nextLine(); // Consumir quebra de linha

        Notificacao notificacao = null;

        switch (tipoAgravo) {
            case 1 -> notificacao = new NotificacaoMalaria();
            case 2 -> notificacao = new NotificacaoHansieniase();
            case 3 -> notificacao = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        try {
            notificacao.consultarNotificacao(sc);
        } catch (Exception e) {
            System.out.println("\nErro ao consultar notificação: " + e.getMessage());
        }
    }

    private static void gerarRelatorio(Scanner sc) {
        System.out.println("\n=== SELECIONE O TIPO DE AGRAVO PARA RELATÓRIO ===");
        System.out.println("1 - Malária");
        System.out.println("2 - Hanseníase");
        System.out.println("3 - Tuberculose");
        System.out.print("Escolha uma opção: ");
        
        int tipoAgravo = sc.nextInt();
        sc.nextLine(); // Consumir quebra de linha

        Notificacao notificacao = null;

        switch (tipoAgravo) {
            case 1 -> notificacao = new NotificacaoMalaria();
            case 2 -> notificacao = new NotificacaoHansieniase();
            case 3 -> notificacao = new NotificacaoTuberculose();
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        try {
            notificacao.gerarRelatorio();
        } catch (Exception e) {
            System.out.println("\nErro ao gerar relatório: " + e.getMessage());
        }
    }
}
