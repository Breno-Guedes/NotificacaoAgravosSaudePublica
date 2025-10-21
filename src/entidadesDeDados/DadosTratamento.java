package entidadesDeDados;

import java.time.LocalDate;

import enums.*;

public class DadosTratamento {

  private EsquemaTratamento esquemaTratamento;
  private LocalDate dataInicioTratamento;

  public DadosTratamento() {

    this.esquemaTratamento = esquemaTratamento;
    this.dataInicioTratamento = dataInicioTratamento;
  }

  // --- setters e getters --- //

  public void setEsquemaTratamento(EsquemaTratamento esquemaTratamento) {
    this.esquemaTratamento = esquemaTratamento;
  }
  public EsquemaTratamento getEsquemaTratamento() {
    return esquemaTratamento;
  }

  public void setDataInicioTratamento(LocalDate dataInicioTratamento) {
    this.dataInicioTratamento = dataInicioTratamento;
  }
  public LocalDate getDataInicioTratamento() {
    return dataInicioTratamento;
  }

}
