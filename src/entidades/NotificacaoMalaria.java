package entidades;

import entidadesDeDados.*;
import enums.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotificacaoMalaria extends Notificacao {

    public static List<NotificacaoMalaria> todasNotificacoes = new ArrayList<>();

    public NotificacaoMalaria(){
        this.codigo = contadorCodigo++;
    }

    @Override
    public void registrarNotificacao(Scanner sc) {

        System.out.println("=== REGISTRO DE NOTIFICAÇÃO: MALÁRIA ===");

        // --- DADOS GERAIS ---
        DadosGerais dadosGerais = new DadosGerais();
        dadosGerais.setAgravo(Doenca.MALARIA);

        System.out.print("Data da Notificação: ");
        String dataNotificacaoStr = sc.nextLine();
        dadosGerais.setDataNotificacao(LocalDate.parse(dataNotificacaoStr));

        System.out.print("UF: ");
        dadosGerais.setUf(sc.nextLine());

        System.out.print("Município de Notificação: ");
        dadosGerais.setMunicipio(sc.nextLine());

        System.out.print("Unidade de Saúde: ");
        dadosGerais.setUbs(sc.nextLine());

        System.out.print("Data dos primeiros sintomas: ");
        String dataSintomasStr = sc.nextLine();
        dadosGerais.setDataSintomas(LocalDate.parse(dataSintomasStr));

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

        System.out.print("Telefone: ");
        dadosResidenciais.setDdd(sc.nextInt());

        System.out.println("""
                  1 - Urbana
                  2 - Rural
                """);
        System.out.print("Zona (1-2): ");
        dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS EPIDEMIOLÓGICOS ---
        DadosEpidemiologicos dadosEpidemiologicos = new DadosEpidemiologicos();

        System.out.print("Data da Investigação: ");
        String dataInvestigacaoStr = sc.nextLine();
        dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(dataInvestigacaoStr));

        System.out.print("Ocupação: ");
        dadosEpidemiologicos.setOcupacao(sc.nextLine());
        System.out.println(""" 
                  1 - Agricultura
                  2 - Pecuária
                  3 - Doméstica
                  4 - Turismo
                  5 - Garimpo
                  6 - Extrativismo vegetal
                  7 - Cacapesca
                  8 - Construção barragens
                  9 - Mineração
                  10 - Viajante
                  11 - Motorista
                  12 - Outros
              """);
        System.out.print("Atividade últimos 15 dias (1-12): ");
        dadosEpidemiologicos.setAtividade(AtividadesUltimos15Dias.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("""
                  1 - BP
                  2 - BA
                  3 - LVC
                  4 - IGNORADO
              """);
        System.out.print("Tipo de lâmina (1-4): ");
        dadosEpidemiologicos.setTipoLamina(TiposLamina.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("""
                  1 - Com sintomas
                  2 - Sem sintomas
              """);
        System.out.print("Sintomas (1-2): ");
        dadosEpidemiologicos.setSintomas(Sintomas.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Data do exame: ");
        String dataExameStr = sc.nextLine();
        dadosEpidemiologicos.setDataExame(LocalDate.parse(dataExameStr));

        System.out.println("""
                  1 - Positivo
                  2 - Negativo
                  3 - Indeterminado
              """);
        System.out.print("Resultado do exame (1-3): ");
        dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Parasitos por mm³: ");
        dadosEpidemiologicos.setParasitasMetroCubico(sc.nextFloat());

        System.out.println("""
                  1 - Menor que meia cruz
                  2 - Meia cruz
                  3 - Uma cruz
                  4 - Duas cruzes
                  5 - Três cruzes
                  6 - Quatro cruzes  
              """);
        System.out.print("Parasitemia (1-6): ");
        dadosEpidemiologicos.setParasitemia(Parasitemia.values()[sc.nextInt() - 1]);
        sc.nextLine();

        // --- DADOS DO TRATAMENTO ---
        DadosTratamento dadosTratamento = new DadosTratamento();

        System.out.println("""
                  1 - Pv Cloroquina Primaquina
                  2 - Pf Quinina Doxiciclina Primaquina
                  3 - Mistas Pv Pf Mefloquina Primaquina
                  4 - Pm Cloroquina
                  5 - Pv Criancas Vomitos
                  6 - Pf Mefloquina Primaquina
                  7 - Pf Quinina 7 Dias
                  8 - Pf Criancas Artesunato Retal
                  9 - Mistas Pv Pf Quinina 3 Dias
                  10 - Prevencao Recaida Pv
                  11 - Malaria Grave Complicada
                  12 - Pf Artemeter Lumerfantrina
                  13 - Outro
               """);
        System.out.print("Esquema de tratamento (1-13): ");
        dadosTratamento.setEsquemaTratamento(EsquemaTratamento.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("Data de início do tratamento: ");
        String dataInicioStr = sc.nextLine();
        dadosTratamento.setDataInicioTratamento(LocalDate.parse(dataInicioStr));

        // --- CONCLUSÃO / ENCERRAMENTO ---
        ConclusaoEncerramento conclusaoEncerramento = new ConclusaoEncerramento();

        System.out.println("""
                  1 - Caso confirmado
                  2 - Caso descartado
              """);
        System.out.print("Classificação final (1-2): ");
        conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.println("""
                   1 - Sim
                   2 - Não
                   3 - Indeterminado
                """);
        System.out.print("Caso autóctone (1-3): ");
        conclusaoEncerramento.setAutoctone(Autoctone.values()[sc.nextInt() - 1]);
        sc.nextLine();

        System.out.print("UF provável de infecção: ");
        conclusaoEncerramento.setProvavelUFinfeccao(sc.nextLine());

        System.out.print("Município provável de infecção: ");
        conclusaoEncerramento.setProvavelMunicipioInfeccao(sc.nextLine());

        System.out.print("Data de encerramento: ");
        String dataEncerramentoStr = sc.nextLine();
        conclusaoEncerramento.setDataEncerramento(LocalDate.parse(dataEncerramentoStr));

        System.out.println("\nNotificação de MALÁRIA registrada com sucesso!");
        todasNotificacoes.add(this);
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

                System.out.println("\nResultados da consulta pelo nome: " + nome);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosIndividuais.getNome().equalsIgnoreCase(nome)) {
                        System.out.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    System.out.println("Nenhuma notificação encontrada para o paciente: " + nome);
                } else {
                    System.out.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 2 -> {
                System.out.print("Digite o bairro: ");
                String bairro = sc.nextLine();

                System.out.println("\nResultados da consulta pelo bairro: " + bairro);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosResidenciais.getBairro().equalsIgnoreCase(bairro)) {
                        System.out.println("->" + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    System.out.println("Nenhuma notificação encontrada para o bairro: " + bairro);
                } else {
                    System.out.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 3 -> {
                System.out.print("Digite a data inicial (AAAA-MM-DD): ");
                LocalDate inicio = LocalDate.parse(sc.nextLine());

                System.out.print("Digite a data final (AAAA-MM-DD): ");
                LocalDate fim = LocalDate.parse(sc.nextLine());

                System.out.println("\nResultados da consulta por período: " + inicio + " a " + fim);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    LocalDate data = n.dadosGerais.getDataNotificacao();
                    if ((data.isEqual(inicio) || data.isAfter(inicio)) &&
                            (data.isEqual(fim) || data.isBefore(fim))) {
                        System.out.println("->" + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + data);
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    System.out.println("Nenhuma notificação encontrada no período especificado.");
                } else {
                    System.out.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 4 -> {
                System.out.println("""
                             Opções de agravo:
                             +--------------+
                             | MALARIA      |
                             | HANSENIASE   |
                             | TUBERCULOSE  |
                             +--------------+  
                        """);
                System.out.print("Digite o agravo: ");
                String doenca = sc.nextLine().toUpperCase();
                Doenca agravo = Doenca.valueOf(doenca);

                System.out.println("\nResultados da consulta por agravo: " + agravo);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosGerais.getAgravo() == agravo) {
                        System.out.println("- " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    System.out.println("Nenhuma notificação encontrada para o agravo: " + agravo);
                } else {
                    System.out.println("Total de notificações encontradas: " + encontrados);
                }
            }
            default -> System.out.println("Opção inválida!");
        }

    }

    @Override
    public void gerarRelatorio() {
        System.out.println("\n=== RELATÓRIO ESTATÍSTICO DE MALÁRIA ===");

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
        System.out.println("Malária: " + totalAgravo);

        System.out.println("\nTotal de notificações por bairro:");
        for (NotificacaoMalaria n : todasNotificacoes) {
            System.out.println("-> " + n.dadosResidenciais.getBairro());
        }

        System.out.println("\nTotal de notificações por sexo:");
        for (NotificacaoMalaria n : todasNotificacoes) {
            if (n.dadosIndividuais.getSexo() == Sexo.M) totalSexoM++;
            if (n.dadosIndividuais.getSexo() == Sexo.F) totalSexoF++;
        }
        System.out.println("Masculino: " + totalSexoM);
        System.out.println("Feminino: " + totalSexoF);

        System.out.println("\nTotal de notificações por idade: ");
        for(NotificacaoMalaria n : todasNotificacoes){
            if(n.dadosIndividuais.getIdade() >= 0 && n.dadosIndividuais.getIdade() <= 18){
                criancaAdolescente++;
            } else if (n.dadosIndividuais.getIdade() > 18 && n.dadosIndividuais.getIdade() <= 64) {
                adulto++;
            } else {
                idoso++;
            }
            System.out.println("Total de crianças e adolescentes: " + criancaAdolescente);
            System.out.println("Total de Adultos: " + adulto);
            System.out.println("Total de idosos: " + idoso);
        }

        System.out.println("\nTotal de notificações por raça/cor:");
        for (NotificacaoMalaria n : todasNotificacoes) {
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
        for (NotificacaoMalaria n : todasNotificacoes) {
            System.out.println("- " + n.dadosIndividuais.getEscolaridade());
        }

        System.out.println("\nRelatório gerado!");
    }
}
