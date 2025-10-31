package util;

import entidades.*;
import entidadesDeDados.*;
import enums.gerais.*;
import enums.hanseniase.*;
import enums.hanseniase.ClassificacaoOperacionalHanseniase;
import enums.malaria.*;
import enums.tuberculose.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class GerenciadorDeArquivos {

    private static final String DIR = "src/database/";
    private static final String MALARIA_FILE = DIR + "malaria.txt";
    private static final String HANSENIASE_FILE = DIR + "hanseniase.txt";
    private static final String TUBERCULOSE_FILE = DIR + "tuberculose.txt";

    static {
        try {
            Files.createDirectories(Paths.get(DIR));
        } catch (IOException e) {
            System.err.println("Erro ao criar diretório do banco de dados: " + e.getMessage());
        }
    }

    public static void salvarNotificacao(Notificacao notificacao) {
        String arquivo = getArquivoPorInstancia(notificacao);
        if (arquivo == null) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(formatarParaSalvar(notificacao));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar notificação: " + e.getMessage());
        }
    }

    public static void carregarNotificacoes() {
        Notificacao.todasAsNotificacoes.clear();

        carregarArquivo(MALARIA_FILE, GerenciadorDeArquivos::parseMalaria);
        carregarArquivo(HANSENIASE_FILE, GerenciadorDeArquivos::parseHanseniase);
        carregarArquivo(TUBERCULOSE_FILE, GerenciadorDeArquivos::parseTuberculose);

        int maxCodigo = Notificacao.todasAsNotificacoes.stream()
                .mapToInt(Notificacao::getCodigo)
                .max()
                .orElse(0);
        Notificacao.setContadorCodigo(maxCodigo + 1);
    }

    private static void carregarArquivo(String arquivo, Function<Map<String, String>, Notificacao> parser) {
        File f = new File(arquivo);
        if (!f.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                Map<String, String> dados = new HashMap<>();
                for (String par : linha.split(";")) {
                    String[] chaveValor = par.split("=", 2);
                    if (chaveValor.length == 2) {
                        dados.put(chaveValor[0], chaveValor[1]);
                    } else {
                        dados.put(chaveValor[0], "");
                    }
                }
                Notificacao.todasAsNotificacoes.add(parser.apply(dados));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar notificações do arquivo " + arquivo + ": " + e.getMessage());
        }
    }

    private static String getArquivoPorInstancia(Notificacao n) {
        if (n instanceof NotificacaoMalaria) return MALARIA_FILE;
        if (n instanceof NotificacaoHanseniase) return HANSENIASE_FILE;
        if (n instanceof NotificacaoTuberculose) return TUBERCULOSE_FILE;
        return null;
    }

    private static String formatarParaSalvar(Notificacao n) {
        StringBuilder sb = new StringBuilder();
        append(sb, "codigo", n.getCodigo());
        if (n.getDadosGerais() != null) {
            append(sb, "dataNotificacao", n.getDadosGerais().getDataNotificacao());
            append(sb, "uf", n.getDadosGerais().getUf());
            append(sb, "municipio", n.getDadosGerais().getMunicipio());
            append(sb, "ubs", n.getDadosGerais().getUbs());
            append(sb, "dataSintomas", n.getDadosGerais().getDataSintomas());
        }
        if (n.getDadosIndividuais() != null) {
            append(sb, "nome", n.getDadosIndividuais().getNome());
            append(sb, "dataNascimento", n.getDadosIndividuais().getDataNascimento());
            append(sb, "idade", n.getDadosIndividuais().getIdade());
            append(sb, "sexo", n.getDadosIndividuais().getSexo());
            append(sb, "gestante", n.getDadosIndividuais().getGestante());
            append(sb, "racaCor", n.getDadosIndividuais().getRacaCor());
            append(sb, "escolaridade", n.getDadosIndividuais().getEscolaridade());
            append(sb, "nomeMae", n.getDadosIndividuais().getNomeMae());
        }
        if (n.getDadosResidenciais() != null) {
            append(sb, "residenciaUf", n.getDadosResidenciais().getUf());
            append(sb, "residenciaMunicipio", n.getDadosResidenciais().getMunicipio());
            append(sb, "bairro", n.getDadosResidenciais().getBairro());
            append(sb, "logradouro", n.getDadosResidenciais().getLogradouro());
            append(sb, "numero", n.getDadosResidenciais().getNumero());
            append(sb, "cep", n.getDadosResidenciais().getCep());
            append(sb, "ddd", n.getDadosResidenciais().getTelefone());
            append(sb, "zona", n.getDadosResidenciais().getZona());
        }
        if (n.getDadosEpidemiologicos() != null) {
            append(sb, "dataInvestigacao", n.getDadosEpidemiologicos().getDataInvestigacao());
            append(sb, "ocupacao", n.getDadosEpidemiologicos().getOcupacao());
            append(sb, "dataExame", n.getDadosEpidemiologicos().getDataExame());
            append(sb, "resultadoExame", n.getDadosEpidemiologicos().getResultadoExame());

            if (n instanceof NotificacaoTuberculose) {
                DadosEpidemiologicos de = n.getDadosEpidemiologicos();
                append(sb, "tipoEntrada", de.getTipoEntrada());
                append(sb, "populacaoEspecial", de.getPopulacaoEspecial());
                append(sb, "formaTuberculose", de.getFormaTuberculose());
                append(sb, "localExtrapulmonar", de.getLocalExtrapulmonar());
                append(sb, "resultadoBaciloscopiaDiagnostico", de.getResultadoBaciloscopiaDiagnostico());
                append(sb, "resultadoRadiografiaTorax", de.getResultadoRadiografiaTorax());
                append(sb, "resultadoHiv", de.getResultadoHiv());
                append(sb, "resultadoHistopatologia", de.getResultadoHistopatologia());
                append(sb, "resultadoCultura", de.getResultadoCultura());
                append(sb, "resultadoTesteMolecularRapido", de.getResultadoTesteMolecularRapido());
                append(sb, "resultadoTesteSensibilidade", de.getResultadoTesteSensibilidade());
            }

            if (n instanceof NotificacaoHanseniase) {
                DadosEpidemiologicos de = n.getDadosEpidemiologicos();
                append(sb, "modoEntradaHanseniase", de.getModoEntradaHanseniase());
                append(sb, "modoDeteccao", de.getModoDeteccao());
                append(sb, "resultadoBaciloscopiaHanseniase", de.getResultadoBaciloscopiaHanseniase());
            }
        }
        if (n.getDadosTratamento() != null) {
            append(sb, "dataInicioTratamento", n.getDadosTratamento().getDataInicioTratamento());

            if (n instanceof NotificacaoHanseniase) {
                append(sb, "esquemaTerapeuticoInicial", n.getDadosTratamento().getEsquemaTerapeuticoInicial());
            }

            if (n instanceof NotificacaoMalaria nm) {
                append(sb, "esquemaTratamento", nm.getDadosTratamento().getEsquemaTratamento());
            }
        }
        if (n.getConclusaoEncerramento() != null) {
            append(sb, "classificacaoFinal", n.getConclusaoEncerramento().getClassificacaoFinal());
            append(sb, "dataEncerramento", n.getConclusaoEncerramento().getDataEncerramento());

            if (n instanceof NotificacaoHanseniase) {
                ConclusaoEncerramento ce = n.getConclusaoEncerramento();
                append(sb, "formaClinicaHanseniase", ce.getFormaClinicaHanseniase());
                append(sb, "classificacaoOperacionalHanseniase", ce.getClassificacaoOperacionalHanseniase());
                append(sb, "grauIncapacidadeFisica", ce.getGrauIncapacidadeFisica());
            }

            if (n instanceof NotificacaoMalaria nm) {
                append(sb, "autoctone", nm.getConclusaoEncerramento().getAutoctone());
                append(sb, "provavelUfInfeccao", nm.getConclusaoEncerramento().getProvavelUFinfeccao());
                append(sb, "provavelMunicipioInfeccao", nm.getConclusaoEncerramento().getProvavelMunicipioInfeccao());
            }
        }
        return sb.toString();
    }

    private static void append(StringBuilder sb, String key, Object value) {
        sb.append(key).append("=").append(value == null ? "" : value.toString()).append(";");
    }

    private static <E extends Enum<E>> E parseEnum(Class<E> enumClass, String value) {
        if (value == null || value.isEmpty() || value.equals("null")) return null;
        try {
            return Enum.valueOf(enumClass, value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static NotificacaoMalaria parseMalaria(Map<String, String> dados) {
        NotificacaoMalaria n = new NotificacaoMalaria();
        n.setDadosGerais(new DadosGerais());
        n.getDadosGerais().setAgravo(Doenca.MALARIA);
        preencherDadosComuns(n, dados);
        applyIfPresent(dados, "atividade", v -> n.getDadosEpidemiologicos().setAtividade(parseEnum(AtividadesUltimos15Dias.class, v)));
        applyIfPresent(dados, "tipoLamina", v -> n.getDadosEpidemiologicos().setTipoLamina(parseEnum(TiposLamina.class, v)));
        applyIfPresent(dados, "sintomas", v -> n.getDadosEpidemiologicos().setSintomas(parseEnum(Sintomas.class, v)));
        applyIfPresent(dados, "parasitasMm3", v -> n.getDadosEpidemiologicos().setParasitasMetroCubico(Float.parseFloat(v)));
        applyIfPresent(dados, "parasitemia", v -> n.getDadosEpidemiologicos().setParasitemia(parseEnum(Parasitemia.class, v)));
        applyIfPresent(dados, "esquemaTratamento", v -> n.getDadosTratamento().setEsquemaTratamento(parseEnum(EsquemaTratamento.class, v)));
        applyIfPresent(dados, "autoctone", v -> n.getConclusaoEncerramento().setAutoctone(parseEnum(Autoctone.class, v)));
        applyIfPresent(dados, "provavelUfInfeccao", v -> n.getConclusaoEncerramento().setProvavelUFinfeccao(v));
        applyIfPresent(dados, "provavelMunicipioInfeccao", v -> n.getConclusaoEncerramento().setProvavelMunicipioInfeccao(v));
        return n;
    }

    private static NotificacaoHanseniase parseHanseniase(Map<String, String> dados) {
        NotificacaoHanseniase n = new NotificacaoHanseniase();
        n.setDadosGerais(new DadosGerais());
        n.getDadosGerais().setAgravo(Doenca.HANSENIASE);
        preencherDadosComuns(n, dados);

        applyIfPresent(dados, "modoEntradaHanseniase", v -> n.getDadosEpidemiologicos().setModoEntradaHanseniase(parseEnum(ModoEntradaHanseniase.class, v)));
        applyIfPresent(dados, "modoDeteccao", v -> n.getDadosEpidemiologicos().setModoDeteccao(parseEnum(ModoDeteccaoCasoNovo.class, v)));
        applyIfPresent(dados, "resultadoBaciloscopiaHanseniase", v -> n.getDadosEpidemiologicos().setResultadoBaciloscopiaHanseniase(parseEnum(ResultadoBaciloscopiaHanseniase.class, v)));
        applyIfPresent(dados, "esquemaTerapeuticoInicial", v -> n.getDadosTratamento().setEsquemaTerapeuticoInicial(parseEnum(EsquemaTerapeuticoInicial.class, v)));
        applyIfPresent(dados, "formaClinicaHanseniase", v -> n.getConclusaoEncerramento().setFormaClinicaHanseniase(parseEnum(FormaClinicaHanseniase.class, v)));
        applyIfPresent(dados, "classificacaoOperacionalHanseniase", v -> n.getConclusaoEncerramento().setClassificacaoOperacionalHanseniase(parseEnum(ClassificacaoOperacionalHanseniase.class, v)));
        applyIfPresent(dados, "grauIncapacidadeFisica", v -> n.getConclusaoEncerramento().setGrauIncapacidadeFisica(parseEnum(GrauIncapacidadeFisica.class, v)));
        return n;
    }

    private static NotificacaoTuberculose parseTuberculose(Map<String, String> dados) {
        NotificacaoTuberculose n = new NotificacaoTuberculose();
        n.setDadosGerais(new DadosGerais());
        n.getDadosGerais().setAgravo(Doenca.TUBERCULOSE);
        preencherDadosComuns(n, dados);

        applyIfPresent(dados, "tipoEntrada", v -> n.getDadosEpidemiologicos().setTipoEntrada(parseEnum(TipoDeEntradaTuberculose.class, v)));
        applyIfPresent(dados, "populacaoEspecial", v -> n.getDadosEpidemiologicos().setPopulacaoEspecial(parseEnum(PopNacoesEspeciais.class, v)));
        applyIfPresent(dados, "formaTuberculose", v -> n.getDadosEpidemiologicos().setFormaTuberculose(parseEnum(FormaTuberculose.class, v)));
        applyIfPresent(dados, "localExtrapulmonar", v -> n.getDadosEpidemiologicos().setLocalExtrapulmonar(parseEnum(LocalExtrapulmonar.class, v)));
        applyIfPresent(dados, "resultadoBaciloscopiaDiagnostico", v -> n.getDadosEpidemiologicos().setResultadoBaciloscopiaDiagnostico(parseEnum(ResultadoBaciloscopiaDiagnostico.class, v)));
        applyIfPresent(dados, "resultadoRadiografiaTorax", v -> n.getDadosEpidemiologicos().setResultadoRadiografiaTorax(parseEnum(ResultadoRadiografiaTorax.class, v)));
        applyIfPresent(dados, "resultadoHiv", v -> n.getDadosEpidemiologicos().setResultadoHiv(parseEnum(ResultadoHIV.class, v)));
        applyIfPresent(dados, "resultadoHistopatologia", v -> n.getDadosEpidemiologicos().setResultadoHistopatologia(parseEnum(ResultadoHistopatologia.class, v)));
        applyIfPresent(dados, "resultadoCultura", v -> n.getDadosEpidemiologicos().setResultadoCultura(parseEnum(ResultadoCultura.class, v)));
        applyIfPresent(dados, "resultadoTesteMolecularRapido", v -> n.getDadosEpidemiologicos().setResultadoTesteMolecularRapido(parseEnum(ResultadoTesteMolecularRapido.class, v)));
        applyIfPresent(dados, "resultadoTesteSensibilidade", v -> n.getDadosEpidemiologicos().setResultadoTesteSensibilidade(parseEnum(ResultadoTesteSensibilidade.class, v)));
        return n;
    }

    private static void preencherDadosComuns(Notificacao n, Map<String, String> dados) {
        n.setCodigo(Integer.parseInt(dados.get("codigo")));
        n.setDadosIndividuais(new DadosIndividuais());
        n.setDadosResidenciais(new DadosResidenciais());
        n.setDadosEpidemiologicos(new DadosEpidemiologicos());
        n.setDadosTratamento(new DadosTratamento());
        n.setConclusaoEncerramento(new ConclusaoEncerramento());

        applyIfPresent(dados, "dataNotificacao", v -> n.getDadosGerais().setDataNotificacao(LocalDate.parse(v)));
        applyIfPresent(dados, "uf", v -> n.getDadosGerais().setUf(v));
        applyIfPresent(dados, "municipio", v -> n.getDadosGerais().setMunicipio(v));
        applyIfPresent(dados, "ubs", v -> n.getDadosGerais().setUbs(v));
        applyIfPresent(dados, "dataSintomas", v -> n.getDadosGerais().setDataSintomas(LocalDate.parse(v)));

        applyIfPresent(dados, "nome", v -> n.getDadosIndividuais().setNome(v));
        applyIfPresent(dados, "dataNascimento", v -> n.getDadosIndividuais().setDataNascimento(LocalDate.parse(v)));
        applyIfPresent(dados, "idade", v -> n.getDadosIndividuais().setIdade(Integer.parseInt(v)));
        applyIfPresent(dados, "sexo", v -> n.getDadosIndividuais().setSexo(parseEnum(Sexo.class, v)));
        applyIfPresent(dados, "gestante", v -> n.getDadosIndividuais().setGestante(parseEnum(Gestante.class, v)));
        applyIfPresent(dados, "racaCor", v -> n.getDadosIndividuais().setRacaCor(parseEnum(RacaCor.class, v)));
        applyIfPresent(dados, "escolaridade", v -> n.getDadosIndividuais().setEscolaridade(parseEnum(Escolaridade.class, v)));
        applyIfPresent(dados, "nomeMae", v -> n.getDadosIndividuais().setNomeMae(v));

        applyIfPresent(dados, "residenciaUf", v -> n.getDadosResidenciais().setUf(v));
        applyIfPresent(dados, "residenciaMunicipio", v -> n.getDadosResidenciais().setMunicipio(v));
        applyIfPresent(dados, "bairro", v -> n.getDadosResidenciais().setBairro(v));
        applyIfPresent(dados, "logradouro", v -> n.getDadosResidenciais().setLogradouro(v));
        applyIfPresent(dados, "numero", v -> n.getDadosResidenciais().setNumero(v));
        applyIfPresent(dados, "cep", v -> n.getDadosResidenciais().setCep(v));
        applyIfPresent(dados, "telefone", v -> n.getDadosResidenciais().setTelefone(v));
        applyIfPresent(dados, "zona", v -> n.getDadosResidenciais().setZona(parseEnum(Zona.class, v)));

        applyIfPresent(dados, "dataInvestigacao", v -> n.getDadosEpidemiologicos().setDataInvestigacao(LocalDate.parse(v)));
        applyIfPresent(dados, "ocupacao", v -> n.getDadosEpidemiologicos().setOcupacao(v));
        applyIfPresent(dados, "dataExame", v -> n.getDadosEpidemiologicos().setDataExame(LocalDate.parse(v)));
        applyIfPresent(dados, "resultadoExame", v -> n.getDadosEpidemiologicos().setResultadoExame(parseEnum(ResultadoExame.class, v)));

        applyIfPresent(dados, "dataInicioTratamento", v -> n.getDadosTratamento().setDataInicioTratamento(LocalDate.parse(v)));

        applyIfPresent(dados, "esquemaTerapeuticoInicial", v -> n.getDadosTratamento().setEsquemaTerapeuticoInicial(parseEnum(EsquemaTerapeuticoInicial.class, v)));

        applyIfPresent(dados, "classificacaoFinal", v -> n.getConclusaoEncerramento().setClassificacaoFinal(parseEnum(ClassificacaoFinal.class, v)));
        applyIfPresent(dados, "dataEncerramento", v -> n.getConclusaoEncerramento().setDataEncerramento(LocalDate.parse(v)));

        applyIfPresent(dados, "formaClinicaHanseniase", v -> n.getConclusaoEncerramento().setFormaClinicaHanseniase(parseEnum(FormaClinicaHanseniase.class, v)));
        applyIfPresent(dados, "classificacaoOperacionalHanseniase", v -> n.getConclusaoEncerramento().setClassificacaoOperacionalHanseniase(parseEnum(ClassificacaoOperacionalHanseniase.class, v)));
        applyIfPresent(dados, "grauIncapacidadeFisica", v -> n.getConclusaoEncerramento().setGrauIncapacidadeFisica(parseEnum(GrauIncapacidadeFisica.class, v)));

        applyIfPresent(dados, "tipoEntrada", v -> n.getDadosEpidemiologicos().setTipoEntrada(parseEnum(TipoDeEntradaTuberculose.class, v)));
        applyIfPresent(dados, "populacaoEspecial", v -> n.getDadosEpidemiologicos().setPopulacaoEspecial(parseEnum(PopNacoesEspeciais.class, v)));
        applyIfPresent(dados, "formaTuberculose", v -> n.getDadosEpidemiologicos().setFormaTuberculose(parseEnum(FormaTuberculose.class, v)));
        applyIfPresent(dados, "localExtrapulmonar", v -> n.getDadosEpidemiologicos().setLocalExtrapulmonar(parseEnum(LocalExtrapulmonar.class, v)));
        applyIfPresent(dados, "resultadoBaciloscopiaDiagnostico", v -> n.getDadosEpidemiologicos().setResultadoBaciloscopiaDiagnostico(parseEnum(ResultadoBaciloscopiaDiagnostico.class, v)));
        applyIfPresent(dados, "resultadoRadiografiaTorax", v -> n.getDadosEpidemiologicos().setResultadoRadiografiaTorax(parseEnum(ResultadoRadiografiaTorax.class, v)));
        applyIfPresent(dados, "resultadoHiv", v -> n.getDadosEpidemiologicos().setResultadoHiv(parseEnum(ResultadoHIV.class, v)));
        applyIfPresent(dados, "resultadoHistopatologia", v -> n.getDadosEpidemiologicos().setResultadoHistopatologia(parseEnum(ResultadoHistopatologia.class, v)));
        applyIfPresent(dados, "resultadoCultura", v -> n.getDadosEpidemiologicos().setResultadoCultura(parseEnum(ResultadoCultura.class, v)));
        applyIfPresent(dados, "resultadoTesteMolecularRapido", v -> n.getDadosEpidemiologicos().setResultadoTesteMolecularRapido(parseEnum(ResultadoTesteMolecularRapido.class, v)));
        applyIfPresent(dados, "resultadoTesteSensibilidade", v -> n.getDadosEpidemiologicos().setResultadoTesteSensibilidade(parseEnum(ResultadoTesteSensibilidade.class, v)));

        applyIfPresent(dados, "modoEntradaHanseniase", v -> n.getDadosEpidemiologicos().setModoEntradaHanseniase(parseEnum(ModoEntradaHanseniase.class, v)));
        applyIfPresent(dados, "modoDeteccao", v -> n.getDadosEpidemiologicos().setModoDeteccao(parseEnum(ModoDeteccaoCasoNovo.class, v)));
        applyIfPresent(dados, "resultadoBaciloscopiaHanseniase", v -> n.getDadosEpidemiologicos().setResultadoBaciloscopiaHanseniase(parseEnum(ResultadoBaciloscopiaHanseniase.class, v)));
    }

    private static void applyIfPresent(Map<String, String> map, String key, Consumer<String> consumer) {
        if (map.containsKey(key) && map.get(key) != null && !map.get(key).isEmpty() && !map.get(key).equals("null")) {
            consumer.accept(map.get(key));
        }
    }
}