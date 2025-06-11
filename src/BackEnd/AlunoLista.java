package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AlunoLista implements Serializable {

    private ArrayList<Aluno> lista;

    public AlunoLista() {
        lista = new ArrayList<>();
    }

    public void inserir(Aluno a) {
        lista.add(a);
    }
    
    public void remover(Aluno a) {
        lista.remove(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Aluno a : lista) {
            sb.append("|");
            sb.append(a.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String paraString() {
        StringBuilder sb = new StringBuilder();
        for (Aluno a : lista) {
            sb.append(a.getNome());
            sb.append(",");
        }
        if (sb.toString() != null) {
            return sb.toString();
        }
        return "";
    }

    public int contarAlunos() {
        int total = 0;
        for (Aluno a : lista) {
            total++;
        }
        return total;
    }

    public boolean estavaPresenteAluno(Aluno a1) {
        for (Aluno a2 : lista) {
            if (a1 == a2) {
                return true;
            }
        }
        return false;
    }

    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Aluno.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    public void carregarFicheiroObjetos() throws IOException, Exception {
        try (FileInputStream file = new FileInputStream("Aluno.txt"); ObjectInputStream oin = new ObjectInputStream(file)) {
            lista = (ArrayList<Aluno>) oin.readObject();
        } catch (IOException e) {
            System.out.println("Erro no acesso aos ficheiros");
        }
    }
    
    public Aluno devolveAluno(String nome) {
        for (Aluno a : lista) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        Aluno a = new Aluno("Indefinido");
        return a;
    }
    
    public boolean apagarAluno(String nome) {
        for(Aluno a : lista)
            if(a.getNome().equals(nome)) {
                remover(a);
                return true;
            }
        return false;
    }
    
    public boolean procuraAluno(Aluno aluno) {
        for(Aluno a : lista)
            if(aluno.equals(a))
                return true;
        return false;                
    }
}
