package BackEnd;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome;
    private String codigo;
    private Curso curso;

    public Aluno() {
    }

    public Aluno(String novoNome) {
        setNome(novoNome);
    }

    public Aluno(String novoNome, String novoCodigo, Curso novoCurso) {
        setNome(novoNome);
        setCodigo(novoCodigo);
        setCurso(novoCurso);
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setCodigo(String novoCodigo) {
        codigo = novoCodigo;
    }

    public void setCurso(Curso novoCurso) {
        curso = novoCurso;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Curso getCurso() {
        return curso;
    }   

    @Override
    public String toString() {
        return "Nome: " + nome + "\t|Codigo: " + codigo + "\t|Curso: " + curso.getDesignacao();
    }
}
