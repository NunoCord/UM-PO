package BackEnd;

import java.io.Serializable;

public class Curso implements Serializable {

    private String designacao;
    private UcLista uc;
    private Professor diretor;
    private AlunoLista alunos;

    public Curso() {
    }

    public Curso(String novaDesignacao) {
        setDesignacao(novaDesignacao);
        setUc(new UcLista());
        setDiretor(new Professor("Indefinido"));
        setAlunos(new AlunoLista());
    }

    public Curso(String novaDesignacao, UcLista novaUc, Professor novoDiretor, AlunoLista novoAlunos) {
        setDesignacao(novaDesignacao);
        setUc(novaUc);
        setDiretor(novoDiretor);
        setAlunos(novoAlunos);
    }

    public void setDesignacao(String novaDesignacao) {
        designacao = novaDesignacao;
    }

    public void setUc(UcLista novaUc) {
        uc = novaUc;
    }
    
    public void setnovaUc(Uc novaUc) {
        uc.inserir(novaUc);
    }
    
    public void removeUc(Uc novaUc) {
        uc.remover(novaUc);
    }

    public void setDiretor(Professor novoDiretor) {
        diretor = novoDiretor;
    }

    public void setAlunos(AlunoLista novoAluno) {
        alunos = novoAluno;
    }
    
    public void setnovoAluno(Aluno novoAluno) {
        alunos.inserir(novoAluno);
    }
    
    public void removeAluno(Aluno novoAluno) {
        alunos.remover(novoAluno);
    }

    public String getDesignacao() {
        return designacao;
    }

    public UcLista getUc() {
        return uc;
    }

    public Professor getDiretor() {
        return diretor;
    }

    public AlunoLista getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Nome do curso: " + designacao + "\t|Ucs do curso: " + uc.paraString() + "\t|Diretor do curso: " + diretor.getNome() + "\t|Alunos: " + alunos.paraString();
    }

    public int numeroAlunos() {
        return getAlunos().contarAlunos();
    }
    
    public int numeroProfessores() {
        return getUc().contarProfessores();
    }
}
