package entidades;

import enums.gerais.*;
import enums.tuberculose.*;
import util.GerenciadorDeArquivos;
import entidadesDeDados.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NotificacaoTuberculose extends Notificacao {

    public NotificacaoTuberculose() {
    }

    @Override
    public void registrarNotificacao(Scanner sc) {
        this.codigo = contadorCodigo++;
        System.out.println("\n=== REGISTRO DE NOTIFICAÇÃO: TUBERCULOSE ===");

        // --- DADOS GERAIS ---
        this.dadosGerais = new DadosGerais();
        this.dadosGerais.setAgravo(Doenca.TUBERCULOSE);

        System.out.println("\n--- DADOS GERAIS ---");

        while (true) {
            try {
                System.out.print("Data da Notificação (AAAA-MM-DD): ");
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
                System.out.print("Data dos primeiros sintomas (AAAA-MM-DD): ");
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
                System.out.print("Data de nascimento (AAAA-MM-DD): ");
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
                System.out.print("Data da Investigação (AAAA-MM-DD): ");
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
                System.out.print("Data do exame (AAAA-MM-DD): ");
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

        // --- ENUNS / DADOS COMPLEMENTARES ESPECÍFICOS DE TUBERCULOSE ---
        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ TIPO DE ENTRADA ------------------
                            1 - Caso novo
                            2 - Recidiva
                            3 - Reingresso após abandono
                            4 - Não sabe
                            5 - Transferência
                            6 - Pós-óbito
                            """);
                System.out.print("Tipo de entrada (1-6): ");
                this.dadosEpidemiologicos.setTipoEntrada(enums.tuberculose.TipoDeEntradaTuberculose.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ POPULAÇÕES ESPECIAIS (opcional) ------------------
                            1 - População privada de liberdade
                            2 - Profissional de saúde
                            3 - População em situação de rua
                            4 - Imigrante
                            """);
                System.out.print("População especial (1-4) ou ENTER para nenhum: ");
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                this.dadosEpidemiologicos.setPopulacaoEspecial(enums.tuberculose.PopNacoesEspeciais.values()[Integer.parseInt(line) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        if(this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            while (true) {
                try {
                    System.out.println("""
                            
                            ------------------ FORMA DE TUBERCULOSE ------------------
                            1 - Pulmonar
                            2 - Extrapulmonar
                            3 - Pulmonar mais extrapulmonar
                            """);
                    System.out.print("Forma de tuberculose (1-3): ");
                    FormaTuberculose forma = FormaTuberculose.values()[Integer.parseInt(sc.nextLine()) - 1];
                    this.dadosEpidemiologicos.setFormaTuberculose(forma);

                    if (forma == FormaTuberculose.EXTRAPULMONAR || forma == FormaTuberculose.PULMONAR_MAIS_EXTRAPULMONAR) {
                        while (true) {
                            try {
                                System.out.println("""
                                        
                                        ------------------ LOCAL EXTRAPULMONAR ------------------
                                        1 - Pleural
                                        2 - Ganglionar periférica
                                        3 - Geniturinária
                                        4 - Óssea
                                        5 - Ocular
                                        6 - Miliar
                                        7 - Meningoencefálico
                                        8 - Cutânea
                                        9 - Laríngea
                                        10 - Outra
                                        """);
                                System.out.print("Local extrapulmonar (1-10): ");
                                this.dadosEpidemiologicos.setLocalExtrapulmonar(enums.tuberculose.LocalExtrapulmonar.values()[Integer.parseInt(sc.nextLine()) - 1]);
                                break;
                            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                                System.out.println("Opção inválida, tente novamente!");
                            }
                        }
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Opção inválida, tente novamente!");
                }
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO BACILOSCOPIA DIAGNÓSTICO ------------------
                            1 - Positiva
                            2 - Negativa
                            3 - Não realizada
                            4 - Não se aplica
                            """);
                System.out.print("Resultado baciloscopia diagnóstico (1-4): ");
                this.dadosEpidemiologicos.setResultadoBaciloscopiaDiagnostico(enums.tuberculose.ResultadoBaciloscopiaDiagnostico.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO RADIOGRAFIA DE TÓRAX ------------------
                            1 - Suspeito
                            2 - Normal
                            3 - Outra patologia
                            4 - Não realizado
                            """);
                System.out.print("Resultado radiografia (1-4): ");
                this.dadosEpidemiologicos.setResultadoRadiografiaTorax(enums.tuberculose.ResultadoRadiografiaTorax.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO HIV ------------------
                            1 - Positivo
                            2 - Negativo
                            3 - Em andamento
                            4 - Não realizado
                            """);
                System.out.print("Resultado HIV (1-4): ");
                this.dadosEpidemiologicos.setResultadoHiv(enums.tuberculose.ResultadoHIV.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO HISTOPATOLOGIA (opcional) ------------------
                            1 - BAAR positivo
                            2 - Sugestivo de TB
                            3 - Não sugestivo de TB
                            4 - Em andamento
                            5 - Não realizado
                            """);
                System.out.print("Resultado histopatologia (1-5) ou ENTER para pular: ");
                String line = sc.nextLine();
                if (line.isEmpty()) break;
                this.dadosEpidemiologicos.setResultadoHistopatologia(enums.tuberculose.ResultadoHistopatologia.values()[Integer.parseInt(line) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO CULTURA (opcional) ------------------
                            1 - Positivo
                            2 - Negativo
                            3 - Em andamento
                            4 - Não realizado
                            """);
                System.out.print("Resultado cultura (1-4) ou ENTER para pular: ");
                String line = sc.nextLine();
                if (line.isEmpty()) break;
                this.dadosEpidemiologicos.setResultadoCultura(enums.tuberculose.ResultadoCultura.values()[Integer.parseInt(line) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO TESTE MOLECULAR RÁPIDO ------------------
                            1 - Detectável sensível a rifampicina
                            2 - Detectável resistente a rifampicina
                            3 - Não detectável
                            4 - Inconclusivo
                            5 - Não realizado
                            """);
                System.out.print("Resultado teste molecular rápido (1-5): ");
                this.dadosEpidemiologicos.setResultadoTesteMolecularRapido(enums.tuberculose.ResultadoTesteMolecularRapido.values()[Integer.parseInt(sc.nextLine()) - 1]);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente!");
            }
        }

        while (true) {
            try {
                System.out.println("""
                            
                            ------------------ RESULTADO TESTE DE SENSIBILIDADE ------------------
                            1 - Resistente somente a isoniazida
                            2 - Resistente somente a rifampicina
                            3 - Resistente a isoniazida e rifampicina
                            4 - Resistente a outras drogas de primeira linha
                            5 - Sensível
                            6 - Em andamento
                            7 - Não realizado
                            """);
                System.out.print("Resultado teste de sensibilidade (1-7): ");
                this.dadosEpidemiologicos.setResultadoTesteSensibilidade(enums.tuberculose.ResultadoTesteSensibilidade.values()[Integer.parseInt(sc.nextLine()) - 1]);
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
                    System.out.print("Data de início do tratamento (AAAA-MM-DD): ");
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

        if (this.conclusaoEncerramento.getClassificacaoFinal() == ClassificacaoFinal.CONFIRMADO ||
                this.dadosEpidemiologicos.getResultadoExame() == ResultadoExame.POSITIVO) {
            while (true) {
                try {
                    System.out.print("Data de encerramento (AAAA-MM-DD): ");
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

        System.out.println("\nNotificação de TUBERCULOSE registrada com sucesso!");
        Notificacao.todasAsNotificacoes.add(this);
        GerenciadorDeArquivos.salvarNotificacao(this);
    }
}