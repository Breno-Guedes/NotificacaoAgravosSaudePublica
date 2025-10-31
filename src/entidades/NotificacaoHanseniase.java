package entidades;

import enums.gerais.*;
import enums.hanseniase.*;
import enums.hanseniase.ClassificacaoOperacionalHanseniase;
import util.GerenciadorDeArquivos;
import entidadesDeDados.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NotificacaoHanseniase extends Notificacao {

    public NotificacaoHanseniase() {
    }

    @Override
    public void registrarNotificacao(Scanner sc) {
        this.codigo = contadorCodigo++;
        System.out.println("\n=== REGISTRO DE NOTIFICAÇÃO: HANSENÍASE ===");

        // --- DADOS GERAIS ---
        this.dadosGerais = new DadosGerais();
        this.dadosGerais.setAgravo(Doenca.HANSENIASE);

        System.out.println("\n--- DADOS GERAIS ---");

        while (true) {
            try {
                System.out.print("Data da Notificação: ");
                String dataNotificacaoStr = sc.nextLine();
                if (dataNotificacaoStr.isEmpty()) {
                    System.out.println("O campo Data da Notificação é obrigatório, tente novamente!");
                } else {
                    this.dadosGerais.setDataNotificacao(LocalDate.parse(dataNotificacaoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            System.out.print("UF: ");
            String uf = sc.nextLine();
            if (uf.isEmpty()) {
                System.out.println("O campo UF é obrigatório, tente novamente!");
            } else {
                this.dadosGerais.setUf(uf);
                break;
            }
        }

        while (true) {
            System.out.print("Município de Notificação: ");
            String municipio = sc.nextLine();
            if (municipio.isEmpty()) {
                System.out.println("O campo Município de Notificação é obrigatório, tente novamente!");
            } else {
                this.dadosGerais.setMunicipio(municipio);
                break;
            }
        }

        while (true) {
            System.out.print("Unidade de Saúde: ");
            String ubs = sc.nextLine();
            if (ubs.isEmpty()) {
                System.out.println("O campo Unidade de Saúde é obrigatório, tente novamente!");
            } else {
                this.dadosGerais.setUbs(ubs);
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
                    this.dadosGerais.setDataSintomas(LocalDate.parse(dataSintomasStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        // --- DADOS INDIVIDUAIS ---
        this.dadosIndividuais = new DadosIndividuais();

        System.out.println("\n--- DADOS INDIVIDUAIS ---");

        while (true) {
            System.out.print("Nome do paciente: ");
            String nome = sc.nextLine();
            if (nome.isEmpty()) {
                System.out.println("O campo Nome do paciente é obrigatório, tente novamente!");
            } else {
                this.dadosIndividuais.setNome(nome);
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
                    this.dadosIndividuais.setDataNascimento(LocalDate.parse(dataNascimentoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.print("Idade: ");
                int idade = Integer.parseInt(sc.nextLine());
                if (idade > 0 && idade <= 115) {
                    this.dadosIndividuais.setIdade(idade);
                    break;
                } else {
                    System.out.println("Idade inválida, tente novamente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para idade. Por favor, insira um número.");
            }
        }

        while (true) {
            try {
                System.out.print("Sexo (M/F): ");
                this.dadosIndividuais.setSexo(Sexo.valueOf(sc.nextLine().toUpperCase()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        if (this.dadosIndividuais.getSexo() == Sexo.F) {
            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ GESTANTE ------------------
                            1 - 1º trimestre
                            2 - 2º trimestre
                            3 - 3º trimestre
                            4 - Idade gestacional ignorada
                            5 - Não gestante
                            """);
                    System.out.print("Gestante (1-5): ");
                    this.dadosIndividuais.setGestante(Gestante.values()[Integer.parseInt(sc.nextLine()) - 1]);
                    break;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ RAÇA/COR ------------------
                        1 - Branca
                        2 - Preta
                        3 - Parda
                        4 - Amarela
                        5 - Indígena
                        6 - Não informado
                        """);
                System.out.print("Raça/Cor (1-6): ");
                this.dadosIndividuais.setRacaCor(RacaCor.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""

                        ------------------ ESCOLARIDADE ------------------
                        1 - Analfabeto
                        2 - Fundamental incompleto
                        3 - Fundamental completo
                        4 - Médio incompleto
                        5 - Médio completo
                        6 - Superior incompleto
                        7 - Superior completo
                        8 - Pós-graduação
                        9 - Mestrado
                        10 - Doutorado
                        11 - Não informado
                        """);
                System.out.print("Escolaridade (1-11): ");
                this.dadosIndividuais.setEscolaridade(Escolaridade.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            System.out.print("Nome da mãe: ");
            String nomeMae = sc.nextLine();
            if (nomeMae.isEmpty()) {
                System.out.println("O campo Nome da mãe é obrigatório, tente novamente!");
            } else {
                this.dadosIndividuais.setNomeMae(nomeMae);
                break;
            }
        }

        // --- DADOS RESIDENCIAIS ---
        this.dadosResidenciais = new DadosResidenciais();

        System.out.println("\n--- DADOS RESIDENCIAIS ---");

        while (true) {
            System.out.print("UF de residência: ");
            String uf = sc.nextLine();
            if (uf.isEmpty()) {
                System.out.println("O campo UF de residência é obrigatório, tente novamente!");
            } else {
                this.dadosResidenciais.setUf(uf);
                break;
            }
        }

        while (true) {
            System.out.print("Município de residência: ");
            String municipio = sc.nextLine();
            if (municipio.isEmpty()) {
                System.out.println("O campo Município de residência é obrigatório, tente novamente!");
            } else {
                this.dadosResidenciais.setMunicipio(municipio);
                break;
            }
        }

        while (true) {
            System.out.print("Bairro: ");
            String bairro = sc.nextLine();
            if (bairro.isEmpty()) {
                System.out.println("O campo Bairro é obrigatório, tente novamente!");
            } else {
                this.dadosResidenciais.setBairro(bairro);
                break;
            }
        }

        while (true) {
            System.out.print("Logradouro: ");
            String logradouro = sc.nextLine();
            if (logradouro.isEmpty()) {
                System.out.println("O campo Logradouro é obrigatório, tente novamente!");
            } else {
                this.dadosResidenciais.setLogradouro(logradouro);
                break;
            }
        }

        while (true) {
            System.out.print("Número: ");
            String numero = sc.nextLine();
            if (numero.isEmpty()) {
                System.out.println("O campo Número é obrigatório, tente novamente!");
            } else {
                this.dadosResidenciais.setNumero(numero);
                break;
            }
        }

        while (true) {
            System.out.print("CEP: ");
            String cepStr = sc.nextLine();
            if (cepStr.length() != 8 || !cepStr.matches("\\d+")) {
                System.out.println("CEP inválido, tente novamente! Deve conter 8 dígitos.");
            } else {
                this.dadosResidenciais.setCep(cepStr);
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Digite o DDD e o telefone: ");
                String telefoneCompleto = sc.nextLine().trim();

                if (telefoneCompleto.isEmpty()) {
                    System.out.println("Campo vazio! Digite novamente.");
                    continue;
                }

                if (!telefoneCompleto.matches("\\d+")) {
                    System.out.println("Número inválido! Digite apenas números (sem letras ou símbolos).");
                    continue;
                }

                if (telefoneCompleto.length() < 10 || telefoneCompleto.length() > 11) {
                    System.out.println("Tamanho inválido! O número deve ter entre 10 e 11 dígitos.");
                    continue;
                }

                this.dadosResidenciais.setTelefone(telefoneCompleto);
                break;

            } catch (Exception e) {
                System.out.println("Erro inesperado! Tente novamente.");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ ZONA ------------------
                        1 - Urbana
                        2 - Rural
                        """);
                System.out.print("Zona (1-2): ");
                this.dadosResidenciais.setZona(Zona.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        // --- DADOS EPIDEMIOLÓGICOS ---
        this.dadosEpidemiologicos = new DadosEpidemiologicos();

        System.out.println("\n--- DADOS EPIDEMIOLÓGICOS ---");
        while (true) {
            try {
                System.out.print("Data da Investigação: ");
                String dataInvestigacaoStr = sc.nextLine();
                if (dataInvestigacaoStr.isEmpty()) {
                    System.out.println("O campo Data da Investigação é obrigatório, tente novamente!");
                } else {
                    this.dadosEpidemiologicos.setDataInvestigacao(LocalDate.parse(dataInvestigacaoStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            System.out.print("Ocupação: ");
            String ocupacao = sc.nextLine();
            if (ocupacao.isEmpty()) {
                System.out.println("O campo Ocupação é obrigatório, tente novamente!");
            } else {
                this.dadosEpidemiologicos.setOcupacao(ocupacao);
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Data do exame: ");
                String dataExameStr = sc.nextLine();
                if (dataExameStr.isEmpty()) {
                    System.out.println("O campo Data do exame é obrigatório, tente novamente!");
                } else {
                    this.dadosEpidemiologicos.setDataExame(LocalDate.parse(dataExameStr));
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ RESULTADO DO EXAME ------------------
                        1 - Positivo
                        2 - Negativo
                        3 - Indeterminado
                        """);
                System.out.print("Resultado do exame (1-3): ");
                this.dadosEpidemiologicos.setResultadoExame(ResultadoExame.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        // --- ENUMS / DADOS COMPLEMENTARES ESPECÍFICOS DE HANSENÍASE ---
        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ MODO DE ENTRADA ------------------
                        1 - Caso novo
                        2 - Transferência mesmo município
                        3 - Transferência outro município
                        4 - Transferência outro estado
                        5 - Transferência outro país
                        6 - Recidiva
                        7 - Outros reingressos
                        8 - Ignorado
                        """);
                System.out.print("Modo de entrada (1-8): ");
                this.dadosEpidemiologicos.setModoEntradaHanseniase(ModoEntradaHanseniase.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ MODO DE DETECÇÃO ------------------
                        1 - Encaminhamento
                        2 - Demanda espontânea
                        3 - Exame de coletividade
                        4 - Exame de contatos
                        5 - Outros modos
                        6 - Ignorado
                        """);
                System.out.print("Modo de detecção (1-6): ");
                this.dadosEpidemiologicos.setModoDeteccao(ModoDeteccaoCasoNovo.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ RESULTADO BACILOSCOPIA ------------------
                        1 - Positiva
                        2 - Negativa
                        3 - Não realizada
                        4 - Ignorado
                        """);
                System.out.print("Resultado baciloscopia (1-4): ");
                this.dadosEpidemiologicos.setResultadoBaciloscopiaHanseniase(ResultadoBaciloscopiaHanseniase.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        // --- DADOS DO TRATAMENTO ---
        if (this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            this.dadosTratamento = new DadosTratamento();

            System.out.println("\n--- DADOS DO TRATAMENTO ---");

            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ ESQUEMA TERAPÊUTICO INICIAL ------------------
                            1 - PQT/PB/6 doses
                            2 - PQT/MB/12 doses
                            3 - Outros esquemas substitutos
                            """);
                    System.out.print("Esquema terapêutico inicial (1-3): ");
                    this.dadosTratamento.setEsquemaTerapeuticoInicial(enums.hanseniase.EsquemaTerapeuticoInicial.values()[Integer.parseInt(sc.nextLine()) - 1]);
                    break;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }

            while (true) {
                try {
                    System.out.print("Data de início do tratamento: ");
                    String dataInicioStr = sc.nextLine();
                    if (dataInicioStr.isEmpty()) {
                        System.out.println("O campo Data de início do tratamento é obrigatório, tente novamente!");
                    } else {
                        this.dadosTratamento.setDataInicioTratamento(LocalDate.parse(dataInicioStr));
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
                }
            }
        } else {
            this.dadosTratamento = new DadosTratamento();
        }

        // --- CONCLUSÃO / ENCERRAMENTO ---
        this.conclusaoEncerramento = new ConclusaoEncerramento();

        System.out.println("\n--- CONCLUSÃO / ENCERRAMENTO ---");

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ CLASSIFICAÇÃO FINAL ------------------
                        1 - Caso confirmado
                        2 - Caso descartado
                        """);
                System.out.print("Classificação final (1-2): ");
                this.conclusaoEncerramento.setClassificacaoFinal(ClassificacaoFinal.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ FORMA CLÍNICA ------------------
                        1 - Indeterminada
                        2 - Tuberculoide
                        3 - Dimorfa
                        4 - Virchowiana
                        5 - Não classificado
                        """);
                System.out.print("Forma clínica (1-5): ");
                this.conclusaoEncerramento.setFormaClinicaHanseniase(FormaClinicaHanseniase.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ CLASSIFICAÇÃO OPERACIONAL ------------------
                        1 - Paucibacilar (PB)
                        2 - Multibacilar (MB)
                        """);
                System.out.print("Classificação operacional (1-2): ");
                this.conclusaoEncerramento.setClassificacaoOperacionalHanseniase(ClassificacaoOperacionalHanseniase.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                        
                        ------------------ GRAU DE INCAPACIDADE FÍSICA ------------------
                        1 - Grau zero
                        2 - Grau I
                        3 - Grau II
                        4 - Não avaliado
                        """);
                System.out.print("Grau de incapacidade (1-4): ");
                this.conclusaoEncerramento.setGrauIncapacidadeFisica(GrauIncapacidadeFisica.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        if (this.conclusaoEncerramento.getClassificacaoFinal() == ClassificacaoFinal.CONFIRMADO ||
                this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            while (true) {
                try {
                    System.out.print("Data de encerramento: ");
                    String dataEncerramentoStr = sc.nextLine();
                    if (dataEncerramentoStr.isEmpty()) {
                        System.out.println("O campo Data de encerramento é obrigatório, tente novamente!");
                    } else {
                        this.conclusaoEncerramento.setDataEncerramento(LocalDate.parse(dataEncerramentoStr));
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Use AAAA-MM-DD. Tente novamente!");
                }
            }
        }

        System.out.println("\nNotificação de HANSENÍASE registrada com sucesso!");
        Notificacao.todasAsNotificacoes.add(this);
        GerenciadorDeArquivos.salvarNotificacao(this);
    }
}