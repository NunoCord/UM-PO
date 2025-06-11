package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CursoLista implements Serializable {

    private ArrayList<Curso> lista;

    public CursoLista() {
        lista = new ArrayList<>();
    }

    public void inserir(Curso c) {
        lista.add(c);
    }
    
    public void remover(Curso c) {
        lista.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Curso c : lista) {
            sb.append("|");
            sb.append(c.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Curso eDiretor(Professor p) {
        for (Curso c : lista) {
            if (c.getDiretor() == p) {
                return c;
            }
        }
        return new Curso("Indefinido");
    }

    public int verNumeroAlunos(Professor p) {
        for (Curso c : lista) {
            if (c.getDiretor() == p) {
                int qtd = c.numeroAlunos();
                return qtd;
            }
        }
        return -1;
    }
    
    public int verNumeroProfessores(Professor p) {
        for (Curso c : lista)
            if (c.getDiretor() == p) {
                int qtd = c.numeroProfessores();
                return qtd;
            }
        return -1;
    }

    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Curso.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    public void carregarFicheiroObjetos() throws IOException, Exception {
        try (FileInputStream file = new FileInputStream("Curso.txt"); ObjectInputStream oin = new ObjectInputStream(file)) {
            lista = (ArrayList<Curso>) oin.readObject();
        } catch (IOException e) {
            System.out.println("Erro no acesso aos ficheiros");
        }
    }

    public Curso devolveCurso(String designacao) {
        for (Curso c : lista) {
            if (c.getDesignacao().equals(designacao)) {
                return c;
            }
        }
        Curso c = new Curso("Indefinido");
        return c;
    }
    
    public void tornaDiretor(String designacao, Professor diretor) {
        for(Curso c : lista)
            if(designacao.equals(c.getDesignacao()))
                c.setDiretor(diretor);
    }
    
    public boolean apagarCurso(String codigo) {
        for(Curso c : lista)
            if(c.getDesignacao().equals(codigo)) {
                remover(c);
                return true;
            }
        return false;
    }
}
