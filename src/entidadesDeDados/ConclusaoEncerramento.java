package entidadesDeDados;

import java.time.LocalDate;

import enums.*;

public class ConclusaoEncerramento {

  private ClassificacaoFinal classificacaoFinal;
  private Autoctone autoctone;
  private String provavelUFinfeccao;
  private String provavelPaisInfeccao;
  private String provavelMunicipioInfeccao;
  private LocalDate dataEncerramento;
  private String matriculaExaminador;
  private String nomeExaminador;

  ConclusaoEncerramento(
      ClassificacaoFinal classificacaoFinal,
      Autoctone autoctone,
      String provavelUFinfeccao,
      String provavelPaisInfeccao,
      String provavelMunicipioInfeccao,
      LocalDate dataEncerramento,
      String matriculaExaminador,
      String nomeExaminador) {

    this.classificacaoFinal = classificacaoFinal;
    this.autoctone = autoctone;
    this.provavelUFinfeccao = provavelUFinfeccao;
    this.provavelPaisInfeccao = provavelPaisInfeccao;
    this.provavelMunicipioInfeccao = provavelMunicipioInfeccao;
    this.dataEncerramento = dataEncerramento;
    this.matriculaExaminador = matriculaExaminador;
    this.nomeExaminador = nomeExaminador;
  }

  // --- setters and getters --- //
  
  public void setClassificacaoFinal(ClassificacaoFinal classificacaoFinal) {
    this.classificacaoFinal = classificacaoFinal;
  }
  public ClassificacaoFinal getClassificacaoFinal() {
    return classificacaoFinal;
  }

  public void setAutoctone(Autoctone autoctone) {
    this.autoctone = autoctone;
  }
  public Autoctone getAutoctone() {
    return autoctone;
  }

  public void setProvavelUFinfeccao(String provavelUFinfeccao) {
    this.provavelUFinfeccao = provavelUFinfeccao;
  }
  public String getProvavelUFinfeccao() {
    return provavelUFinfeccao;
  }

  public void setProvavelPaisInfeccao(String provavelPaisInfeccao) {
    this.provavelPaisInfeccao = provavelPaisInfeccao;
  }
  public String getProvavelPaisInfeccao() {
    return provavelPaisInfeccao;
  }

  public void setProvavelMunicipioInfeccao(String provavelMunicipioInfeccao) {
    this.provavelMunicipioInfeccao = provavelMunicipioInfeccao;
  }
  public String getProvavelMunicipioInfeccao() {
    return provavelMunicipioInfeccao;
  }

  public void setDataEncerramento(LocalDate dataEncerramento) {
    this.dataEncerramento = dataEncerramento;
  }
  public LocalDate getDataEncerramento() {
    return dataEncerramento;
  }

  public void setNomeExaminador(String nomeExaminador) {
    this.nomeExaminador = nomeExaminador;
  }
  public String getNomeExaminador() {
    return nomeExaminador;
  }

  public void setMatriculaExaminador(String matriculaExaminador) {
    this.matriculaExaminador = matriculaExaminador;
  }
  public String getMatriculaExaminador() {
    return matriculaExaminador;
  }

}
