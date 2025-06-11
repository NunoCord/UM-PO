
import java.util.Scanner;

public class Sumario {

    private String data;
    private String numero;
    private String sumario;
    private String nomeProfessor;

    public Sumario() {
    }

    public Sumario(String novoNumero, String novoSumario) {
        setNumero(novoNumero);
        setSumario(novoSumario);
    }

    public void setData(int novoDia, int novoMes, int novoAno) {
        data = Integer.toString(novoDia) + "/" + Integer.toString(novoMes) + "/" + Integer.toString(novoAno);
    }

    public void setNumero(String novoNumero) {
        numero = novoNumero;
    }

    public void setSumario(String novoSumario) {
        sumario = novoSumario;
    }
    
    public void setNomeProfessor(String novoNomeProfessor) {
        nomeProfessor = novoNomeProfessor;
    }

    public String getData() {
        return data;
    }

    public String getNumero() {
        return numero;
    }

    public String getSumario() {
        return sumario;
    }
    
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void criarSumario() {
        Scanner input = new Scanner(System.in);

        System.out.println("Indique o numero: ");
        String num = input.next();
        setNumero(num);
        System.out.println("Indique o sumario: ");
        String sum = input.next();
        setSumario(sum);
        System.out.println("Indique a data");
        System.out.println("Dia: ");
        int dia = input.nextInt();
        System.out.println("Mes: ");
        int mes = input.nextInt();
        System.out.println("Ano: ");
        int ano = input.nextInt();
        setData(dia, mes, ano);
    }
    
    public String toString() {
        return numero + "\t" + data + "\n" + sumario;
    }
}
