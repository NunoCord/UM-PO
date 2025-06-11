package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SumarioLista implements Serializable {

    private ArrayList<Sumario> lista;

    public SumarioLista() {
        lista = new ArrayList<>();
    }

    public void inserir(Sumario s) {
        lista.add(s);
    }
    
    public void remover(Sumario s) {
        lista.remove(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sumario s : lista) {
            sb.append("|");
            sb.append(s.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String paraString() {
        StringBuilder sb = new StringBuilder();
        for (Sumario s : lista) {
            sb.append(s.getTitulo());
            sb.append(",");
        }
        if (sb.toString() != null) {
            return sb.toString();
        }
        return "";
    }

    public String escreverPresenca(Aluno a) {
        StringBuilder sb = new StringBuilder();
        for (Sumario s : lista) {
            if (s.getPresenca() != null) {
                if (s.getPresenca().estavaPresenteAluno(a)) {
                    sb.append("Presente no dia ");
                    sb.append(s.getData());
                    sb.append("\n");
                }
            }

        }
        return sb.toString();
    }

    public void guardarFicheiroObjetos() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Sumario.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        }
    }

    public void carregarFicheiroObjetos() throws IOException, Exception {
        try (FileInputStream file = new FileInputStream("Sumario.txt"); ObjectInputStream oin = new ObjectInputStream(file)) {
            lista = (ArrayList<Sumario>) oin.readObject();
        } catch (IOException e) {
            System.out.println("Erro no acesso aos ficheiros");
        }
    }
}
