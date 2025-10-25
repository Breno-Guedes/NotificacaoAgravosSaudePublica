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
        DadosGerais dadosGerais = new DadosGerais();
        dadosGerais.setAgravo(Doenca.TUBERCULOSE);

        System.out.print("Data da Notificação (AAAA-MM-DD): ");
        dadosGerais.setDataNotificacao(LocalDate.parse(sc.nextLine()));

        System.out.print("UF: ");
        dadosGerais.setUf(sc.nextLine());

        System.out.print("Município de Notificação: ");
        dadosGerais.setMunicipio(sc.nextLine());

        System.out.print("Unidade de Saúde: ");
        dadosGerais.setUbs(sc.nextLine());

        System.out.print("Data dos primeiros sintomas (AAAA-MM-DD): ");
        dadosGerais.setDataSintomas(LocalDate.parse(sc.nextLine()));

        // --- DADOS INDIVIDUAIS ---
        DadosIndividuais dadosIndividuais = new DadosIndividuais();

        System.out.print("Nome do paciente: ");
        dadosIndividuais.setNome(sc.nextLine());

        System.out.print("Data de nascimento: ");
        dadosIndividuais.setDataNascimento(sc.nextLine());

        while (true) {
            System.out.print("Idade: ");
            dadosIndividuais.setIdade(sc.nextInt());
            sc.nextLine();

            if(dadosIndividuais.getIdade() > 0 && dadosIndividuais.getIdade() <= 115){
                break;
            } else {
                System.out.println("Idade inválida, tente novamente!");
            }
        }

        System.out.print("Sexo (M/F): ");
        dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("""
                1 - 1º trimestre
                2 - 2º trimestre
                3 - 3º trimestre
                4 - Idade gestacional ignorada
                5 - Não gestante
                """);
        System.out.print("Gestante (1-5): ");
        dadosIndividuais.setGestante(Gestante.values()[sc.nextInt() - 1]);
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
        dadosIndividuais.setRacaCor(RacaCor.values()[sc.nextInt() - 1]);
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
        dadosIndividuais.setEscolaridade(Escolaridade.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Nome da mãe: ");
        dadosIndividuais.setNomeMae(sc.nextLine());

        // --- DADOS RESIDENCIAIS ---
        DadosResidenciais dadosResidenciais = new DadosResidenciais();

        System.out.print("UF de residência: ");
        dadosResidenciais.setUf(sc.nextLine());

        System.out.print("Município de residência: ");
        dadosResidenciais.setMunicipio(sc.nextLine());

        System.out.print("Bairro: ");
        dadosResidenciais.setBairro(sc.nextLine());

        System.out.print("Logradouro: ");
        dadosResidenciais.setLogradouro(sc.nextLine());

        System.out.print("Número: ");
        dadosResidenciais.setNumero(sc.nextLine());

        System.out.print("CEP: ");
        dadosResidenciais.setCep(sc.nextInt());
        sc.nextLine();

        System.out.print("DDD: ");
        dadosResidenciais.setDdd(sc.nextInt());
        sc.nextLine();

        System.out.println("""
                1 - Urbana
                2 - Rural
                """);
        System.out.print("Zona (1-2): ");
        dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS EPIDEMIOLÓGICOS ---
        DadosEpidemiologicos dadosEpidemiologicos = new DadosEpidemiologicos();

        System.out.print("Data da Investigação (AAAA-MM-DD): ");
        dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(sc.nextLine()));

        System.out.print("Ocupação: ");
        dadosEpidemiologicos.setOcupacao(sc.nextLine());

        System.out.print("Data do exame (AAAA-MM-DD): ");
        dadosEpidemiologicos.setDataExame(LocalDate.parse(sc.nextLine()));

        System.out.println("""
                1 - Positivo
                2 - Negativo
                3 - Indeterminado
                """);
        System.out.print("Resultado do exame (1-3): ");
        dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS DO TRATAMENTO ---
        DadosTratamento dadosTratamento = new DadosTratamento();

        System.out.print("Data de início do tratamento (AAAA-MM-DD): ");
        dadosTratamento.setDataInicioTratamento(LocalDate.parse(sc.nextLine()));

        // --- CONCLUSÃO / ENCERRAMENTO ---
        ConclusaoEncerramento conclusaoEncerramento = new ConclusaoEncerramento();

        System.out.println("""
                1 - Caso confirmado
                2 - Caso descartado
                """);
        System.out.print("Classificação final (1-2): ");
        conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Data de encerramento (AAAA-MM-DD): ");
        conclusaoEncerramento.setDataEncerramento(LocalDate.parse(sc.nextLine()));

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

        int total = todasNotificacoes.size();
        int masc = 0, fem = 0;
        int criancaAdolescente = 0, adulto = 0, idoso = 0;
        Map<String, Integer> bairros = new HashMap<>();

        for (NotificacaoTuberculose n : todasNotificacoes) {
            if (n.dadosIndividuais.getSexo() == Sexo.M) masc++;
            else fem++;

            int idade = n.dadosIndividuais.getIdade();
            if (idade <= 18) criancaAdolescente++;
            else if (idade <= 64) adulto++;
            else idoso++;

            bairros.merge(n.dadosResidenciais.getBairro(), 1, Integer::sum);
        }

        System.out.println("Total de notificações: " + total);
        System.out.println("Sexo Masculino: " + masc);
        System.out.println("Sexo Feminino: " + fem);
        System.out.println("Crianças e adolescentes: " + criancaAdolescente);
        System.out.println("Adultos: " + adulto);
        System.out.println("Idosos: " + idoso);

        System.out.println("\nTotal por bairro:");
        bairros.forEach((b, qtd) -> System.out.println("- " + b + ": " + qtd));

        System.out.println("\nRelatório finalizado com sucesso!");
    }
}
