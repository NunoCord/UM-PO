public class Main {

    public static void main(String[] args) {
        
        Professor p1 = new Professor("Quim", "P001", "PO");
        p1.setDiretorUc(true);
        Professor p2 = new Professor("Tone", "P002", "PO");
        ListaProfessor lista = new ListaProfessor();
        lista.inserir(p1);
        lista.inserir(p2);
        lista.inserir(new Professor("Carlos", "P003", "PO"));
        lista.inserir(new Professor("Alberto", "P004", "PO"));
        
        
        lista.mudaDiretor("P003");
        
        System.out.println(lista);
        
    }
}