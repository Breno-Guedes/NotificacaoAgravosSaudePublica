package GerenciadorDeArquivos;

import entidades.*;
import entidadesDeDados.*;
import enums.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class GerenciadorDeArquivos {

    private static final String DIR = "database/";
    private static final String MALARIA_FILE = DIR + "malaria.txt";
    private static final String HANSENIASE_FILE = DIR + "hansieniase.txt";
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
        carregarArquivo(MALARIA_FILE, NotificacaoMalaria.todasNotificacoes, GerenciadorDeArquivos::parseMalaria);
        carregarArquivo(HANSENIASE_FILE, NotificacaoHansieniase.todasNotificacoes, GerenciadorDeArquivos::parseHanseniase);
        carregarArquivo(TUBERCULOSE_FILE, NotificacaoTuberculose.todasNotificacoes, GerenciadorDeArquivos::parseTuberculose);

        int maxCodigo = Math.max(
                NotificacaoMalaria.todasNotificacoes.stream().mapToInt(Notificacao::getCodigo).max().orElse(0),
                Math.max(
                        NotificacaoHansieniase.todasNotificacoes.stream().mapToInt(Notificacao::getCodigo).max().orElse(0),
                        NotificacaoTuberculose.todasNotificacoes.stream().mapToInt(Notificacao::getCodigo).max().orElse(0)
                )
        );
        Notificacao.setContadorCodigo(maxCodigo + 1);
    }

    private static <T extends Notificacao> void carregarArquivo(String arquivo, List<T> lista, Function<Map<String, String>, T> parser) {
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
                        dados.put(chaveValor[0], ""); // Lida com valores nulos/vazios
                    }
                }
                lista.add(parser.apply(dados));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar notificações do arquivo " + arquivo + ": " + e.getMessage());
        }
    }

    private static String getArquivoPorInstancia(Notificacao n) {
        if (n instanceof NotificacaoMalaria) return MALARIA_FILE;
        if (n instanceof NotificacaoHansieniase) return HANSENIASE_FILE;
        if (n instanceof NotificacaoTuberculose) return TUBERCULOSE_FILE;
        return null;
    }

    private static String formatarParaSalvar(Notificacao n) {
        StringBuilder sb = new StringBuilder();
        // Dados Gerais
        append(sb, "codigo", n.getCodigo());
        append(sb, "dataNotificacao", n.getDadosGerais().getDataNotificacao());
        append(sb, "uf", n.getDadosGerais().getUf());
        append(sb, "municipio", n.getDadosGerais().getMunicipio());
        append(sb, "ubs", n.getDadosGerais().getUbs());
        append(sb, "dataSintomas", n.getDadosGerais().getDataSintomas());

        // Dados Individuais
        append(sb, "nome", n.getDadosIndividuais().getNome());
        append(sb, "dataNascimento", n.getDadosIndividuais().getDataNascimento());
        append(sb, "idade", n.getDadosIndividuais().getIdade());
        append(sb, "sexo", n.getDadosIndividuais().getSexo());
        append(sb, "gestante", n.getDadosIndividuais().getGestante());
        append(sb, "racaCor", n.getDadosIndividuais().getRacaCor());
        append(sb, "escolaridade", n.getDadosIndividuais().getEscolaridade());
        append(sb, "nomeMae", n.getDadosIndividuais().getNomeMae());

        // Dados Residenciais
        append(sb, "residenciaUf", n.getDadosResidenciais().getUf());
        append(sb, "residenciaMunicipio", n.getDadosResidenciais().getMunicipio());
        append(sb, "bairro", n.getDadosResidenciais().getBairro());
        append(sb, "logradouro", n.getDadosResidenciais().getLogradouro());
        append(sb, "numero", n.getDadosResidenciais().getNumero());
        append(sb, "cep", n.getDadosResidenciais().getCep());
        append(sb, "ddd", n.getDadosResidenciais().getDdd());
        append(sb, "zona", n.getDadosResidenciais().getZona());

        // Dados Epidemiológicos e Tratamento (se existirem)
        if (n.getDadosEpidemiologicos() != null) {
            append(sb, "dataInvestigacao", n.getDadosEpidemiologicos().getDataInvestigacao());
            append(sb, "ocupacao", n.getDadosEpidemiologicos().getOcupacao());
            append(sb, "dataExame", n.getDadosEpidemiologicos().getDataExame());
            append(sb, "resultadoExame", n.getDadosEpidemiologicos().getResultadoExame());
        }
        if (n instanceof NotificacaoMalaria nm) {
            append(sb, "atividade", nm.getDadosEpidemiologicos().getAtividade());
            append(sb, "tipoLamina", nm.getDadosEpidemiologicos().getTipoLamina());
            append(sb, "sintomas", nm.getDadosEpidemiologicos().getSintomas());
            append(sb, "parasitasMm3", nm.getDadosEpidemiologicos().getParasitasMetroCubico());
            append(sb, "parasitemia", nm.getDadosEpidemiologicos().getParasitemia());
            append(sb, "esquemaTratamento", nm.getDadosTratamento().getEsquemaTratamento());
        }
        if (n.getDadosTratamento() != null) {
            append(sb, "dataInicioTratamento", n.getDadosTratamento().getDataInicioTratamento());
        }

        // Conclusão
        append(sb, "classificacaoFinal", n.getConclusaoEncerramento().getClassificacaoFinal());
        append(sb, "dataEncerramento", n.getConclusaoEncerramento().getDataEncerramento());
        if (n instanceof NotificacaoMalaria nm) {
            append(sb, "autoctone", nm.getConclusaoEncerramento().getAutoctone());
            append(sb, "provavelUfInfeccao", nm.getConclusaoEncerramento().getProvavelUFinfeccao());
            append(sb, "provavelMunicipioInfeccao", nm.getConclusaoEncerramento().getProvavelMunicipioInfeccao());
        }

        return sb.toString();
    }

    private static void append(StringBuilder sb, String key, Object value) {
        sb.append(key).append("=").append(value == null ? "" : value.toString()).append(";");
    }

    private static <E extends Enum<E>> E parseEnum(Class<E> enumClass, String value) {
        if (value == null || value.isEmpty()) return null;
        try {
            return Enum.valueOf(enumClass, value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static NotificacaoMalaria parseMalaria(Map<String, String> dados) {
        NotificacaoMalaria n = new NotificacaoMalaria();
        preencherDadosComuns(n, dados);
        // Específico Malária
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

    private static NotificacaoHansieniase parseHanseniase(Map<String, String> dados) {
        NotificacaoHansieniase n = new NotificacaoHansieniase();
        preencherDadosComuns(n, dados);
        return n;
    }

    private static NotificacaoTuberculose parseTuberculose(Map<String, String> dados) {
        NotificacaoTuberculose n = new NotificacaoTuberculose();
        preencherDadosComuns(n, dados);
        return n;
    }

    private static void preencherDadosComuns(Notificacao n, Map<String, String> dados) {
        n.setCodigo(Integer.parseInt(dados.get("codigo")));
        n.setDadosGerais(new DadosGerais());
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
        applyIfPresent(dados, "ddd", v -> n.getDadosResidenciais().setDdd(Integer.parseInt(v)));
        applyIfPresent(dados, "zona", v -> n.getDadosResidenciais().setZona(parseEnum(Zona.class, v)));

        applyIfPresent(dados, "dataInvestigacao", v -> n.getDadosEpidemiologicos().setDataInvestigacao(LocalDate.parse(v)));
        applyIfPresent(dados, "ocupacao", v -> n.getDadosEpidemiologicos().setOcupacao(v));
        applyIfPresent(dados, "dataExame", v -> n.getDadosEpidemiologicos().setDataExame(LocalDate.parse(v)));
        applyIfPresent(dados, "resultadoExame", v -> n.getDadosEpidemiologicos().setResultadoExame(parseEnum(ResultadoExame.class, v)));

        applyIfPresent(dados, "dataInicioTratamento", v -> n.getDadosTratamento().setDataInicioTratamento(LocalDate.parse(v)));

        applyIfPresent(dados, "classificacaoFinal", v -> n.getConclusaoEncerramento().setClassificacaoFinal(parseEnum(ClassificacaoFinal.class, v)));
        applyIfPresent(dados, "dataEncerramento", v -> n.getConclusaoEncerramento().setDataEncerramento(LocalDate.parse(v)));
    }

    private static void applyIfPresent(Map<String, String> map, String key, Consumer<String> consumer) {
        if (map.containsKey(key) && map.get(key) != null && !map.get(key).isEmpty()) {
            consumer.accept(map.get(key));
        }
    }
}