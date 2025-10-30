package entidadesDeDados;

import enums.*;
import java.time.LocalDate;

public class DadosEpidemiologicos {

    private LocalDate dataInvestigacao;
    private String ocupacao;
    private AtividadesUltimos15Dias atividade;
    private String dadosDoExame;
    private TiposLamina tipoLamina;
    private Sintomas sintomas;
    private LocalDate dataExame;
    private ResultadoExame resultadoExame;
    private Float parasitasMetroCubico;
    private Parasitemia parasitemia;
    private TipoDeEntradaTuberculose tipoEntrada;
    private PopNacoesEspeciais populacaoEspecial;
    private FormaTuberculose formaTuberculose;
    private LocalExtrapulmonar localExtrapulmonar;
    private ResultadoBaciloscopiaDiagnostico resultadoBaciloscopiaDiagnostico;
    private ResultadoRadiografiaTorax resultadoRadiografiaTorax;
    private ResultadoHIV resultadoHiv;
    private ResultadoHistopatologia resultadoHistopatologia;
    private ResultadoCultura resultadoCultura;
    private ResultadoTesteMolecularRapido resultadoTesteMolecularRapido;
    private ResultadoTesteSensibilidade resultadoTesteSensibilidade;
    private ModoEntradaHanseniase modoEntradaHanseniase;
    private ModoDeteccaoCasoNovo modoDeteccao;
    private ResultadoBaciloscopiaHanseniase resultadoBaciloscopiaHanseniase;

    public DadosEpidemiologicos(){}

    public DadosEpidemiologicos(LocalDate dataInvestigacao,
                                String ocupacao,
                                AtividadesUltimos15Dias atividade,
                                String dadosDoExame,
                                TiposLamina tipoLamina,
                                Sintomas sintomas,
                                LocalDate dataExame,
                                ResultadoExame resultadoExame,
                                Float parasitasMetroCubico,
                                Parasitemia parasitemia,
                                TipoDeEntradaTuberculose tipoEntrada,
                                PopNacoesEspeciais populacaoEspecial,
                                FormaTuberculose formaTuberculose,
                                LocalExtrapulmonar localExtrapulmonar,
                                ResultadoBaciloscopiaDiagnostico resultadoBaciloscopiaDiagnostico,
                                ResultadoRadiografiaTorax resultadoRadiografiaTorax,
                                ResultadoHIV resultadoHiv,
                                ResultadoHistopatologia resultadoHistopatologia,
                                ResultadoCultura resultadoCultura,
                                ResultadoTesteMolecularRapido resultadoTesteMolecularRapido,
                                ResultadoTesteSensibilidade resultadoTesteSensibilidade,
                                ModoEntradaHanseniase modoEntradaHanseniase,
                                ModoDeteccaoCasoNovo modoDeteccao,
                                ResultadoBaciloscopiaHanseniase resultadoBaciloscopiaHanseniase) {

        this.dataInvestigacao = dataInvestigacao;
        this.ocupacao = ocupacao;
        this.atividade = atividade;
        this.dadosDoExame = dadosDoExame;
        this.tipoLamina = tipoLamina;
        this.sintomas = sintomas;
        this.dataExame = dataExame;
        this.resultadoExame = resultadoExame;
        this.parasitasMetroCubico = parasitasMetroCubico;
        this.parasitemia = parasitemia;
        this.tipoEntrada = tipoEntrada;
        this.populacaoEspecial = populacaoEspecial;
        this.formaTuberculose = formaTuberculose;
        this.localExtrapulmonar = localExtrapulmonar;
        this.resultadoBaciloscopiaDiagnostico = resultadoBaciloscopiaDiagnostico;
        this.resultadoRadiografiaTorax = resultadoRadiografiaTorax;
        this.resultadoHiv = resultadoHiv;
        this.resultadoHistopatologia = resultadoHistopatologia;
        this.resultadoCultura = resultadoCultura;
        this.resultadoTesteMolecularRapido = resultadoTesteMolecularRapido;
        this.resultadoTesteSensibilidade = resultadoTesteSensibilidade;
        this.modoEntradaHanseniase = modoEntradaHanseniase;
        this.modoDeteccao = modoDeteccao;
        this.resultadoBaciloscopiaHanseniase = resultadoBaciloscopiaHanseniase;
    }

    // --- getters e setters --- //

    public LocalDate getDataInvestigacao() {
        return dataInvestigacao;
    }

    public void setDataInvestigacao(LocalDate dataInvestigacao) {
        this.dataInvestigacao = dataInvestigacao;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public AtividadesUltimos15Dias getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadesUltimos15Dias atividade) {
        this.atividade = atividade;
    }

    public String getDadosDoExame() {
        return dadosDoExame;
    }

    public void setDadosDoExame(String dadosDoExame) {
        this.dadosDoExame = dadosDoExame;
    }

    public TiposLamina getTipoLamina() {
        return tipoLamina;
    }

    public void setTipoLamina(TiposLamina tipoLamina) {
        this.tipoLamina = tipoLamina;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
    }

    public ResultadoExame getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(ResultadoExame resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public Float getParasitasMetroCubico() {
        return parasitasMetroCubico;
    }

    public void setParasitasMetroCubico(Float parasitasMetroCubico) {
        this.parasitasMetroCubico = parasitasMetroCubico;
    }

    public Parasitemia getParasitemia() {
        return parasitemia;
    }

    public void setParasitemia(Parasitemia parasitemia) {
        this.parasitemia = parasitemia;
    }

    public TipoDeEntradaTuberculose getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoDeEntradaTuberculose tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public PopNacoesEspeciais getPopulacaoEspecial() {
        return populacaoEspecial;
    }

    public void setPopulacaoEspecial(PopNacoesEspeciais populacaoEspecial) {
        this.populacaoEspecial = populacaoEspecial;
    }

    public FormaTuberculose getFormaTuberculose() {
        return formaTuberculose;
    }

    public void setFormaTuberculose(FormaTuberculose formaTuberculose) {
        this.formaTuberculose = formaTuberculose;
    }

    public LocalExtrapulmonar getLocalExtrapulmonar() {
        return localExtrapulmonar;
    }

    public void setLocalExtrapulmonar(LocalExtrapulmonar localExtrapulmonar) {
        this.localExtrapulmonar = localExtrapulmonar;
    }

    public ResultadoBaciloscopiaDiagnostico getResultadoBaciloscopiaDiagnostico() {
        return resultadoBaciloscopiaDiagnostico;
    }

    public void setResultadoBaciloscopiaDiagnostico(ResultadoBaciloscopiaDiagnostico resultadoBaciloscopiaDiagnostico) {
        this.resultadoBaciloscopiaDiagnostico = resultadoBaciloscopiaDiagnostico;
    }

    public ResultadoRadiografiaTorax getResultadoRadiografiaTorax() {
        return resultadoRadiografiaTorax;
    }

    public void setResultadoRadiografiaTorax(ResultadoRadiografiaTorax resultadoRadiografiaTorax) {
        this.resultadoRadiografiaTorax = resultadoRadiografiaTorax;
    }

    public ResultadoHIV getResultadoHiv() {
        return resultadoHiv;
    }

    public void setResultadoHiv(ResultadoHIV resultadoHiv) {
        this.resultadoHiv = resultadoHiv;
    }

    public ResultadoHistopatologia getResultadoHistopatologia() {
        return resultadoHistopatologia;
    }

    public void setResultadoHistopatologia(ResultadoHistopatologia resultadoHistopatologia) {
        this.resultadoHistopatologia = resultadoHistopatologia;
    }

    public ResultadoCultura getResultadoCultura() {
        return resultadoCultura;
    }

    public void setResultadoCultura(ResultadoCultura resultadoCultura) {
        this.resultadoCultura = resultadoCultura;
    }

    public ResultadoTesteMolecularRapido getResultadoTesteMolecularRapido() {
        return resultadoTesteMolecularRapido;
    }

    public void setResultadoTesteMolecularRapido(ResultadoTesteMolecularRapido resultadoTesteMolecularRapido) {
        this.resultadoTesteMolecularRapido = resultadoTesteMolecularRapido;
    }

    public ResultadoTesteSensibilidade getResultadoTesteSensibilidade() {
        return resultadoTesteSensibilidade;
    }

    public void setResultadoTesteSensibilidade(ResultadoTesteSensibilidade resultadoTesteSensibilidade) {
        this.resultadoTesteSensibilidade = resultadoTesteSensibilidade;
    }

    public ModoEntradaHanseniase getModoEntradaHanseniase() {
        return modoEntradaHanseniase;
    }

    public void setModoEntradaHanseniase(ModoEntradaHanseniase modoEntradaHanseniase) {
        this.modoEntradaHanseniase = modoEntradaHanseniase;
    }

    public ModoDeteccaoCasoNovo getModoDeteccao() {
        return modoDeteccao;
    }

    public void setModoDeteccao(ModoDeteccaoCasoNovo modoDeteccao) {
        this.modoDeteccao = modoDeteccao;
    }

    public ResultadoBaciloscopiaHanseniase getResultadoBaciloscopiaHanseniase() {
        return resultadoBaciloscopiaHanseniase;
    }

    public void setResultadoBaciloscopiaHanseniase(ResultadoBaciloscopiaHanseniase resultadoBaciloscopiaHanseniase) {
        this.resultadoBaciloscopiaHanseniase = resultadoBaciloscopiaHanseniase;
    }

}