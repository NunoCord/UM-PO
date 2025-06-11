package BackEnd;

import java.io.Serializable;

public class Professor extends Utilizador implements Serializable {

    private String nome;
    private String codigo;
    private Uc uc;
    private SumarioLista sumarios;

    public Professor() {
        super("","");
    }
    
    public Professor(String novoNome) {
        super("","");
        setNome(novoNome);
        setSumario(new SumarioLista());
    }

    public Professor(String novoNome, String novoCodigo, Uc novaUc) {
        super("","");
        setNome(novoNome);
        setCodigo(novoCodigo);
        setUc(novaUc);
        setSumario(new SumarioLista());
    }
    
    public Professor(String novoNome, String novoCodigo, Uc novaUc, String username, String password) {
        super(username,password);
        setNome(novoNome);
        setCodigo(novoCodigo);
        setUc(novaUc);
        setSumario(new SumarioLista());
    }

    public Professor(String novoNome, String novoCodigo, Uc novaUc, SumarioLista novaListaSumario) {
        super("","");
        setNome(novoNome);
        setCodigo(novoCodigo);
        setUc(novaUc);
        setSumario(novaListaSumario);
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setCodigo(String novoCodigo) {
        codigo = novoCodigo;
    }

    public void setUc(Uc novaUc) {
        uc = novaUc;
    }

    public void setSumario(SumarioLista novoSumario) {
        sumarios = novoSumario;
    }
    
    public void setnovoSumario(Sumario novoSumario) {
        sumarios.inserir(novoSumario);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Uc getUc() {
        return uc;
    }

    public SumarioLista getSumario() {
        if (sumarios != null) {
            return sumarios;
        }
        SumarioLista s = new SumarioLista();
        return s;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\t|Codigo: " + codigo + "\t|Uc: " + uc.getDesignacao();
    }
}
