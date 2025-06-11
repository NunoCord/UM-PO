package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Sumario implements Serializable {

    private String titulo;
    private String texto;
    private Professor professor;
    private Uc cadeira;
    private AlunoLista presenca;
    private LocalDate data;

    public Sumario() {
    }

    public Sumario(String novoTitulo) {
        setTitulo(novoTitulo);
    }

    public Sumario(String novoTitulo, String novoTexto, Professor novoProfessor, Uc novaCadeira) {
        setTitulo(novoTitulo);
        setTexto(novoTexto);
        setProfessor(novoProfessor);
        setCadeira(novaCadeira);
    }

    public Sumario(String novoTitulo, String novoTexto, Professor novoProfessor, Uc novaCadeira, AlunoLista novaPresenca, LocalDate novaData) {
        setTitulo(novoTitulo);
        setTexto(novoTexto);
        setProfessor(novoProfessor);
        setCadeira(novaCadeira);
        setPresenca(novaPresenca);
        setData(novaData);
    }

    public void setTitulo(String novoTitulo) {
        titulo = novoTitulo;
    }

    public void setTexto(String novoTexto) {
        texto = novoTexto;
    }

    public void setProfessor(Professor novoProfessor) {
        professor = novoProfessor;
    }

    public void setCadeira(Uc novaCadeira) {
        cadeira = novaCadeira;
    }

    public void setPresenca(AlunoLista novaPresenca) {
        presenca = novaPresenca;
    }
    
    public void setnovoAluno(Aluno novoAluno) {
        presenca.inserir(novoAluno);
    }
    
    public void removeAluno(Aluno novoAluno) {
        presenca.remover(novoAluno);
    }

    public void setData(LocalDate novaData) {
        data = novaData;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Uc getCadeira() {
        return cadeira;
    }

    public AlunoLista getPresenca() {
        if (presenca != null) {
            return presenca;
        }
        AlunoLista a = new AlunoLista();
        return a;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\t|Texto: " + texto + "\t|Professor: " + professor.getNome() + "\t|Uc: " + cadeira.getDesignacao() + "\t|Data: " + data;
    }
}
