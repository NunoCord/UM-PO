
import java.util.ArrayList;

public class ListaSumario {

    private ArrayList<Sumario> lista;

    public ListaSumario() {
        lista = new ArrayList<>();
    }

    public ListaSumario(int capacidade) {
        lista = new ArrayList<>(capacidade);
    }

    public void inserir(Sumario s) {
        lista.add(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        for (Sumario e : lista) {
            sb.append("{");
            sb.append(e.toString());
            sb.append("}");
            sb.append("\n");
        }
//        sb.append("]");
        return sb.toString();
    }
    
}