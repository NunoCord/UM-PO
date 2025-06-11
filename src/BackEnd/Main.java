package BackEnd;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, Exception{
        
        ProfessorLista prof = new ProfessorLista();
        
        AlunoLista alun = new AlunoLista();
        
        UcLista cadeira = new UcLista();
        
        CursoLista curs = new CursoLista();
        
        SumarioLista sum = new SumarioLista();
        
        
        
        prof.carregarFicheiroObjetos();
        
        cadeira.carregarFicheiroObjetos();
        
        alun.carregarFicheiroObjetos();
        
        curs.carregarFicheiroObjetos();
        
        sum.carregarFicheiroObjetos();
        
        
        System.out.println("---------------------------------------------------------");
        
/*        
        alun.inserir(new Aluno("Xico", "A001", curs.devolveCurso("LEGSI")));
        alun.inserir(new Aluno("Padeiro", "A002", curs.devolveCurso("LEGSI")));
        alun.inserir(new Aluno("Bino", "A003", curs.devolveCurso("MIEGSI")));
        alun.inserir(new Aluno("Tone", "A004", curs.devolveCurso("MIEGSI")));
*/

/*
        cadeira.inserir(new Uc("PO", new ProfessorLista(), prof.devolveProfessor("Quim")));
        cadeira.inserir(new Uc("PMS", new ProfessorLista(), prof.devolveProfessor("Tone")));
        cadeira.inserir(new Uc("FEO", new ProfessorLista(), prof.devolveProfessor("Carlos")));
        cadeira.inserir(new Uc("FSI", new ProfessorLista(), prof.devolveProfessor("Alberto")));
*/

/*
        prof.inserir(new Professor("Quim", "P001", cadeira.devolveUc("PO")));
        prof.inserir(new Professor("Tone", "P002", cadeira.devolveUc("PMS")));
        prof.inserir(new Professor("Carlos", "P003", cadeira.devolveUc("FEO")));
        prof.inserir(new Professor("Alberto", "P004", cadeira.devolveUc("FSI")));
*/

/*
        curs.inserir(new Curso("LEGSI", new UcLista(), prof.devolveProfessor("Quim"), new AlunoLista()));
        curs.inserir(new Curso("MIEGSI", new UcLista(), prof.devolveProfessor("Tone"), new AlunoLista()));
*/        
        
        System.out.println(prof);
        System.out.println(cadeira);
        System.out.println(alun);
        System.out.println(curs);
        System.out.println(sum);
        
        
        
        System.out.println("---------------------------------------------------------");
        
        
        
        prof.guardarFicheiroObjetos();
        alun.guardarFicheiroObjetos();
        curs.guardarFicheiroObjetos();
        cadeira.guardarFicheiroObjetos();
        sum.guardarFicheiroObjetos();
    }
}
