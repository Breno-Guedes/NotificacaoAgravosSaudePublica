package entidadesDeDados;

import enums.*;

public class DadosResidenciais {
  private String uf;
  private String municipio;
  private String distrito;
  private String bairro;
  private String logradouro;
  private String numero;
  private Integer cep;
  private Integer ddd;
  private Zona zona;

  public DadosResidenciais(
      String uf,
      String municipio,
      String distrito,
      String bairro,
      String logradouro,
      String numero,
      Integer cep,
      Integer ddd,
      Zona zona) {
    this.uf = uf;
    this.municipio = municipio;
    this.distrito = distrito;
    this.bairro = bairro;
    this.logradouro = logradouro;
    this.numero = numero;
    this.cep = cep;
    this.ddd = ddd;
    this.zona = zona;
  }

  // --- setters e getters ---

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

  public String getDistrito() {
    return distrito;
  }
  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLogradouro() {
    return logradouro;
  }
  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }
  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Integer getCep() {
    return cep;
  }
  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public Integer getDdd() {
    return ddd;
  }
  public void setDdd(Integer ddd) {
    this.ddd = ddd;
  }

  public Zona getZona() {
    return zona;
  }
  public void setZona(Zona zona) {
    this.zona = zona;
  }

}
