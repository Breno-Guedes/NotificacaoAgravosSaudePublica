package entidades;

import entidadesDeDados.*;
import enums.*;
import java.time.LocalDate;
import java.util.*;

public class NotificacaoTuberculose extends Notificacao {

    public static List<NotificacaoTuberculose> todasNotificacoes = new ArrayList<>();

    public NotificacaoTuberculose() {
        this.codigo = contadorCodigo++;
    }

    @Override
    public void registrarNotificacao(Scanner sc) {
        System.out.println("=== REGISTRO DE NOTIFICAÇÃO: TUBERCULOSE ===");

        // --- DADOS GERAIS ---
        this.dadosGerais = new DadosGerais();
        this.dadosGerais.setAgravo(Doenca.TUBERCULOSE);

        System.out.print("Data da Notificação (AAAA-MM-DD): ");
        this.dadosGerais.setDataNotificacao(LocalDate.parse(sc.nextLine()));

        System.out.print("UF: ");
        this.dadosGerais.setUf(sc.nextLine());

        System.out.print("Município de Notificação: ");
        this.dadosGerais.setMunicipio(sc.nextLine());

        System.out.print("Unidade de Saúde: ");
        this.dadosGerais.setUbs(sc.nextLine());

        System.out.print("Data dos primeiros sintomas (AAAA-MM-DD): ");
        this.dadosGerais.setDataSintomas(LocalDate.parse(sc.nextLine()));

        // --- DADOS INDIVIDUAIS ---
        this.dadosIndividuais = new DadosIndividuais();

        System.out.print("Nome do paciente: ");
        this.dadosIndividuais.setNome(sc.nextLine());

        System.out.print("Data de nascimento: ");
        this.dadosIndividuais.setDataNascimento(sc.nextLine());

        while (true) {
            System.out.print("Idade: ");
            this.dadosIndividuais.setIdade(sc.nextInt());
            sc.nextLine();

            if(this.dadosIndividuais.getIdade() > 0 && this.dadosIndividuais.getIdade() <= 115){
                break;
            } else {
                System.out.println("Idade inválida, tente novamente!");
            }
        }

        System.out.print("Sexo (M/F): ");
        this.dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("""
                1 - 1º trimestre
                2 - 2º trimestre
                3 - 3º trimestre
                4 - Idade gestacional ignorada
                5 - Não gestante
                """);
        System.out.print("Gestante (1-5): ");
        this.dadosIndividuais.setGestante(Gestante.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("""
                1 - Branca
                2 - Preta
                3 - Parda
                4 - Amarela
                5 - Indígena
                6 - Não informado
                """);
        System.out.print("Raça/Cor (1-6): ");
        this.dadosIndividuais.setRacaCor(RacaCor.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("""
                1 - Fundamental incompleto
                2 - Fundamental completo
                3 - Médio incompleto
                4 - Médio completo
                5 - Superior incompleto
                6 - Superior completo
                7 - Pós-graduação
                8 - Mestrado
                9 - Doutorado
                10 - Não informado
                """);
        System.out.print("Escolaridade (1-10): ");
        this.dadosIndividuais.setEscolaridade(Escolaridade.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Nome da mãe: ");
        this.dadosIndividuais.setNomeMae(sc.nextLine());

        // --- DADOS RESIDENCIAIS ---
        this.dadosResidenciais = new DadosResidenciais();

        System.out.print("UF de residência: ");
        this.dadosResidenciais.setUf(sc.nextLine());

        System.out.print("Município de residência: ");
        this.dadosResidenciais.setMunicipio(sc.nextLine());

        System.out.print("Bairro: ");
        this.dadosResidenciais.setBairro(sc.nextLine());

        System.out.print("Logradouro: ");
        this.dadosResidenciais.setLogradouro(sc.nextLine());

        System.out.print("Número: ");
        this.dadosResidenciais.setNumero(sc.nextLine());

        System.out.print("CEP: ");
        this.dadosResidenciais.setCep(sc.nextInt());
        sc.nextLine();

        System.out.print("DDD: ");
        this.dadosResidenciais.setDdd(sc.nextInt());
        sc.nextLine();

        System.out.println("""
                1 - Urbana
                2 - Rural
                """);
        System.out.print("Zona (1-2): ");
        this.dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS EPIDEMIOLÓGICOS ---
        this.dadosEpidemiologicos = new DadosEpidemiologicos();

        System.out.print("Data da Investigação (AAAA-MM-DD): ");
        this.dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(sc.nextLine()));

        System.out.print("Ocupação: ");
        this.dadosEpidemiologicos.setOcupacao(sc.nextLine());

        System.out.print("Data do exame (AAAA-MM-DD): ");
        this.dadosEpidemiologicos.setDataExame(LocalDate.parse(sc.nextLine()));

        System.out.println("""
                1 - Positivo
                2 - Negativo
                3 - Indeterminado
                """);
        System.out.print("Resultado do exame (1-3): ");
        this.dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS DO TRATAMENTO ---
        this.dadosTratamento = new DadosTratamento();

        System.out.print("Data de início do tratamento (AAAA-MM-DD): ");
        this.dadosTratamento.setDataInicioTratamento(LocalDate.parse(sc.nextLine()));

        // --- CONCLUSÃO / ENCERRAMENTO ---
        this.conclusaoEncerramento = new ConclusaoEncerramento();

        System.out.println("""
                1 - Caso confirmado
                2 - Caso descartado
                """);
        System.out.print("Classificação final (1-2): ");
        this.conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Data de encerramento (AAAA-MM-DD): ");
        this.conclusaoEncerramento.setDataEncerramento(LocalDate.parse(sc.nextLine()));

        todasNotificacoes.add(this);
        System.out.println("\nNotificação de TUBERCULOSE registrada com sucesso!");
    }

    @Override
    public void consultarNotificacao(Scanner sc) {
        if (todasNotificacoes.isEmpty()) {
            System.out.println("Não há notificações registradas.");
            return;
        }

        System.out.println("\n=== CONSULTAR NOTIFICAÇÕES ===");
        System.out.println("1 - Consultar pelo nome do paciente");
        System.out.println("2 - Consultar por bairro");
        System.out.println("3 - Consultar por período");
        System.out.println("4 - Consultar por agravo");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Digite o nome do paciente: ");
                String nome = sc.nextLine();
                int encontrados = 0;
                for (NotificacaoTuberculose n : todasNotificacoes) {
                    if (n.dadosIndividuais.getNome().equalsIgnoreCase(nome)) {
                        System.out.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }
                System.out.println(encontrados == 0 ? "Nenhuma notificação encontrada." :
                        "Total encontradas: " + encontrados);
            }

            case 2 -> {
                System.out.print("Digite o bairro: ");
                String bairro = sc.nextLine();
                int encontrados = 0;
                for (NotificacaoTuberculose n : todasNotificacoes) {
                    if (n.dadosResidenciais.getBairro().equalsIgnoreCase(bairro)) {
                        System.out.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }
                System.out.println(encontrados == 0 ? "Nenhuma notificação encontrada." :
                        "Total encontradas: " + encontrados);
            }

            case 3 -> {
                System.out.print("Data inicial (AAAA-MM-DD): ");
                LocalDate inicio = LocalDate.parse(sc.nextLine());
                System.out.print("Data final (AAAA-MM-DD): ");
                LocalDate fim = LocalDate.parse(sc.nextLine());

                int encontrados = 0;
                for (NotificacaoTuberculose n : todasNotificacoes) {
                    LocalDate data = n.dadosGerais.getDataNotificacao();
                    if ((data.isEqual(inicio) || data.isAfter(inicio)) &&
                            (data.isEqual(fim) || data.isBefore(fim))) {
                        System.out.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data: " + data);
                        encontrados++;
                    }
                }
                System.out.println(encontrados == 0 ? "Nenhuma notificação no período." :
                        "Total encontradas: " + encontrados);
            }

            case 4 -> {
                System.out.print("Digite o agravo (MALARIA, HANSENIASE, TUBERCULOSE): ");
                Doenca agravo = Doenca.valueOf(sc.nextLine().toUpperCase());
                int encontrados = 0;
                for (NotificacaoTuberculose n : todasNotificacoes) {
                    if (n.dadosGerais.getAgravo() == agravo) {
                        System.out.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }
                System.out.println(encontrados == 0 ? "Nenhuma notificação encontrada." :
                        "Total encontradas: " + encontrados);
            }

            default -> System.out.println("Opção inválida!");
        }
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("\n=== RELATÓRIO ESTATÍSTICO DE TUBERCULOSE ===");

        int totalAgravo = 0;
        int totalSexoM = 0;
        int totalSexoF = 0;
        int criancaAdolescente = 0;
        int adulto = 0;
        int idoso = 0;
        int totalBranca = 0;
        int totalPreta = 0;
        int totalParda = 0;
        int totalAmarela = 0;
        int totalIndigena = 0;
        int totalNaoInformadoRaca = 0;

        System.out.println("\nTotal de notificações por agravo:");
        totalAgravo = todasNotificacoes.size();
        System.out.println("Tuberculose: " + totalAgravo);

        System.out.println("\nTotal de notificações por bairro:");
        for (NotificacaoTuberculose n : todasNotificacoes) {
            System.out.println("-> " + n.dadosResidenciais.getBairro());
        }

        System.out.println("\nTotal de notificações por sexo:");
        for (NotificacaoTuberculose n : todasNotificacoes) {
            if (n.dadosIndividuais.getSexo() == Sexo.M) totalSexoM++;
            if (n.dadosIndividuais.getSexo() == Sexo.F) totalSexoF++;
        }
        System.out.println("Masculino: " + totalSexoM);
        System.out.println("Feminino: " + totalSexoF);

        System.out.println("\nTotal de notificações por idade: ");
        for(NotificacaoTuberculose n : todasNotificacoes){
            if(n.dadosIndividuais.getIdade() >= 0 && n.dadosIndividuais.getIdade() <= 18){
                criancaAdolescente++;
            } else if (n.dadosIndividuais.getIdade() > 18 && n.dadosIndividuais.getIdade() <= 64) {
                adulto++;
            } else {
                idoso++;
            }
        }

        System.out.println("Total de crianças e adolescentes: " + criancaAdolescente);
        System.out.println("Total de Adultos: " + adulto);
        System.out.println("Total de idosos: " + idoso);

        System.out.println("\nTotal de notificações por raça/cor:");
        for (NotificacaoTuberculose n : todasNotificacoes) {
            switch (n.dadosIndividuais.getRacaCor()) {
                case BRANCA -> totalBranca++;
                case PRETA -> totalPreta++;
                case PARDA -> totalParda++;
                case AMARELA -> totalAmarela++;
                case INDIGENA -> totalIndigena++;
                case NAO_INFORMADO -> totalNaoInformadoRaca++;
            }
        }

        System.out.println("Branca: " + totalBranca);
        System.out.println("Preta: " + totalPreta);
        System.out.println("Parda: " + totalParda);
        System.out.println("Amarela: " + totalAmarela);
        System.out.println("Indígena: " + totalIndigena);
        System.out.println("Não informado: " + totalNaoInformadoRaca);

        System.out.println("\nTotal de notificações por escolaridade:");
        for (NotificacaoTuberculose n : todasNotificacoes) {
            System.out.println("-> " + n.dadosIndividuais.getEscolaridade());
        }

        System.out.println("\nRelatório gerado!");
    }
}
