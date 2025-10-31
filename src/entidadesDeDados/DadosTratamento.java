package entidadesDeDados;

import java.time.LocalDate;
import enums.hanseniase.EsquemaTerapeuticoInicial;
import enums.malaria.EsquemaTratamento;

public class DadosTratamento {
    private EsquemaTratamento esquemaTratamento;
    private LocalDate dataInicioTratamento;
    private EsquemaTerapeuticoInicial esquemaTerapeuticoInicial;

    public DadosTratamento(){

    }
    public DadosTratamento(
            EsquemaTratamento esquemaTratamento,
            LocalDate dataInicioTratamento, EsquemaTerapeuticoInicial esquemaTerapeuticoInicial) {

        this.esquemaTratamento = esquemaTratamento;
        this.dataInicioTratamento = dataInicioTratamento;
        this.esquemaTerapeuticoInicial = esquemaTerapeuticoInicial;
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

    public EsquemaTerapeuticoInicial getEsquemaTerapeuticoInicial() {
        return esquemaTerapeuticoInicial;
    }

    public void setEsquemaTerapeuticoInicial(EsquemaTerapeuticoInicial esquemaTerapeuticoInicial) {
        this.esquemaTerapeuticoInicial = esquemaTerapeuticoInicial;
    }

}