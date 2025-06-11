
public class Professor {

    private String nome;
    private String codigo;
    private String uc;
    private boolean regenteUc=false;
    private boolean diretorUc=false;

    public Professor() {
    }

    public Professor(String novoNome, String novoCodigo, String novaUc) {
        setNome(novoNome);
        setCodigo(novoCodigo);
        setUc(novaUc);
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setCodigo(String novoCodigo) {
        codigo = novoCodigo;
    }

    public void setUc(String novaUc) {
        uc = novaUc;
    }
    
    public void setDiretorUc(boolean tipoDiretorUc) {
        diretorUc = tipoDiretorUc;
    }
    
    public void setRegenteUc(boolean tipoRegenteUc) {
        regenteUc = tipoRegenteUc;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUc() {
        return uc;   
    }
    
    public boolean getDiretorUc() {
        return diretorUc;
    }
    
    public boolean getRegenteUc() {
        return regenteUc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\t|Codigo: " + codigo + "\t|Uc: " + uc + "\t|Diretor: " + diretorUc + "\t|Regente: " + regenteUc;
    }
}
