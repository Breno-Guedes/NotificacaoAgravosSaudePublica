package entidades;

import entidadesDeDados.*;
import enums.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Notificacao {
    public static List<Notificacao> todasAsNotificacoes = new ArrayList<>();

    protected static Integer contadorCodigo = 1;
    protected Integer codigo;
    protected DadosGerais dadosGerais;
    protected DadosIndividuais dadosIndividuais;
    protected DadosResidenciais dadosResidenciais;
    protected DadosEpidemiologicos dadosEpidemiologicos;
    protected DadosTratamento dadosTratamento;
    protected ConclusaoEncerramento conclusaoEncerramento;

    public abstract void registrarNotificacao(Scanner sc);

    public static void consultarNotificacoes(Scanner sc, Doenca tipoAgravo) {
        List<Notificacao> notificacoesDoTipo = todasAsNotificacoes.stream()
                .filter(n -> n.getDadosGerais().getAgravo() == tipoAgravo)
                .collect(Collectors.toList());

        if (notificacoesDoTipo.isEmpty()) {
            System.out.println("Não há notificações de " + tipoAgravo + " registradas.");
            return;
        }

        int opcao;
        do {
            System.out.println("\n=== CONSULTAR NOTIFICAÇÕES DE " + tipoAgravo + " ===");
            System.out.println("1 - Consultar pelo nome do paciente");
            System.out.println("2 - Consultar por bairro");
            System.out.println("3 - Consultar por período");
            System.out.println("4 - Consultar todos os casos de " + tipoAgravo);
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                opcao = 5;
                continue;
            }

            switch (opcao) {
                case 1: {
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
                    for (Notificacao n : notificacoesDoTipo) {
                        if (n.getDadosIndividuais().getNome().equalsIgnoreCase(nome)) {
                            System.out.println("-> Cód: " + n.getCodigo()
                                    + " | Paciente: " + n.getDadosIndividuais().getNome()
                                    + " | Sexo: " + n.getDadosIndividuais().getSexo()
                                    + " | Bairro: " + n.getDadosResidenciais().getBairro()
                                    + " | Data Notificação: " + n.getDadosGerais().getDataNotificacao());
                            encontrados++;
                        }
                    }
                    if (encontrados == 0) {
                        System.out.println("Nenhuma notificação encontrada para o paciente: " + nome);
                    } else {
                        System.out.println("Total de notificações encontradas: " + encontrados);
                    }
                    break;
                }
                case 2: {
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
                    for (Notificacao n : notificacoesDoTipo) {
                        if (n.getDadosResidenciais().getBairro().equalsIgnoreCase(bairro)) {
                            System.out.println("-> Cód: " + n.getCodigo()
                                    + " | Paciente: " + n.getDadosIndividuais().getNome()
                                    + " | Sexo: " + n.getDadosIndividuais().getSexo()
                                    + " | Bairro: " + n.getDadosResidenciais().getBairro()
                                    + " | Data Notificação: " + n.getDadosGerais().getDataNotificacao());
                            encontrados++;
                        }
                    }
                    if (encontrados == 0) {
                        System.out.println("Nenhuma notificação encontrada para o bairro: " + bairro);
                    } else {
                        System.out.println("Total de notificações encontradas: " + encontrados);
                    }
                    break;
                }
                case 3: {
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
                    for (Notificacao n : notificacoesDoTipo) {
                        LocalDate data = n.getDadosGerais().getDataNotificacao();
                        if (!data.isBefore(inicio) && !data.isAfter(fim)) {
                            System.out.println("-> Cód: " + n.getCodigo()
                                    + " | Paciente: " + n.getDadosIndividuais().getNome()
                                    + " | Sexo: " + n.getDadosIndividuais().getSexo()
                                    + " | Bairro: " + n.getDadosResidenciais().getBairro()
                                    + " | Data Notificação: " + data);
                            encontrados++;
                        }
                    }
                    if (encontrados == 0) {
                        System.out.println("Nenhuma notificação encontrada no período especificado.");
                    } else {
                        System.out.println("Total de notificações encontradas: " + encontrados);
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nResultados da consulta por agravo: " + tipoAgravo);
                    int encontrados = 0;
                    for (Notificacao n : notificacoesDoTipo) {
                        System.out.println("-> Cód: " + n.getCodigo()
                                + " | Paciente: " + n.getDadosIndividuais().getNome()
                                + " | Sexo: " + n.getDadosIndividuais().getSexo()
                                + " | Bairro: " + n.getDadosResidenciais().getBairro()
                                + " | Data Notificação: " + n.getDadosGerais().getDataNotificacao());
                        encontrados++;
                    }
                    System.out.println("Total de notificações encontradas: " + encontrados);
                    break;
                }
                case 0:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void gerarRelatorio(Doenca tipoAgravo) {
        List<Notificacao> notificacoesDoTipo = todasAsNotificacoes.stream()
                .filter(n -> n.getDadosGerais().getAgravo() == tipoAgravo)
                .collect(Collectors.toList());

        System.out.println("\n=== RELATÓRIO ESTATÍSTICO DE " + tipoAgravo + " ===");

        if (notificacoesDoTipo.isEmpty()) {
            System.out.println("Não há notificações de " + tipoAgravo + " para gerar relatório.");
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
        int totalA = 0;
        int totalFI = 0;
        int totalFC = 0;
        int totalMI = 0;
        int totalMC = 0;
        int totalSI = 0;
        int totalSC = 0;
        int totalPG = 0;
        int totalM = 0;
        int totalD = 0;
        int totalNI = 0;

        System.out.println("\nTotal de notificações por agravo:");
        totalAgravo = notificacoesDoTipo.size();
        System.out.println(tipoAgravo + ": " + totalAgravo);

        System.out.println("\nTotal de notificações por bairro:");
        for (Notificacao n : notificacoesDoTipo) {
            System.out.println("-> " + n.getDadosResidenciais().getBairro());
        }

        System.out.println("\nTotal de notificações por sexo:");
        for (Notificacao n : notificacoesDoTipo) {
            if (n.getDadosIndividuais().getSexo() == enums.Sexo.M) totalSexoM++;
            if (n.getDadosIndividuais().getSexo() == enums.Sexo.F) totalSexoF++;
        }
        System.out.println("Masculino: " + totalSexoM);
        System.out.println("Feminino: " + totalSexoF);

        System.out.println("\nTotal de notificações por idade: ");
        for(Notificacao n : notificacoesDoTipo){
            if(n.getDadosIndividuais().getIdade() >= 0 && n.getDadosIndividuais().getIdade() <= 18){
                criancaAdolescente++;
            } else if (n.getDadosIndividuais().getIdade() > 18 && n.getDadosIndividuais().getIdade() <= 64) {
                adulto++;
            } else {
                idoso++;
            }
        }

        System.out.println("Total de crianças e adolescentes: " + criancaAdolescente);
        System.out.println("Total de Adultos: " + adulto);
        System.out.println("Total de idosos: " + idoso);

        System.out.println("\nTotal de notificações por raça/cor:");
        for (Notificacao n : notificacoesDoTipo) {
            if (n.getDadosIndividuais().getRacaCor() != null) {
                switch (n.getDadosIndividuais().getRacaCor()) {
                    case BRANCA -> totalBranca++;
                    case PRETA -> totalPreta++;
                    case PARDA -> totalParda++;
                    case AMARELA -> totalAmarela++;
                    case INDIGENA -> totalIndigena++;
                    case NAO_INFORMADO -> totalNaoInformadoRaca++;
                }
            }
        }
        System.out.println("Branca: " + totalBranca);
        System.out.println("Preta: " + totalPreta);
        System.out.println("Parda: " + totalParda);
        System.out.println("Amarela: " + totalAmarela);
        System.out.println("Indígena: " + totalIndigena);
        System.out.println("Não informado: " + totalNaoInformadoRaca);

        System.out.println("\nTotal de notificações por escolaridade:");
        for (Notificacao n : notificacoesDoTipo) {
            if (n.getDadosIndividuais().getEscolaridade() != null){
                switch (n.getDadosIndividuais().getEscolaridade()) {
                    case ANALFABETO -> totalA++;
                    case FUNDAMENTAL_INCOMPLETO -> totalFI++;
                    case FUNDAMENTAL_COMPLETO -> totalFC++;
                    case MEDIO_INCOMPLETO -> totalMI++;
                    case MEDIO_COMPLETO -> totalMC++;
                    case SUPERIOR_INCOMPLETO -> totalSI++;
                    case SUPERIOR_COMPLETO -> totalSC++;
                    case POS_GRADUACAO -> totalPG++;
                    case MESTRADO -> totalM++;
                    case DOUTORADO -> totalD++;
                    case NAO_INFORMADO -> totalNI++;
                }
            }
        }
        System.out.println("Analfabeto: " + totalA);
        System.out.println("Fundamental incompleto: " + totalFI);
        System.out.println("Fundamental completo: " + totalFC);
        System.out.println("Médio incompleto: " + totalMI);
        System.out.println("Médio completo: " + totalMC);
        System.out.println("Superior incompleto: " + totalSI);
        System.out.println("Superior completo: " + totalSC);
        System.out.println("Pós graduação: " + totalPG);
        System.out.println("Mestrado: " + totalM);
        System.out.println("Doutorado: " + totalD);
        System.out.println("Não informado: " + totalNI);


        System.out.println("\nRelatório gerado!");
    }

    public static void setContadorCodigo(Integer contador) {
        contadorCodigo = contador;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public DadosGerais getDadosGerais() {
        return dadosGerais;
    }
    public void setDadosGerais(DadosGerais dadosGerais) {
        this.dadosGerais = dadosGerais;
    }
    public DadosIndividuais getDadosIndividuais() {
        return dadosIndividuais;
    }
    public void setDadosIndividuais(DadosIndividuais dadosIndividuais) {
        this.dadosIndividuais = dadosIndividuais;
    }
    public DadosResidenciais getDadosResidenciais() {
        return dadosResidenciais;
    }
    public void setDadosResidenciais(DadosResidenciais dadosResidenciais) {
        this.dadosResidenciais = dadosResidenciais;
    }
    public DadosEpidemiologicos getDadosEpidemiologicos() {
        return dadosEpidemiologicos;
    }
    public void setDadosEpidemiologicos(DadosEpidemiologicos dadosEpidemiologicos) {
        this.dadosEpidemiologicos = dadosEpidemiologicos;
    }
    public DadosTratamento getDadosTratamento() {
        return dadosTratamento;
    }
    public void setDadosTratamento(DadosTratamento dadosTratamento) {
        this.dadosTratamento = dadosTratamento;
    }
    public ConclusaoEncerramento getConclusaoEncerramento() {
        return conclusaoEncerramento;
    }
    public void setConclusaoEncerramento(ConclusaoEncerramento conclusaoEncerramento) {
        this.conclusaoEncerramento = conclusaoEncerramento;
    }
}