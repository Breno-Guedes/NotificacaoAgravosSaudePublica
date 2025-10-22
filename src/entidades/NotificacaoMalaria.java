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
      this.dadosGerais = new DadosGerais();
      this.dadosGerais.setAgravo(Doenca.MALARIA);

      System.out.print("Data da Notificação: ");
      String dataNotificacaoStr = sc.nextLine();
      this.dadosGerais.setDataNotificacao(LocalDate.parse(dataNotificacaoStr));

      System.out.print("UF: ");
      this.dadosGerais.setUf(sc.nextLine());

      System.out.print("Município de Notificação: ");
      this.dadosGerais.setMunicipio(sc.nextLine());

      System.out.print("Unidade de Saúde: ");
      this.dadosGerais.setUbs(sc.nextLine());

      System.out.print("Data dos primeiros sintomas: ");
      String dataSintomasStr = sc.nextLine();
      this.dadosGerais.setDataSintomas(LocalDate.parse(dataSintomasStr));

      // --- DADOS INDIVIDUAIS ---
      this.dadosIndividuais = new DadosIndividuais();

      System.out.print("Nome do paciente: ");
      this.dadosIndividuais.setNome(sc.nextLine());

      System.out.print("Data de nascimento: ");
      this.dadosIndividuais.setDataNascimento(sc.nextLine());

      System.out.print("Idade: ");
      this.dadosIndividuais.setIdade(sc.nextInt());
      sc.nextLine();

      System.out.print("Sexo (M/F): ");
      this.dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));


      System.out.println("""
                0 - 1º trimestre
                1 - 2º trimestre
                2 - 3º trimestre
                3 - Idade gestacional ignorada
                4 - Não gestante
              """);
      System.out.print("Gestante (0-4): ");
      this.dadosIndividuais.setGestante(Gestante.values()[sc.nextInt() - 1]);
      sc.nextLine();


      System.out.println("""
                  0 - Branca
                  1 - Preta
                  2 - Parda
                  3 - Amarela
                  4 - Indígena
                  5 - Não informado
              """);
      System.out.print("Raça/Cor (0-5): ");
      this.dadosIndividuais.setRacaCor(RacaCor.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.println("""
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
      System.out.print("Escolaridade (0-9): ");
      this.dadosIndividuais.setEscolaridade(Escolaridade.values()[sc.nextInt()]);
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

      System.out.print("Telefone: ");
      this.dadosResidenciais.setDdd(sc.nextInt());

      System.out.println("""
                  0 - Urbana
                  1 - Rural
                """);
      System.out.print("Zona (0-1): ");
      this.dadosResidenciais.setZona(Zona.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS EPIDEMIOLÓGICOS ---
      this.dadosEpidemiologicos = new DadosEpidemiologicos();

      System.out.print("Data da Investigação: ");
      String dataInvestigacaoStr = sc.nextLine();
      this.dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(dataInvestigacaoStr));


      System.out.print("Ocupação: ");
      this.dadosEpidemiologicos.setOcupacao(sc.nextLine());
      System.out.println(""" 
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
      System.out.print("Atividade últimos 15 dias (0-11): ");
      this.dadosEpidemiologicos.setAtividade(AtividadesUltimos15Dias.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS DO EXAME ---
      System.out.println("""
                  0 - BP
                  1 - BA
                  2 - LVC
                  3 - IGNORADO
              """);
      System.out.print("Tipo de lâmina (0-3): ");
      this.dadosEpidemiologicos.setTipoLamina(TiposLamina.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.println("""
                  0 - Com sintomas
                  1 - Sem sintomas
              """);
      System.out.print("Sintomas (0-1): ");
      this.dadosEpidemiologicos.setSintomas(Sintomas.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.print("Data do exame: ");
      String dataExameStr = sc.nextLine();
      this.dadosEpidemiologicos.setDataExame(LocalDate.parse(dataExameStr));


      System.out.println("""
                  0 - Positivo
                  1 - Negativo
                  2 - Indeterminado
              """);
      System.out.print("Resultado do exame (0-9): ");
      this.dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.print("Parasitos por mm³: ");
      this.dadosEpidemiologicos.setParasitasMetroCubico(sc.nextFloat());
      sc.nextLine();


      System.out.println("""
                  0 - Menor que meia cruz
                  1 - Meia cruz
                  2 - Uma cruz
                  3 - Duas cruzes
                  4 - Três cruzes
                  5 - Quatro cruzes  
              """);
      System.out.print("Parasitemia (0-5): ");
      this.dadosEpidemiologicos.setParasitemia(Parasitemia.values()[sc.nextInt() - 1]);
      sc.nextLine();

      // --- DADOS DO TRATAMENTO ---
      this.dadosTratamento = new DadosTratamento();

      System.out.println("""
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
      System.out.print("Esquema de tratamento (1-12): ");
      this.dadosTratamento.setEsquemaTratamento(EsquemaTratamento.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.print("Data de início do tratamento: ");
      String dataInicioStr = sc.nextLine();
      this.dadosTratamento.setDataInicioTratamento(LocalDate.parse(dataInicioStr));


      // --- CONCLUSÃO / ENCERRAMENTO ---
      this.conclusaoEncerramento = new ConclusaoEncerramento();

      System.out.println("""
                  0 - Caso confirmado
                  1 - Caso descartado
              """);
      System.out.print("Classificação final (0-1): ");
      this.conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.println("""
                   0 - Sim
                   1 - Não
                   2 - Indeterminado
                """);
      System.out.print("Caso autóctone (0-2): ");
      this.conclusaoEncerramento.setAutoctone(Autoctone.values()[sc.nextInt() - 1]);
      sc.nextLine();

      System.out.print("UF provável de infecção: ");
      this.conclusaoEncerramento.setProvavelUFinfeccao(sc.nextLine());

      System.out.print("Município provável de infecção: ");
      this.conclusaoEncerramento.setProvavelMunicipioInfeccao(sc.nextLine());

      System.out.print("Data de encerramento: ");
      String dataEncerramentoStr = sc.nextLine();
      this.conclusaoEncerramento.setDataEncerramento(LocalDate.parse(dataEncerramentoStr));

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
