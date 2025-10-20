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

  public DadosEpidemiologicos(
      LocalDate dataInvestigacao,
      String ocupacao,
      AtividadesUltimos15Dias atividade,
      String dadosDoExame,
      TiposLamina tipoLamina,
      Sintomas sintomas,
      LocalDate dataExame,
      ResultadoExame resultadoExame,
      Float parasitasMetroCubico,
      Parasitemia parasitemia) {

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
  }

  // --- setters e getters --- //

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

}
