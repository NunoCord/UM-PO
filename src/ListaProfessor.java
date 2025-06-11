
import java.util.ArrayList;

public class ListaProfessor {

    private ArrayList<Professor> lista;

    public ListaProfessor() {
        lista = new ArrayList<>();
    }

    public ListaProfessor(int capacidade) {
        lista = new ArrayList<>(capacidade);
    }

    public void inserir(Professor e) {
        if (e.getDiretorUc() && existeDiretorUc(e.getUc())) {
            System.out.println("Já existe um diretor para a UC: " + e.getUc());
            e.setDiretorUc(false);
        }
        if (e.getRegenteUc() && existeRegenteUc(e.getUc())) {
            System.out.println("Já existe um regente para " + e.getUc());
            e.setRegenteUc(false);
        }
        lista.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ______________________________________________________________________\n");
        for (Professor e : lista) {
            sb.append("|");
            sb.append(e.toString());
            sb.append("|");
            sb.append("\n");
        }
        sb.append(" ----------------------------------------------------------------------\n");
        return sb.toString();
    }

    private boolean existeDiretorUc(String uc) {
        for (Professor professor : lista) {
            if (professor.getUc().equals(uc) && professor.getDiretorUc()) {
                return true;
            }
        }
        return false;
    }
    
    

    public void mudaDiretor(String codigo) {
        for (Professor p2 : lista) {
            if (p2.getCodigo().equals(codigo)) {
                for (Professor p3 : lista) {
                    if (p2.getUc().equals(p3.getUc()) && p3.getDiretorUc()) {
                        p3.setDiretorUc(false);
                    }
                }
                p2.setDiretorUc(true);
            }
        }
    }
    
    private boolean existeRegenteUc(String uc) {
        for (Professor professor : lista) {
            if (professor.getUc().equals(uc) && professor.getRegenteUc()) {
                return true;
            }
        }
        return false;
    }
    
    public void mudaRegente(String codigo) {
        for (Professor p2 : lista) {
            if (p2.getCodigo().equals(codigo)) {
                for (Professor p3 : lista) {
                    if (p2.getUc().equals(p3.getUc()) && p3.getRegenteUc()) {
                        p3.setRegenteUc(false);
                    }
                }
                p2.setRegenteUc(true);
            }
        }
    }
}