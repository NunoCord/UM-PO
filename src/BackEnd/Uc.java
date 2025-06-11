package BackEnd;

import java.io.Serializable;

public class Uc implements Serializable {

    private String designacao;
    private ProfessorLista equipa;
    private Professor regente;
    private SumarioLista sumarios;

    public Uc() {
    }

    public Uc(String novaDesignacao) {
        setDesignacao(novaDesignacao);
        setEquipa(new ProfessorLista());
        setRegente(new Professor("Indefinido"));
        setSumario(new SumarioLista());
    }

    public Uc(String novaDesignacao, ProfessorLista novaEquipa, Professor novoRegente) {
        setDesignacao(novaDesignacao);
        setEquipa(novaEquipa);
        setRegente(novoRegente);
        setSumario(new SumarioLista());
    }

    public Uc(String novaDesignacao, ProfessorLista novaEquipa, Professor novoRegente, SumarioLista novoSumarios) {
        setDesignacao(novaDesignacao);
        setEquipa(novaEquipa);
        setRegente(novoRegente);
        setSumario(novoSumarios);
    }

    public void setDesignacao(String novaDesignacao) {
        designacao = novaDesignacao;
    }

    public void setEquipa(ProfessorLista novaEquipa) {
        equipa = novaEquipa;
    }
    
    public void setnovoProfessor(Professor novoProfessor) {
        equipa.inserir(novoProfessor);
    }
    
    public void removeProfessor(Professor novoProfessor) {
        equipa.remover(novoProfessor);
    }

    public void setRegente(Professor novoRegente) {
        regente = novoRegente;
    }

    public void setSumario(SumarioLista novoSumario) {
        sumarios = novoSumario;
    }
    
    public void setnovoSumario(Sumario novoSumario) {
        sumarios.inserir(novoSumario);
    }

    public String getDesignacao() {
        return designacao;
    }

    public ProfessorLista getEquipa() {
        return equipa;
    }

    public Professor getRegente() {
        return regente;
    }

    public SumarioLista getSumario() {
        if (sumarios != null) {
            return sumarios;
        }
        SumarioLista s = new SumarioLista();
        return s;
    }

    @Override
    public String toString() {
        return "Nome da Uc: " + designacao + "\t|Equipa da Uc: " + equipa.paraString() + "\t|Regente da Uc: " + regente.getNome();
    }

    public String presencaAluno(Aluno a) {
        return getSumario().escreverPresenca(a);
    }
}
