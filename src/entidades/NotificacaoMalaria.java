package entidades;

import entidadesDeDados.*;
import enums.*;

import java.time.LocalDate;
import java.util.Scanner;

public class NotificacaoMalaria extends Notificacao {

  NotificacaoMalaria(){
    // #TODO
    this.codigo++;
  }

  @Override
  public void registrarNotificacao(Scanner sc) {

      IO.println("=== REGISTRO DE NOTIFICAÇÃO: MALÁRIA ===");

      // --- DADOS GERAIS ---
      DadosGerais dadosGerais = new DadosGerais();
      dadosGerais.setAgravo(Doenca.MALARIA);

      IO.print("Data da Notificação: ");
      String dataNotificacaoStr = sc.nextLine();
      dadosGerais.setDataNotificacao(LocalDate.parse(dataNotificacaoStr));

      IO.print("UF: ");
      dadosGerais.setUf(sc.nextLine());

      IO.print("Município de Notificação: ");
      dadosGerais.setMunicipio(sc.nextLine());

      IO.print("Unidade de Saúde: ");
      dadosGerais.setUbs(sc.nextLine());

      IO.print("Data dos primeiros sintomas: ");
      String dataSintomasStr = sc.nextLine();
      dadosGerais.setDataSintomas(LocalDate.parse(dataSintomasStr));

      // --- DADOS INDIVIDUAIS ---
      DadosIndividuais dadosIndividuais = new DadosIndividuais();

      IO.print("Nome do paciente: ");
      dadosIndividuais.setNome(sc.nextLine());

      IO.print("Data de nascimento: ");
      dadosIndividuais.setDataNascimento(sc.nextLine());

      IO.print("Idade: ");
      dadosIndividuais.setIdade(sc.nextInt());
      sc.nextLine();

      IO.print("Sexo (M/F): ");
      dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));


      IO.println("""
                0 - 1º trimestre
                1 - 2º trimestre
                2 - 3º trimestre
                3 - Idade gestacional ignorada
                4 - Não gestante
              """);
      IO.print("Gestante (0-4): ");
      dadosIndividuais.setGestante(Gestante.values()[sc.nextInt() - 1]);
      sc.nextLine();


      IO.println("""
                  0 - Branca
                  1 - Preta
                  2 - Parda
                  3 - Amarela
                  4 - Indígena
                  5 - Não informado
              """);
      IO.print("Raça/Cor (0-5): ");
      dadosIndividuais.setRacaCor(RacaCor.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.println("""
                  0 - Fundamental incompleto
                  1 - Fundamental completo
                  2 - Médio incompleto
                  3 - Médio completo
                  4 - Superior incompleto
                  5 - Superior completo
                  6 - Pós-graduação
                  7 - Mestrado
                  8 - Doutorado
                  9 - Não informado
              """);
      IO.print("Escolaridade (0-9): ");
      dadosIndividuais.setEscolaridade(Escolaridade.values()[sc.nextInt()]);
      sc.nextLine();

      IO.print("Nome da mãe: ");
      dadosIndividuais.setNomeMae(sc.nextLine());

      // --- DADOS RESIDENCIAIS ---
      DadosResidenciais dadosResidenciais = new DadosResidenciais();
      IO.print("UF de residência: ");
      dadosResidenciais.setUf(sc.nextLine());

      IO.print("Município de residência: ");
      dadosResidenciais.setMunicipio(sc.nextLine());

      IO.print("Bairro: ");
      dadosResidenciais.setBairro(sc.nextLine());

      IO.print("Logradouro: ");
      dadosResidenciais.setLogradouro(sc.nextLine());

      IO.print("Número: ");
      dadosResidenciais.setNumero(sc.nextLine());

      IO.print("CEP: ");
      dadosResidenciais.setCep(sc.nextInt());

      IO.print("Telefone: ");
      dadosResidenciais.setDdd(sc.nextInt());

      IO.println("""
                  0 - Urbana
                  1 - Rural
                """);
      IO.print("Zona (0-1): ");
      dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS EPIDEMIOLÓGICOS ---
      DadosEpidemiologicos dadosEpidemiologicos = new DadosEpidemiologicos();

      IO.print("Data da Investigação: ");
      String dataInvestigacaoStr = sc.nextLine();
      dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(dataInvestigacaoStr));


      IO.print("Ocupação: ");
      dadosEpidemiologicos.setOcupacao(sc.nextLine());
      IO.println(""" 
                  0 - Agricultura
                  1 - Pecuária
                  2 - Doméstica
                  3 - Turismo
                  4 - Garimpo
                  5 - Extrativismo vegetal
                  6 - Cacapesca
                  7 - Construção barragens
                  8 - Mineração
                  9 - Viajante
                  10 - Motorista
                  11 - Outros
              """);
      IO.print("Atividade últimos 15 dias (0-11): ");
      dadosEpidemiologicos.setAtividade(AtividadesUltimos15Dias.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS DO EXAME ---
      IO.println("""
                  0 - BP
                  1 - BA
                  2 - LVC
                  3 - IGNORADO
              """);
      IO.print("Tipo de lâmina (0-3): ");
      dadosEpidemiologicos.setTipoLamina(TiposLamina.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.println("""
                  0 - Com sintomas
                  1 - Sem sintomas
              """);
      IO.print("Sintomas (0-1): ");
      dadosEpidemiologicos.setSintomas(Sintomas.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.print("Data do exame: ");
      String dataExameStr = sc.nextLine();
      dadosEpidemiologicos.setDataExame(LocalDate.parse(dataExameStr));


      IO.println("""
                  0 - Positivo
                  1 - Negativo
                  2 - Indeterminado
              """);
      IO.print("Resultado do exame (0-9): ");
      dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.print("Parasitos por mm³: ");
      dadosEpidemiologicos.setParasitasMetroCubico(sc.nextFloat());


      IO.println("""
                  0 - Menor que meia cruz
                  1 - Meia cruz
                  2 - Uma cruz
                  3 - Duas cruzes
                  4 - Três cruzes
                  5 - Quatro cruzes  
              """);
      IO.print("Parasitemia (0-5): ");
      dadosEpidemiologicos.setParasitemia(Parasitemia.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS DO TRATAMENTO ---
      DadosTratamento dadosTratamento = new DadosTratamento();

      IO.println("""
                  0 - Pv Cloroquina Primaquina
                  1 - Pf Quinina Doxiciclina Primaquina
                  2 - Mistas Pv Pf Mefloquina Primaquina
                  3 - Pm Cloroquina
                  4 - Pv Criancas Vomitos
                  5 - Pf Mefloquina Primaquina
                  6 - Pf Quinina 7 Dias
                  7 - Pf Criancas Artesunato Retal
                  8 - Mistas Pv Pf Quinina 3 Dias
                  9 - Prevencao Recaida Pv
                  10 - Malaria Grave Complicada
                  11 - Pf Artemeter Lumerfantrina
                  12 - Outro
               """);
      IO.print("Esquema de tratamento (1-12): ");
      dadosTratamento.setEsquemaTratamento(EsquemaTratamento.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.print("Data de início do tratamento: ");
      String dataInicioStr = sc.nextLine();
      dadosTratamento.setDataInicioTratamento(LocalDate.parse(dataInicioStr));


      // --- CONCLUSÃO / ENCERRAMENTO ---
      ConclusaoEncerramento conclusaoEncerramento = new ConclusaoEncerramento();

      IO.println("""
                  0 - Caso confirmado
                  1 - Caso descartado
              """);
      IO.print("Classificação final (0-1): ");
      conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.println("""
                   0 - Sim
                   1 - Não
                   2 - Indeterminado
                """);
      IO.print("Caso autóctone (0-2): ");
      conclusaoEncerramento.setAutoctone(Autoctone.values()[sc.nextInt() - 1]);
      sc.nextLine();

      IO.print("UF provável de infecção: ");
      conclusaoEncerramento.setProvavelUFinfeccao(sc.nextLine());

      IO.print("Município provável de infecção: ");
      conclusaoEncerramento.setProvavelMunicipioInfeccao(sc.nextLine());

      IO.print("Data de encerramento: ");
      String dataEncerramentoStr = sc.nextLine();
      conclusaoEncerramento.setDataEncerramento(LocalDate.parse(dataEncerramentoStr));

      IO.println("\nNotificação de MALÁRIA registrada com sucesso!");
      todasNotificacoes.add(this);
  }

    @Override
    public void consultarNotificacao(Scanner sc) {
        if (todasNotificacoes.isEmpty()) {
            IO.println("Não há notificações registradas.");
            return;
        }

        IO.println("\n=== CONSULTAR NOTIFICAÇÕES ===");
        IO.println("1 - Consultar pelo nome do paciente");
        IO.println("2 - Consultar por bairro");
        IO.println("3 - Consultar por período");
        IO.println("4 - Consultar por agravo");
        IO.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                IO.print("Digite o nome do paciente: ");
                String nome = sc.nextLine();

                IO.println("\nResultados da consulta pelo nome: " + nome);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosIndividuais.getNome().equalsIgnoreCase(nome)) {
                        IO.println("-> " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    IO.println("Nenhuma notificação encontrada para o paciente: " + nome);
                } else {
                    IO.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 2 -> {
                IO.print("Digite o bairro: ");
                String bairro = sc.nextLine();

                IO.println("\nResultados da consulta pelo bairro: " + bairro);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosResidenciais.getBairro().equalsIgnoreCase(bairro)) {
                        IO.println("->" + n.dadosIndividuais.getNome()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    IO.println("Nenhuma notificação encontrada para o bairro: " + bairro);
                } else {
                    IO.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 3 -> {
                IO.print("Digite a data inicial (AAAA-MM-DD): ");
                LocalDate inicio = LocalDate.parse(sc.nextLine());

                IO.print("Digite a data final (AAAA-MM-DD): ");
                LocalDate fim = LocalDate.parse(sc.nextLine());

                IO.println("\nResultados da consulta por período: " + inicio + " a " + fim);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    LocalDate data = n.dadosGerais.getDataNotificacao();
                    if ((data.isEqual(inicio) || data.isAfter(inicio)) &&
                            (data.isEqual(fim) || data.isBefore(fim))) {
                        IO.println("->" + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + data);
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    IO.println("Nenhuma notificação encontrada no período especificado.");
                } else {
                    IO.println("Total de notificações encontradas: " + encontrados);
                }
            }
            case 4 -> {
                IO.println("""
                             Opções de agravo:
                             +--------------+
                             | MALARIA      |
                             | HANSENIASE   |
                             | TUBERCULOSE  |
                             +--------------+  
                        """);
                IO.print("Digite o agravo: ");
                String doenca = sc.nextLine().toUpperCase();
                Doenca agravo = Doenca.valueOf(doenca);

                IO.println("\nResultados da consulta por agravo: " + agravo);

                int encontrados = 0;
                for (NotificacaoMalaria n : todasNotificacoes) {
                    if (n.dadosGerais.getAgravo() == agravo) {
                        IO.println("- " + n.dadosIndividuais.getNome()
                                + " | Bairro: " + n.dadosResidenciais.getBairro()
                                + " | Data Notificação: " + n.dadosGerais.getDataNotificacao());
                        encontrados++;
                    }
                }

                if (encontrados == 0) {
                    IO.println("Nenhuma notificação encontrada para o agravo: " + agravo);
                } else {
                    IO.println("Total de notificações encontradas: " + encontrados);
                }
            }
            default -> IO.println("Opção inválida!");
        }

    }

    @Override
  public void gerarRelatorio() {
      IO.println("\n=== RELATÓRIO ESTATÍSTICO DE MALÁRIA ===");

      int totalAgravo = 0;
      int totalBairro = 0;
      int totalMesAno = 0;
      int totalSexoM = 0;
      int totalSexoF = 0;
      int totalBranca = 0;
      int totalPreta = 0;
      int totalParda = 0;
      int totalAmarela = 0;
      int totalIndigena = 0;
      int totalNaoInformadoRaca = 0;
      int totalEscolaridade = 0;

      IO.println("\nTotal de notificações por agravo:");
      totalAgravo = todasNotificacoes.size();
      IO.println("Malária: " + totalAgravo);

      IO.println("\nTotal de notificações por bairro:");
      for (NotificacaoMalaria n : todasNotificacoes) {
          IO.println("-> " + n.dadosResidenciais.getBairro());
      }

      IO.println("\nTotal de notificações por sexo:");
      for (NotificacaoMalaria n : todasNotificacoes) {
          if (n.dadosIndividuais.getSexo() == Sexo.M) totalSexoM++;
          if (n.dadosIndividuais.getSexo() == Sexo.F) totalSexoF++;
      }
      IO.println("Masculino: " + totalSexoM);
      IO.println("Feminino: " + totalSexoF);

      IO.println("\nTotal de notificações por raça/cor:");
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
      IO.println("Branca: " + totalBranca);
      IO.println("Preta: " + totalPreta);
      IO.println("Parda: " + totalParda);
      IO.println("Amarela: " + totalAmarela);
      IO.println("Indígena: " + totalIndigena);
      IO.println("Não informado: " + totalNaoInformadoRaca);

      IO.println("\nTotal de notificações por escolaridade:");
      for (NotificacaoMalaria n : todasNotificacoes) {
          IO.println("- " + n.dadosIndividuais.getEscolaridade());
      }

      IO.println("\nRelatório gerado!");
  }
}
