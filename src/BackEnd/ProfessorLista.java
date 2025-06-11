package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ProfessorLista implements Serializable {

    private ArrayList<Professor> lista;

    public ProfessorLista() {
        lista = new ArrayList<>();
    }

    public void inserir(Professor p) {
        lista.add(p);
    }
    
    public void remover(Professor e) {
        lista.remove(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Professor p : lista) {
            sb.append("|");
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String paraString() {
        StringBuilder sb = new StringBuilder();
        for (Professor p : lista) {
            sb.append(p.getNome());
            sb.append(",");
        }
        if (sb.toString() != null) {
            return sb.toString();
        }
        return "";
    }

    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Professor.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    public void carregarFicheiroObjetos() throws IOException, Exception {
        try (FileInputStream file = new FileInputStream("Professor.txt"); ObjectInputStream oin = new ObjectInputStream(file)) {
            lista = (ArrayList<Professor>) oin.readObject();
        } catch (IOException e) {
            System.out.println("Erro no acesso aos ficheiros");
        }
    }

    public Professor devolveProfessor(String designacao) {
        for (Professor p : lista) {
            if (p.getNome().equals(designacao)) {
                return p;
            }
        }
        Professor p = new Professor("Indefinido");
        return p;
    }
    
    public int contarProfessores() {
        int total = 0;
        for (Professor p : lista) {
            total++;
        }
        return total;
    }
    
    public boolean apagarProfessor(String codigo) {
        for(Professor p : lista)
            if(p.getCodigo().equals(codigo)) {
                remover(p);
                return true;
            }
        return false;
    }
    
    public Professor procurarConta(String username, String password) {
        for(Professor p : lista)
            if(p.getUsername().equals(username) && p.getPassword().equals(password))
                return p;
        return new Professor("Indefinido");
    }
    
    public boolean procuraProfessor(Professor prof) {
        for(Professor p : lista)
            if(prof.equals(p))
                return true;
        return false;                
    }
}
