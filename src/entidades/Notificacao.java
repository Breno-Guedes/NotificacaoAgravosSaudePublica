package entidades;

import entidadesDeDados.*;
import java.util.*;

public abstract class Notificacao {
    protected static Integer contadorCodigo = 1;
    protected Integer codigo;
    protected DadosGerais dadosGerais;
    protected DadosIndividuais dadosIndividuais;
    protected DadosResidenciais dadosResidenciais;
    protected DadosEpidemiologicos dadosEpidemiologicos;
    protected DadosTratamento dadosTratamento;
    protected ConclusaoEncerramento conclusaoEncerramento;

    Scanner scanner = new Scanner(System.in);

    public abstract void registrarNotificacao(Scanner scanner);
    public abstract void consultarNotificacao(Scanner scanner);
    public abstract void gerarRelatorio();


    // Getters and Setters
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

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
