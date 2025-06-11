package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UcLista implements Serializable {

    private ArrayList<Uc> lista;

    public UcLista() {
        lista = new ArrayList<>();
    }

    public void inserir(Uc u) {
        lista.add(u);
    }
    
    public void remover(Uc u) {
        lista.remove(u);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Uc u : lista) {
            sb.append("|");
            sb.append(u.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String paraString() {
        StringBuilder sb = new StringBuilder();
        for (Uc u : lista) {
            sb.append(u.getDesignacao());
            sb.append(",");
        }
        if (sb.toString() != null) {
            return sb.toString();
        }
        return "";
    }

    public Uc eRegente(Professor p) {
        for (Uc u : lista) {
            if (u.getRegente() == p) {
                return u;
            }
        }
        return new Uc("Indefinido");
    }

    public String verPresencaAlunos(Uc u1, Aluno a) {
        for (Uc u2 : lista) {
            if (u2 == u1) {
                return u1.presencaAluno(a);
            }
        }
        return null;
    }

    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Uc.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    public void carregarFicheiroObjetos() throws IOException, Exception {
        try (FileInputStream file = new FileInputStream("Uc.txt"); ObjectInputStream oin = new ObjectInputStream(file)) {
            lista = (ArrayList<Uc>) oin.readObject();
        } catch (IOException e) {
            System.out.println("Erro no acesso aos ficheiros");
        }
    }

    public Uc devolveUc(String designacao) {
        for (Uc u : lista) {
            if (u.getDesignacao().equals(designacao)) {
                return u;
            }
        }
        Uc u = new Uc("Indefinido");
        return u;
    }
    
    public void tornaRegente(String designacao, Professor regente) {
        for(Uc u : lista)
            if(designacao.equals(u.getDesignacao()))
                u.setRegente(regente);
    }
    
    public int contarProfessores() {
        int total = 0;
        for (Uc u : lista)
            total += u.getEquipa().contarProfessores();
        return total;
    }
    
    public boolean apagarUc(String codigo) {
        for(Uc u : lista)
            if(u.getDesignacao().equals(codigo)) {
                remover(u);
                return true;
            }
        return false;
    }
    
    public boolean procuraUc(Uc uc) {
        for(Uc u : lista)
            if(uc.equals(u))
                return true;
        return false;                
    }
}
