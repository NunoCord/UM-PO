
package BackEnd;

public class Sistema {
    private final ProfessorLista prof = new ProfessorLista();
        
    private final AlunoLista alun = new AlunoLista();
        
    private final UcLista cadeira = new UcLista();
        
    private final CursoLista curs = new CursoLista();
        
    private final SumarioLista sum = new SumarioLista();
        
    public ProfessorLista getListaProfessor() {
        return prof;
    }
    
    public AlunoLista getListaAluno() {
        return alun;
    }
    
    public CursoLista getListaCurso() {
        return curs;
    }
    
    public UcLista getListaUc() {
        return cadeira;
    }
    
    public SumarioLista getListaSumario() {
        return sum;
    }
}
