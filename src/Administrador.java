import java.util.ArrayList;


public class Administrador {
    private final String nome;
    private final String senha;
    private ArrayList<Professor> listaProfessores;

    public Administrador(String senha) {
        this.nome = "admin";
        this.senha = "admin123";
        listaProfessores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean validarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }

        public void adicionarProfessor(Professor professor) {
        listaProfessores.add(professor);
    }

    public void apagarProfessor(Professor professor) {
        listaProfessores.remove(professor);
    }

    public void alterarInformacoes(Professor professor, String novoNome, String novoCodigo, String novaUc) {
        professor.setNome(novoNome);
        professor.setCodigo(novoCodigo);
        professor.setUc(novaUc);
    }

    public ArrayList<Professor> obterListaProfessores() {
        return listaProfessores;
    }
}