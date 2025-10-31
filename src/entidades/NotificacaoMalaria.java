package entidades;

import enums.gerais.*;
import enums.malaria.*;
import util.GerenciadorDeArquivos;
import entidadesDeDados.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NotificacaoMalaria extends Notificacao {

    public NotificacaoMalaria() {
    }

    @Override
    public void registrarNotificacao(Scanner sc) {
        this.codigo = contadorCodigo++;
        System.out.println("\n=== REGISTRO DE NOTIFICAÇÃO: MALÁRIA ===");

        // --- DADOS GERAIS ---
        this.dadosGerais = new DadosGerais();
        this.dadosGerais.setAgravo(Doenca.MALARIA);

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
                System.out.println("""

                        ------------------ ATIVIDADE (ÚLTIMOS 15 DIAS) ------------------
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
                this.dadosEpidemiologicos.setAtividade(AtividadesUltimos15Dias.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""

                        ------------------ TIPO DE LÂMINA ------------------
                        1 - BP
                        2 - BA
                        3 - LVC
                        4 - IGNORADO
                        """);
                System.out.print("Tipo de lâmina (1-4): ");
                this.dadosEpidemiologicos.setTipoLamina(TiposLamina.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""

                        ------------------ SINTOMAS ------------------
                        1 - Com sintomas
                        2 - Sem sintomas
                        """);
                System.out.print("Sintomas (1-2): ");
                this.dadosEpidemiologicos.setSintomas(Sintomas.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
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

        if(this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            while (true) {
                try {
                    System.out.print("Parasitas por mm³: ");
                    this.dadosEpidemiologicos.setParasitasMetroCubico(Float.parseFloat(sc.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                }
            }

            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ PARASITEMIA ------------------
                            1 - Menor que meia cruz
                            2 - Meia cruz
                            3 - Uma cruz
                            4 - Duas cruzes
                            5 - Três cruzes
                            6 - Quatro cruzes
                            """);
                    System.out.print("Parasitemia (1-6): ");
                    this.dadosEpidemiologicos.setParasitemia(Parasitemia.values()[Integer.parseInt(sc.nextLine()) - 1]);
                    break;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }

            // --- DADOS DO TRATAMENTO ---
            this.dadosTratamento = new DadosTratamento();

            System.out.println("\n--- DADOS DO TRATAMENTO ---");

            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ ESQUEMA DE TRATAMENTO ------------------
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
                    this.dadosTratamento.setEsquemaTratamento(EsquemaTratamento.values()[Integer.parseInt(sc.nextLine()) - 1]);
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
        }

        // --- CONCLUSÃO / ENCERRAMENTO ---
        this.conclusaoEncerramento = new ConclusaoEncerramento();

        System.out.println("\n--- CONCLUSÃO / ENCERRAMENTO ---");

            while (true){
                System.out.print("Matrícula do examinador: ");
                String matriculaExaminador = sc.nextLine();
                if (matriculaExaminador.isEmpty()) {
                    System.out.println("O campo Matrícula do examinador é obrigatório, tente novamente!");
                } else {
                this.conclusaoEncerramento.setMatriculaExaminador(matriculaExaminador);
                break;
                }
            }

            while (true){
                System.out.print("Nome do examinador: ");
                String nomeExaminador = sc.nextLine();
                if (nomeExaminador.isEmpty()) {
                    System.out.println("O campo Nome do examinador é obrigatório, tente novamente!");
                } else {
                this.conclusaoEncerramento.setNomeExaminador(nomeExaminador);
                break;
                }
            }

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

        if(this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ CASO AUTÓCTONE ------------------
                            1 - Sim
                            2 - Não
                            3 - Indeterminado
                            """);
                    System.out.print("Caso autóctone (1-3): ");
                    this.conclusaoEncerramento.setAutoctone(enums.malaria.Autoctone.values()[Integer.parseInt(sc.nextLine()) - 1]);
                    break;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }

            if (this.conclusaoEncerramento.getAutoctone() == Autoctone.SIM || this.conclusaoEncerramento.getAutoctone() == Autoctone.NAO) {
                while (true){
                    System.out.print("Provável país de infecção: ");
                    String provavelPaisInfeccao = sc.nextLine();
                    if (provavelPaisInfeccao.isEmpty()) {
                        System.out.println("O campo Provável país de infecção é obrigatório, tente novamente!");
                    } else {
                        this.conclusaoEncerramento.setProvavelPaisInfeccao(provavelPaisInfeccao);
                        break;
                    }
                }

                while (true) {
                    System.out.print("UF provável de infecção: ");
                    String ufProvavel = sc.nextLine();
                    if (ufProvavel.isEmpty()) {
                        System.out.println("O campo UF provável de infecção é obrigatório, tente novamente!");
                    } else {
                        this.conclusaoEncerramento.setProvavelUFinfeccao(ufProvavel);
                        break;
                    }
                }

                while (true) {
                    System.out.print("Município provável de infecção: ");
                    String municipioProvavel = sc.nextLine();
                    if (municipioProvavel.isEmpty()) {
                        System.out.println("O campo Município provável de infecção é obrigatório, tente novamente!");
                    } else {
                        this.conclusaoEncerramento.setProvavelMunicipioInfeccao(municipioProvavel);
                        break;
                    }
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
        }
        System.out.println("\nNotificação de MALÁRIA registrada com sucesso!");
        Notificacao.todasAsNotificacoes.add(this);
        GerenciadorDeArquivos.salvarNotificacao(this);
    }
}