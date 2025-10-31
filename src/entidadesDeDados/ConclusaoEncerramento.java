package entidadesDeDados;

import enums.gerais.ClassificacaoFinal;
import enums.hanseniase.ClassificacaoOperacionalHanseniase;
import enums.hanseniase.FormaClinicaHanseniase;
import enums.hanseniase.GrauIncapacidadeFisica;
import enums.malaria.Autoctone;

import java.time.LocalDate;

public class ConclusaoEncerramento {

    private ClassificacaoFinal classificacaoFinal;
    private Autoctone autoctone;
    private String provavelUFinfeccao;
    private String provavelPaisInfeccao;
    private String provavelMunicipioInfeccao;
    private LocalDate dataEncerramento;
    private String matriculaExaminador;
    private String nomeExaminador;
    private FormaClinicaHanseniase formaClinicaHanseniase;
    private ClassificacaoOperacionalHanseniase classificacaoOperacionalHanseniase;
    private GrauIncapacidadeFisica grauIncapacidadeFisica;

    public ConclusaoEncerramento() {

    }

    public ConclusaoEncerramento(ClassificacaoFinal classificacaoFinal,
                                 Autoctone autoctone,
                                 String provavelUFinfeccao,
                                 String provavelPaisInfeccao,
                                 String provavelMunicipioInfeccao,
                                 LocalDate dataEncerramento,
                                 String matriculaExaminador,
                                 String nomeExaminador,
                                 FormaClinicaHanseniase formaClinicaHanseniase,
                                 ClassificacaoOperacionalHanseniase classificacaoOperacionalHanseniase,
                                 GrauIncapacidadeFisica grauIncapacidadeFisica) {

        this.classificacaoFinal = classificacaoFinal;
        this.autoctone = autoctone;
        this.provavelUFinfeccao = provavelUFinfeccao;
        this.provavelPaisInfeccao = provavelPaisInfeccao;
        this.provavelMunicipioInfeccao = provavelMunicipioInfeccao;
        this.dataEncerramento = dataEncerramento;
        this.matriculaExaminador = matriculaExaminador;
        this.nomeExaminador = nomeExaminador;
        this.formaClinicaHanseniase = formaClinicaHanseniase;
        this.classificacaoOperacionalHanseniase = classificacaoOperacionalHanseniase;
        this.grauIncapacidadeFisica = grauIncapacidadeFisica;
    }

    public Autoctone getAutoctone() {
        return autoctone;
    }

    public void setAutoctone(Autoctone autoctone) {
        this.autoctone = autoctone;
    }

    public String getProvavelUFinfeccao() {
        return provavelUFinfeccao;
    }

    public void setProvavelUFinfeccao(String provavelUFinfeccao) {
        this.provavelUFinfeccao = provavelUFinfeccao;
    }

    public String getMatriculaExaminador() {
        return matriculaExaminador;
    }

    public void setMatriculaExaminador(String matriculaExaminador) {
        this.matriculaExaminador = matriculaExaminador;
    }

    public String getNomeExaminador() {
        return nomeExaminador;
    }

    public void setNomeExaminador(String nomeExaminador) {
        this.nomeExaminador = nomeExaminador;
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

    public ClassificacaoFinal getClassificacaoFinal() {
        return classificacaoFinal;
    }

    public void setClassificacaoFinal(ClassificacaoFinal classificacaoFinal) {
        this.classificacaoFinal = classificacaoFinal;
    }

    public FormaClinicaHanseniase getFormaClinicaHanseniase() {
        return formaClinicaHanseniase;
    }

    public void setFormaClinicaHanseniase(FormaClinicaHanseniase formaClinicaHanseniase) {
        this.formaClinicaHanseniase = formaClinicaHanseniase;
    }

    public ClassificacaoOperacionalHanseniase getClassificacaoOperacionalHanseniase() {
        return classificacaoOperacionalHanseniase;
    }

    public void setClassificacaoOperacionalHanseniase(ClassificacaoOperacionalHanseniase classificacaoOperacionalHanseniase) {
        this.classificacaoOperacionalHanseniase = classificacaoOperacionalHanseniase;
    }

    public GrauIncapacidadeFisica getGrauIncapacidadeFisica() {
        return grauIncapacidadeFisica;
    }

    public void setGrauIncapacidadeFisica(GrauIncapacidadeFisica grauIncapacidadeFisica) {
        this.grauIncapacidadeFisica = grauIncapacidadeFisica;
    }

}