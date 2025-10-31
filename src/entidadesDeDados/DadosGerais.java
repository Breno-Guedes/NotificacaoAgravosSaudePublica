package entidadesDeDados;

import enums.gerais.Doenca;
import java.time.LocalDate;

public class DadosGerais {
  private Doenca agravo;
  private LocalDate dataNotificacao;
  private String uf;
  private String municipio;
  private String ubs;
  private LocalDate dataSintomas;

  public DadosGerais() {
  }

  DadosGerais(
      Doenca agravo,
      LocalDate dataNotificacao,
      String uf,
      String municipio,
      String ubs,
      LocalDate dataSintomas) {

    this.agravo = agravo;
    this.dataNotificacao = dataNotificacao;
    this.uf = uf;
    this.municipio = municipio;
    this.ubs = ubs;
    this.dataSintomas = dataSintomas;
  }

  // ------- getters e setters ------- // 

  public Doenca getAgravo() {
    return agravo;
  }
  public void setAgravo(Doenca agravo) {
    this.agravo = agravo;
  }

  public LocalDate getDataNotificacao() {
    return dataNotificacao;
  }
  public void setDataNotificacao(LocalDate dataNotificacao) {
    this.dataNotificacao = dataNotificacao;
  }

  public String getUf() {
    return uf;
  }
  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getMunicipio() {
    return municipio;
  }
  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public String getUbs() {
    return ubs;
  }
  public void setUbs(String ubs) {
    this.ubs = ubs;
  }

  public LocalDate getDataSintomas() {
    return dataSintomas;
  }
  public void setDataSintomas(LocalDate dataSintomas) {
    this.dataSintomas = dataSintomas;
  }

}
