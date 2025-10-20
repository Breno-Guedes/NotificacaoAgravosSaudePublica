package entidades;

import entidadesDeDados.*;

public abstract class Notificacao {
    protected Integer codigo = 1;
    protected DadosGerais dadosGerais;
    protected DadosIndividuais dadosIndividuais;
    protected DadosResidenciais dadosResidenciais;
    protected DadosEpidemiologicos dadosEpidemiologicos;
    protected DadosTratamento dadosTratamento;
    protected ConclusaoEncerramento conclusaoEncerramento;

    public abstract void registrarNotificacao();
    public abstract void gerarRelatorio();

    public String gerarResumo() {
        return "Paciente: " + dadosIndividuais.getNome() +
               "Idade: " + dadosIndividuais.getIdade() +
               "Diagnóstico: " + dadosEpidemiologicos.getDadosDoExame();
    }


    // Getters and Setters
    public DadosGerais getDadosGerais() {
        return dadosGerais;
    }

    public void setDadosGerais(DadosGerais dadosGerais) {
        this.dadosGerais = dadosGerais;
    }

    public DadosIndividuais getDadosIndividuais() {
        return dadosIndividuais;
    }

    public void setDadosIndividuais(DadosIndividuais dadosIndividuais) {
        this.dadosIndividuais = dadosIndividuais;
    }

    public DadosResidenciais getDadosResidenciais() {
        return dadosResidenciais;
    }

    public void setDadosResidenciais(DadosResidenciais dadosResidenciais) {
        this.dadosResidenciais = dadosResidenciais;
    }

    public DadosEpidemiologicos getDadosEpidemiologicos() {
        return dadosEpidemiologicos;
    }

    public void setDadosEpidemiologicos(DadosEpidemiologicos dadosEpidemiologicos) {
        this.dadosEpidemiologicos = dadosEpidemiologicos;
    }

    public DadosTratamento getDadosTratamento() {
        return dadosTratamento;
    }

    public void setDadosTratamento(DadosTratamento dadosTratamento) {
        this.dadosTratamento = dadosTratamento;
    }

    public ConclusaoEncerramento getConclusaoEncerramento() {
        return conclusaoEncerramento;
    }

    public void setConclusaoEncerramento(ConclusaoEncerramento conclusaoEncerramento) {
        this.conclusaoEncerramento = conclusaoEncerramento;
    }
}
