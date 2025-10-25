package entidades;

import entidadesDeDados.*;
import enums.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class NotificacaoMalaria extends Notificacao {

    public static List<NotificacaoMalaria> todasNotificacoes = new ArrayList<>();

    public NotificacaoMalaria() {
        this.codigo = contadorCodigo++;
    }

    @Override
    public void registrarNotificacao(Scanner sc) {

        System.out.println("=== REGISTRO DE NOTIFICAÇÃO: MALÁRIA ===");

        // --- DADOS GERAIS ---
        DadosGerais dadosGerais = new DadosGerais();
        this.dadosGerais = dadosGerais;
        dadosGerais.setAgravo(Doenca.MALARIA);

        while (true) {
            try {
                System.out.print("Data da Notificação: ");
                String dataNotificacaoStr = sc.nextLine();

                if (dataNotificacaoStr.isEmpty()) {
                    System.out.println("O campo Data da Notificação é obrigatório, tente novamente!");
                } else {
                    dadosGerais.setDataNotificacao(LocalDate.parse(dataNotificacaoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            System.out.print("UF: ");
            dadosGerais.setUf(sc.nextLine());

            if (dadosGerais.getUf().isEmpty()) {
                System.out.println("O campo UF é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Município de Notificação: ");
            dadosGerais.setMunicipio(sc.nextLine());

            if (dadosGerais.getMunicipio().isEmpty()) {
                System.out.println("O campo Município de Notificação é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Unidade de Saúde: ");
            dadosGerais.setUbs(sc.nextLine());

            if (dadosGerais.getUbs().isEmpty()) {
                System.out.println("O campo Unidade de Saúde é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Data dos primeiros sintomas: ");
                String dataSintomasStr = sc.nextLine();

                if (dataSintomasStr.isEmpty()) {
                    System.out.println("O campo Data dos primeiros sintomas é obrigatório, tente novamente!");
                } else {
                    dadosGerais.setDataSintomas(LocalDate.parse(dataSintomasStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        // --- DADOS INDIVIDUAIS ---
        DadosIndividuais dadosIndividuais = new DadosIndividuais();
        this.dadosIndividuais = dadosIndividuais;

        while (true) {
            System.out.print("Nome do paciente: ");
            dadosIndividuais.setNome(sc.nextLine());

            if (dadosIndividuais.getNome().isEmpty()) {
                System.out.println("O campo Nome do paciente é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Data de nascimento: ");
                String dataNascimentoStr = sc.nextLine();

                if (dataNascimentoStr.isEmpty()) {
                    System.out.println("O campo Data de nascimento é obrigatório, tente novamente!");
                } else {
                    dadosIndividuais.setDataNascimento(LocalDate.parse(dataNascimentoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.print("Idade: ");
                dadosIndividuais.setIdade(sc.nextInt());
                sc.nextLine();

                if (dadosIndividuais.getIdade() > 0 && dadosIndividuais.getIdade() <= 115) {
                    break;
                } else {
                    System.out.println("Idade inválida, tente novamente!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para idade. Por favor, insira um número.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Sexo (M/F): ");
                dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        if (dadosIndividuais.getSexo() == Sexo.F) {
            while (true) {
                try {
                    System.out.println("\n------------------ GESTANTE ------------------");
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
                    break;
                } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("Opção inválida, tente novamente!");
                    sc.nextLine();
                }
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ RAÇA/COR ------------------");
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
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ ESCOLARIDADE ------------------");
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
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            System.out.print("Nome da mãe: ");
            dadosIndividuais.setNomeMae(sc.nextLine());

            if (dadosIndividuais.getNomeMae().isEmpty()) {
                System.out.println("O campo Nome da mãe é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        // --- DADOS RESIDENCIAIS ---
        DadosResidenciais dadosResidenciais = new DadosResidenciais();
        this.dadosResidenciais = dadosResidenciais;

        while (true) {
            System.out.print("UF de residência: ");
            dadosResidenciais.setUf(sc.nextLine());

            if (dadosResidenciais.getUf().isEmpty()) {
                System.out.println("O campo UF de residência é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Município de residência: ");
            dadosResidenciais.setMunicipio(sc.nextLine());

            if (dadosResidenciais.getMunicipio().isEmpty()) {
                System.out.println("O campo Município de residência é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Bairro: ");
            dadosResidenciais.setBairro(sc.nextLine());

            if (dadosResidenciais.getBairro().isEmpty()) {
                System.out.println("O campo Bairro é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Logradouro: ");
            dadosResidenciais.setLogradouro(sc.nextLine());

            if (dadosResidenciais.getLogradouro().isEmpty()) {
                System.out.println("O campo Logradouro é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Número: ");
            dadosResidenciais.setNumero(sc.nextLine());

            if (dadosResidenciais.getNumero().isEmpty()) {
                System.out.println("O campo Número é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("CEP: ");
            String cepStr = sc.nextLine();

            if (cepStr.length() != 8 || !cepStr.matches("\\d+")) {
                System.out.println("CEP inválido, tente novamente! Deve conter 8 dígitos.");
            } else {
                dadosResidenciais.setCep(cepStr);
                break;
            }
        }

        while (true) {
            try {
                System.out.print("DDD: ");
                String dddStr = sc.nextLine();

                if (dddStr.isEmpty() || !dddStr.matches("\\d+")) {
                    System.out.println("DDD inválido, tente novamente!");
                    continue;
                }

                int ddd = Integer.parseInt(dddStr);
                if (ddd >= 11 && ddd <= 99) {
                    dadosResidenciais.setDdd(ddd);
                    break;
                } else {
                    System.out.println("DDD inválido, tente novamente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("DDD inválido, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ ZONA ------------------");
                System.out.println("""
                          1 - Urbana
                          2 - Rural
                        """);
                System.out.print("Zona (1-2): ");
                dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        // --- DADOS EPIDEMIOLÓGICOS ---
        DadosEpidemiologicos dadosEpidemiologicos = new DadosEpidemiologicos();
        this.dadosEpidemiologicos = dadosEpidemiologicos;

        while (true) {
            try {
                System.out.print("Data da Investigação: ");
                String dataInvestigacaoStr = sc.nextLine();
                if (dataInvestigacaoStr.isEmpty()) {
                    System.out.println("O campo Data da Investigação é obrigatório, tente novamente!");
                } else {
                    dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(dataInvestigacaoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            System.out.print("Ocupação: ");
            dadosEpidemiologicos.setOcupacao(sc.nextLine());
            if (dadosEpidemiologicos.getOcupacao().isEmpty()) {
                System.out.println("O campo Ocupação é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ ATIVIDADE (ÚLTIMOS 15 DIAS) ------------------");
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
                System.out.print("Atividade (1-12): ");
                dadosEpidemiologicos.setAtividade(AtividadesUltimos15Dias.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ TIPO DE LÂMINA ------------------");
                System.out.println("""
                          1 - BP
                          2 - BA
                          3 - LVC
                          4 - IGNORADO
                      """);
                System.out.print("Tipo de lâmina (1-4): ");
                dadosEpidemiologicos.setTipoLamina(TiposLamina.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ SINTOMAS ------------------");
                System.out.println("""
                          1 - Com sintomas
                          2 - Sem sintomas
                      """);
                System.out.print("Sintomas (1-2): ");
                dadosEpidemiologicos.setSintomas(Sintomas.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Data do exame: ");
                String dataExameStr = sc.nextLine();

                if (dataExameStr.isEmpty()) {
                    System.out.println("O campo Data do exame é obrigatório, tente novamente!");
                } else {
                    dadosEpidemiologicos.setDataExame(LocalDate.parse(dataExameStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ RESULTADO DO EXAME ------------------");
                System.out.println("""
                          1 - Positivo
                          2 - Negativo
                          3 - Indeterminado
                      """);
                System.out.print("Resultado do exame (1-3): ");
                dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Parasitos por mm³: ");
                dadosEpidemiologicos.setParasitasMetroCubico(sc.nextFloat());
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ PARASITEMIA ------------------");
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
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        // --- DADOS DO TRATAMENTO ---
        DadosTratamento dadosTratamento = new DadosTratamento();
        this.dadosTratamento = dadosTratamento;

        while (true) {
            try {
                System.out.println("\n------------------ ESQUEMA DE TRATAMENTO ------------------");
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
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Data de início do tratamento (AAAA-MM-DD): ");
                String dataInicioStr = sc.nextLine();

                if (dataInicioStr.isEmpty()) {
                    System.out.println("O campo Data de início do tratamento é obrigatório, tente novamente!");
                } else {
                    dadosTratamento.setDataInicioTratamento(LocalDate.parse(dataInicioStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        // --- CONCLUSÃO / ENCERRAMENTO ---
        ConclusaoEncerramento conclusaoEncerramento = new ConclusaoEncerramento();
        this.conclusaoEncerramento = conclusaoEncerramento;

        while (true) {
            try {
                System.out.println("\n------------------ CLASSIFICAÇÃO FINAL ------------------");
                System.out.println("""
                          1 - Caso confirmado
                          2 - Caso descartado
                      """);
                System.out.print("Classificação final (1-2): ");
                conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("\n------------------ CASO AUTÓCTONE ------------------");
                System.out.println("""
                           1 - Sim
                           2 - Não
                           3 - Indeterminado
                        """);
                System.out.print("Caso autóctone (1-3): ");
                conclusaoEncerramento.setAutoctone(Autoctone.values()[sc.nextInt() - 1]);
                sc.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }

        while (true) {
            System.out.print("UF provável de infecção: ");
            conclusaoEncerramento.setProvavelUFinfeccao(sc.nextLine());

            if (conclusaoEncerramento.getProvavelUFinfeccao().isEmpty()) {
                System.out.println("O campo UF provável de infecção é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Município provável de infecção: ");
            conclusaoEncerramento.setProvavelMunicipioInfeccao(sc.nextLine());

            if (conclusaoEncerramento.getProvavelMunicipioInfeccao().isEmpty()) {
                System.out.println("O campo Município provável de infecção é obrigatório, tente novamente!");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Data de encerramento: ");
                String dataEncerramentoStr = sc.nextLine();

                if (dataEncerramentoStr.isEmpty()) {
                    System.out.println("O campo Data de encerramento é obrigatório, tente novamente!");
                } else {
                    conclusaoEncerramento.setDataEncerramento(LocalDate.parse(dataEncerramentoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        System.out.println("\nNotificação de MALÁRIA registrada com sucesso!");
        todasNotificacoes.add(this);
    }

    @Override
    public void consultarNotificacao(Scanner sc) {
        int opcao;

        if (todasNotificacoes.isEmpty()) {
            System.out.println("Não há notificações de Malária registradas.");
            return;
        }

        do {
            System.out.println("\n=== CONSULTAR NOTIFICAÇÕES DE MALÁRIA ===");
            System.out.println("1 - Consultar pelo nome do paciente");
            System.out.println("2 - Consultar por bairro");
            System.out.println("3 - Consultar por período");
            System.out.println("4 - Consultar todos os casos de Malária");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine();
                opcao = 0;
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    String nome;
                    while (true) {
                        System.out.print("Digite o nome do paciente: ");
                        nome = sc.nextLine();
                        if (nome.isEmpty()) {
                            System.out.println("O campo Nome do paciente é obrigatório, tente novamente!");
                        } else {
                            break;
                        }
                    }

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
                    String bairro;
                    while (true) {
                        System.out.print("Digite o bairro: ");
                        bairro = sc.nextLine();
                        if (bairro.isEmpty()) {
                            System.out.println("O campo Bairro é obrigatório, tente novamente!");
                        } else {
                            break;
                        }
                    }

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
                    LocalDate inicio;
                    while (true) {
                        try {
                            System.out.print("Digite a data inicial: ");
                            inicio = LocalDate.parse(sc.nextLine());
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
                        }
                    }

                    LocalDate fim;
                    while (true) {
                        try {
                            System.out.print("Digite a data final: ");
                            fim = LocalDate.parse(sc.nextLine());
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
                        }
                    }

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
                    Doenca agravo = Doenca.MALARIA;
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
        } while (opcao < 1 || opcao > 4);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("\n=== RELATÓRIO ESTATÍSTICO DE MALÁRIA ===");

        if (todasNotificacoes.isEmpty()) {
            System.out.println("Não há notificações de Hanseníase para gerar relatório.");
            return;
        }

        int totalAgravo;
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
        System.out.println("Hanseníase: " + totalAgravo);

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

        System.out.println("\nTotal de notificações por faixa etária: ");
        for(NotificacaoMalaria n : todasNotificacoes){
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
            System.out.println("-> " + n.dadosIndividuais.getEscolaridade());
        }

        System.out.println("\nRelatório gerado!");
    }
}