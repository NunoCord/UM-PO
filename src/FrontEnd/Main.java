package FrontEnd;

import java.util.Scanner;
import BackEnd.Sistema;
import BackEnd.Aluno;
import BackEnd.Professor;
import BackEnd.Curso;
import BackEnd.Uc;
import BackEnd.Sumario;
import BackEnd.SumarioLista;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class Main {

    private final Sistema sistema = new Sistema();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Main menu = new Main();

        menu.leDados();

        Professor p = null;
        int opcao;
        do {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Logar conta");
            System.out.println("0 - Terminar aplicacao");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    menu.criarConta();
                    break;
                case 2:
                    p = menu.logarConta();
                    if (!p.getNome().equals("Indefinido")) {
                        menu.menuPrincipal(p);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduza um valor válido");
                    break;
            }
        } while (opcao != 0);

        menu.guardaDados();
    }

    public void menuPrincipal(Professor p) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1- Administrador \n2- Professor \n3- Regente da UC \n4- Diretor de curso\n0 - Sair \n\nEscolha uma opcao: ");
            
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    entrarModoAdministrador();
                    break;
                case 2:
                    Professor(p);
                    break;
                case 3:
                    Uc u = sistema.getListaUc().eRegente(p);
                    if (!u.getDesignacao().equals("Indefinido")) {
                        RegenteUC(u);
                    }
                    break;
                case 4:
                    Curso c = sistema.getListaCurso().eDiretor(p);
                    if (!c.getDesignacao().equals("Indefinido")) {
                        DiretorCurso(c);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduza um valor valido");
                    break;
            }
        } while (opcao != 0);
    }

    public void entrarModoAdministrador() {
        String PASSWORD = "abc";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha do administrador: ");
        int opcao;
        if (PASSWORD.equals(scanner.next())) {
            do {
                System.out.println("\nMenu de Administração");
                System.out.println("1 - Gerir Professores");
                System.out.println("2 - Gerir Cursos");
                System.out.println("3 - Gerir Ucs");
                System.out.println("4 - Gerir Alunos");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                
                try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }

                switch (opcao) {
                    case 1:
                        gerirProfessor();
                        break;

                    case 2:
                        gerirCurso();
                        break;

                    case 3:
                        gerirUc();
                        break;

                    case 4:
                        gerirAluno();
                        break;

                    case 0:
                        System.out.println("Saindo do modo administrador...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;

                }

            } while (opcao != 0);
        }
    }

    // Restante do código
    private void Professor(Professor p) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu do Professor");
            System.out.println("1- Criar Sumário\n2- Consultar lista de sumários\n3- Consultar serviço docente\n0 - \n\n Escolha uma opcao:");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    if (p.getUc().getDesignacao().equals("Indefinido")) {
                        System.out.println("Erro: Professor sem Uc definida");
                        break;
                    }
                    Sumario suma = new Sumario();
                    suma.setProfessor(p);
                    suma.setCadeira(p.getUc());
                    System.out.println("Indique o titulo: ");
                    String titulo = scanner.next();
                    suma.setTitulo(titulo);
                    System.out.println("Indique o texto: ");
                    String texto = scanner.next();
                    suma.setTexto(texto);
                    System.out.println("0 - Acabar as presencas");
                    String opcao2;
                    do {
                        System.out.println("Indique o nome do Aluno: ");
                        opcao2 = scanner.next();
                        Aluno a = sistema.getListaAluno().devolveAluno(opcao2);
                        if (a.getNome().equals("Indefinido")) {
                            System.out.println("Erro a identificar Aluno");
                        } else {
                            suma.setnovoAluno(a);
                            System.out.println("Aluno adicionado a presenca");
                        }
                    } while (!opcao2.equals("0"));
                    suma.setData(lerData());
                    p.setnovoSumario(suma);
                    p.getUc().setnovoSumario(suma);
                    break;
                case 2:
                    System.out.println(p.getSumario());
                    break;
                case 3:
                    System.out.println(p);
                    break;
                default:
                    System.out.println("Introduza um valor valido");
            }
        } while (opcao != 0);
    }

    private void RegenteUC(Uc u) {
        Scanner scanner = new Scanner(System.in);
        int opcao1, opcao2;

        do {
            System.out.println("\nMenu do Regente");
            System.out.println("1 - Gerir Professor da Uc\n2 - Consulta assiduidade do aluno\n3 - Consultar lista de sumarios\n0 - Sair\n\n Escolha uma opcao:");
            try {
                opcao1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao1 = 0;
            }
            switch (opcao1) {
                case 1:
                    System.out.println("Indique o nome do Professor: ");
                    Professor p = sistema.getListaProfessor().devolveProfessor(scanner.next());
                    if (!p.getNome().equals("Indefinido")) {
                        System.out.println("1 - Adicionar Professor a " + u.getDesignacao());
                        System.out.println("2 - Remover Professor de " + u.getDesignacao());
                        try {
                opcao2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao2 = 0;
            }
                        switch (opcao2) {
                            case 1:
                                if (p.getUc() != u) {
                                    p.getUc().getEquipa().remover(p);
                                    p.setUc(u);
                                    u.setnovoProfessor(p);
                                    System.out.println(p.getNome() + " adicionado a Uc");
                                } else {
                                    System.out.println(p.getNome() + " ja pertence a Uc");
                                }
                                break;
                            case 2:
                                if (p.getUc() == u) {
                                    u.removeProfessor(p);
                                    p.setUc(new Uc("Indefinido"));
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Indique o nome do Aluno: ");
                    Aluno a = sistema.getListaAluno().devolveAluno(scanner.next());
                    if (!a.getNome().equals("Indefinido")) {
                        u.presencaAluno(a);
                    }
                    break;
                case 3:
                    System.out.println(u.getSumario());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduza um valor valido");
            }
        } while (opcao1 != 0);
    }

    private void DiretorCurso(Curso c) {
        Scanner scanner = new Scanner(System.in);
        int opcao1, opcao2;

        do {
            System.out.println("\nMenu do Diretor de Curso");
            System.out.println("1- Alterar designacao do Curso\n2- Listar numero de professores ou alunos do curso\n 3- Gerir Alunos do curso\n0 - Sair\n\n Escolha uma opcao:");
            try {
                opcao1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao1 = 0;
            }
            switch (opcao1) {
                case 1:
                    System.out.println("Indique a nova Designacao: ");
                    String designacao = scanner.next();
                    c.setDesignacao(designacao);
                    break;
                case 2:
                    System.out.println("Total de Alunos: " + c.getAlunos().contarAlunos());
                    System.out.println("Total de Professores: " + c.getUc().contarProfessores());
                    break;
                case 3:
                    System.out.println("Indique o nome do Aluno: ");
                    Aluno a = sistema.getListaAluno().devolveAluno(scanner.next());
                    System.out.println("1 - Adicionar Aluno a " + c.getDesignacao());
                    System.out.println("2 - Remover Aluno de " + c.getDesignacao());
                    try {
                opcao2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao2 = 0;
            }
                    switch (opcao2) {
                        case 1:
                            if (a.getCurso() != c) {
                                a.getCurso().getAlunos().remover(a);
                                a.setCurso(c);
                                c.setnovoAluno(a);
                                System.out.println(a.getNome() + " adicionado ao Curso");
                            } else {
                                System.out.println(a.getNome() + " ja pertence ao Curso");
                            }
                            break;
                        case 2:
                            if (a.getCurso() == c) {
                                c.removeAluno(a);
                                a.setCurso(new Curso("Indefinido"));
                            }
                            break;
                    }
                    break;
                default:
                    System.out.println("Introduza um valor valido");
            }
        } while (opcao1 != 0);
    }

    public void criarConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o username: ");
        String username = scanner.next();
        System.out.println("Indique a password: ");
        String password = scanner.next();
        System.out.println("Indique o nome");
        String nome = scanner.next();
        System.out.println("Indique o codigo");
        String codigo = scanner.next();
        System.out.println("Indique a Uc");
        Uc u = sistema.getListaUc().devolveUc(scanner.next());
        Professor p = new Professor(nome, codigo, u, username, password);
        sistema.getListaProfessor().inserir(p);
        if (!p.getUc().getDesignacao().equals("Indefinido")) {
            p.getUc().getEquipa().inserir(p);
        }
    }

    public Professor logarConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String usermane = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        Professor p = sistema.getListaProfessor().procurarConta(usermane, password);
        return p;
    }

    private void sleep() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void leDados() throws Exception {
        sistema.getListaProfessor().carregarFicheiroObjetos();
        sistema.getListaAluno().carregarFicheiroObjetos();
        sistema.getListaCurso().carregarFicheiroObjetos();
        sistema.getListaUc().carregarFicheiroObjetos();
        sistema.getListaSumario().carregarFicheiroObjetos();
    }

    public void guardaDados() throws Exception {
        sistema.getListaProfessor().guardarFicheiroObjetos();
        sistema.getListaAluno().guardarFicheiroObjetos();
        sistema.getListaCurso().guardarFicheiroObjetos();
        sistema.getListaUc().guardarFicheiroObjetos();
        sistema.getListaSumario().guardarFicheiroObjetos();
    }

    public void gerirAluno() {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Criar Aluno");
            System.out.println("2 - Apagar Aluno");
            System.out.println("3 - Alterar Informações de Aluno");
            System.out.println("4 - Listar Alunos");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    criarAluno();
                    break;

                case 2:
                    removeAluno();
                    break;

                case 3:
                    Aluno a = procurarAluno();
                    if (a != null) {
                        informacaoAluno(a);
                    }
                    break;

                case 4:
                    System.out.println(sistema.getListaAluno());
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Introduza um valor válido");
                    break;
            }
        } while (opcao != 0);
    }

    public void criarAluno() {
        Scanner scanner = new Scanner(System.in);
        String nome, codigo, curso;
        System.out.println("Qual o nome do Aluno: ");
        nome = scanner.next();
        System.out.println("Qual o codigo do Aluno: ");
        codigo = scanner.next();
        System.out.println("Qual o curso do Aluno: ");
        curso = scanner.next();

        Aluno novoAluno = new Aluno(nome, codigo, sistema.getListaCurso().devolveCurso(curso));
        sistema.getListaAluno().inserir(novoAluno);

        if (!novoAluno.getCurso().getDesignacao().equals("Indefinido")) {
            novoAluno.getCurso().getAlunos().inserir(novoAluno);
        }
        System.out.println("Aluno criado com sucesso!");
    }

    public void removeAluno() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do Aluno: ");
        nome = scanner.next();
        if (sistema.getListaAluno().apagarAluno(nome)) {
            System.out.println("Aluno removido");
            return;
        } else {
            System.out.println("Erro ao remover Aluno");
        }
    }

    public Aluno procurarAluno() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do Aluno: ");
        nome = scanner.next();
        Aluno a = sistema.getListaAluno().devolveAluno(nome);
        if (a.getNome().equals("Indefinido")) {
            System.out.println("Erro a identificar o Aluno");
            return null;
        }
        return a;
    }

    public void informacaoAluno(Aluno a) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Editar Nome");
            System.out.println("2 - Editar Codigo");
            System.out.println("3 - Editar Curso");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    a.setNome(scanner.next());
                    break;
                case 2:
                    a.setCodigo(scanner.next());
                    break;
                case 3:
                    a.setCurso(sistema.getListaCurso().devolveCurso(scanner.next()));
                    break;
            }
        } while (opcao != 0);
    }

    public void gerirProfessor() {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Criar Professor");
            System.out.println("2 - Apagar Professor");
            System.out.println("3 - Alterar Informações de Professor");
            System.out.println("4 - Listar Professores");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    criarProfessor();
                    break;

                case 2:
                    removeProfessor();
                    break;

                case 3:
                    Professor p = procuraProfessor();
                    if (p != null) {
                        informacaoProfessor(p);
                    }
                    break;

                case 4:
                    System.out.println(sistema.getListaProfessor());
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Introduza um valor válido");
            }
        } while (opcao != 0);
    }

    public void criarProfessor() {
        Scanner scanner = new Scanner(System.in);
        String nome, codigo;
        System.out.println("Qual o nome do professor: ");
        nome = scanner.next();
        System.out.println("Qual o código do professor: ");
        codigo = scanner.next();
        System.out.println("Qual a Uc do professor: ");
        String uc = scanner.next();

        Professor novoProfessor = new Professor(nome, codigo, sistema.getListaUc().devolveUc(uc));
        sistema.getListaProfessor().inserir(novoProfessor);

        if (!novoProfessor.getUc().getDesignacao().equals("Indefinido")) {
            novoProfessor.getUc().getEquipa().inserir(novoProfessor);
        }
        System.out.println("Professor criado com sucesso!");
    }

    public void removeProfessor() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do professor: ");
        nome = scanner.next();
        if (sistema.getListaProfessor().apagarProfessor(nome)) {
            System.out.println("Professor apagado");
            return;
        } else {
            System.out.println("Erro ao apagar Professor");
        }
    }

    public Professor procuraProfessor() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do professor: ");
        nome = scanner.next();
        Professor p = sistema.getListaProfessor().devolveProfessor(nome);
        if (p.getNome().equals("Indefinido")) {
            System.out.println("Erro a identificar o Professor");
            return null;
        }
        return p;
    }

    public void informacaoProfessor(Professor p) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Editar Nome");
            System.out.println("2 - Editar Uc");
            System.out.println("3 - Remover Sumarios");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    p.setNome(scanner.next());
                    break;
                case 2:
                    if (p.getUc().getEquipa() != null) {
                        p.getUc().getEquipa().remover(p);
                    }

                    p.setUc(sistema.getListaUc().devolveUc(scanner.next()));

                    if (!p.getUc().getDesignacao().equals("Indefinido")) {
                        p.getUc().getEquipa().inserir(p);
                    }
                    break;
                case 3:
                    p.setSumario(new SumarioLista());
                    break;
            }
        } while (opcao != 0);
    }

    public void gerirCurso() {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Apagar Curso");
            System.out.println("3 - Alterar Informações de Curso");
            System.out.println("4 - Listar Cursos");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    criarCurso();
                    break;

                case 2:
                    removeCurso();
                    break;

                case 3:
                    Curso c = procurarCurso();
                    if (c != null) {
                        informacaoCurso(c);
                    }
                    break;
                case 4:
                    System.out.println(sistema.getListaCurso());
                    break;
            }
        } while (opcao != 0);
    }

    public void criarCurso() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do curso: ");
        nome = scanner.next();

        Curso novoCurso = new Curso(nome);
        sistema.getListaCurso().inserir(novoCurso);

        System.out.println("Curso criado com sucesso!");
    }

    public void removeCurso() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Indique a designacao do curso: ");
        nome = scanner.next();
        if (sistema.getListaCurso().apagarCurso(nome)) {
            System.out.println("Curso apagado");
            return;
        } else {
            System.out.println("Erro ao apagar Curso");
        }
    }

    public Curso procurarCurso() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do curso: ");
        nome = scanner.next();
        Curso c = sistema.getListaCurso().devolveCurso(nome);
        if (c.getDesignacao().equals("Indefinido")) {
            System.out.println("Erro a identificar o Curso");
            return null;
        }
        return c;
    }

    public void informacaoCurso(Curso c) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Editar Designacao");
            System.out.println("2 - Editar Ucs");
            System.out.println("3 - Editar Diretor");
            System.out.println("4 - Editar Alunos");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    c.setDesignacao(scanner.next());
                    break;
                case 2:
                    editarUc(c);
                    break;
                case 3:
                    System.out.println("Indique o nome do novo diretor: ");
                    Professor p = sistema.getListaProfessor().devolveProfessor(scanner.next());
                    if (!p.getNome().equals("Indefinido")) {
                        c.setDiretor(p);
                        System.out.println("Professor adicionado a diretor");
                        break;
                    }
                    System.out.println("Erro a identificar o professor");
                    break;
                case 4:
                    editarAluno(c);
                    break;
            }
        } while (opcao != 0);
    }

    public void editarUc(Curso c) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o nome da Uc");
        Uc u = sistema.getListaUc().devolveUc(scanner.next());
        if (!u.getDesignacao().equals("Indefinido")) {
            System.out.println("1 - Adicionar Uc a " + c.getDesignacao());
            System.out.println("2 - Remover Uc de " + c.getDesignacao());
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    if (c.getUc().procuraUc(u)) {
                        System.out.println("Uc ja pertence ao curso");
                        break;
                    }
                    c.setnovaUc(u);
                    System.out.println("Uc adicionada ao curso");
                    break;
                case 2:
                    if (c.getUc().procuraUc(u)) {
                        c.removeUc(u);
                        System.out.println("Uc removida do curso");
                        break;
                    }
                    System.out.println("Uc nao pertencia ao curso");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }

    public void editarAluno(Curso c) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o nome do Aluno");
        Aluno a = sistema.getListaAluno().devolveAluno(scanner.next());
        if (!a.getNome().equals("Indefinido")) {
            System.out.println("1 - Adicionar aluno a " + c.getDesignacao());
            System.out.println("2 - Remover aluno de " + c.getDesignacao());
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    if (c.getAlunos().procuraAluno(a)) {
                        System.out.println("Aluno ja pertence ao curso");
                        break;
                    }
                    a.setCurso(c);
                    c.setnovoAluno(a);
                    System.out.println("Aluno adicionado ao curso");
                    break;
                case 2:
                    if (c.getAlunos().procuraAluno(a)) {
                        c.removeAluno(a);
                        a.setCurso(new Curso("Indefinido"));
                        System.out.println("Aluno removido do curso");
                        break;
                    }
                    System.out.println("Aluno nao pertencia ao curso");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }

    public void gerirUc() {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Criar Uc");
            System.out.println("2 - Apagar Uc");
            System.out.println("3 - Alterar Informações da Uc");
            System.out.println("4 - Listar Ucs");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    criarUc();
                    break;

                case 2:
                    removeUc();
                    break;

                case 3:
                    Uc u = procuraUc();
                    if (u != null) {
                        informacaoUc(u);
                    }
                    break;
                case 4:
                    System.out.println(sistema.getListaUc());
                    break;
            }
        } while (opcao != 0);
    }

    public void criarUc() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome da uc: ");
        nome = scanner.next();

        Uc novaUc = new Uc(nome);
        sistema.getListaUc().inserir(novaUc);

        System.out.println("Uc criada com sucesso!");
    }

    public void removeUc() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Indique a designacao da uc: ");
        nome = scanner.next();
        if (sistema.getListaUc().apagarUc(nome)) {
            System.out.println("Uc apagada");
            return;
        } else {
            System.out.println("Erro ao apagar Uc");
        }
    }

    public Uc procuraUc() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome da uc: ");
        nome = scanner.next();
        Uc u = sistema.getListaUc().devolveUc(nome);
        if (u.getDesignacao().equals("Indefinido")) {
            System.out.println("Erro a identificar a Uc");
            return null;
        }
        return u;
    }

    public void informacaoUc(Uc u) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Editar Designacao");
            System.out.println("2 - Editar Equipa");
            System.out.println("3 - Editar Regente");
            System.out.println("4 - Ver sumarios");
            System.out.println("0 - Sair");
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    u.setDesignacao(scanner.next());
                    break;
                case 2:
                    editarEquipa(u);
                    break;
                case 3:
                    System.out.println("Indique o nome do novo regente: ");
                    Professor p = sistema.getListaProfessor().devolveProfessor(scanner.next());
                    if (!p.getNome().equals("Indefinido")) {
                        u.setRegente(p);
                        System.out.println("Professor adicionado a regente");
                        break;
                    }
                    System.out.println("Erro a identificar o professor");
                    break;
                case 4:
                    System.out.println(u.getSumario());
                    break;
            }
        } while (opcao != 0);
    }

    public void editarEquipa(Uc u) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o nome do Professor");
        Professor p = sistema.getListaProfessor().devolveProfessor(scanner.next());
        if (!p.getNome().equals("Indefinido")) {
            System.out.println("1 - Adicionar Professor a " + u.getDesignacao());
            System.out.println("2 - Remover Professor de " + u.getDesignacao());
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    if (u.getEquipa().procuraProfessor(p)) {
                        System.out.println("Professor ja pertence a Uc");
                        break;
                    }
                    p.setUc(u);
                    u.setnovoProfessor(p);
                    System.out.println("Professor adicionado a Uc");
                    break;
                case 2:
                    if (u.getEquipa().procuraProfessor(p)) {
                        u.removeProfessor(p);
                        p.setUc(new Uc("Indefinido"));
                        System.out.println("Professor removido da Uc");
                        break;
                    }
                    System.out.println("Professor nao pertencia a Uc");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }
    
    public LocalDate lerData() {
        Scanner scanner = new Scanner(System.in);
        LocalDate data = null;
        String texto;

        do {
            System.out.println("Indique a data no formato (dd/mm/aaaa)");
            texto = scanner.nextLine();

            try {
                data = LocalDate.parse(texto, DateTimeFormatter.ofPattern("d/M/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println(texto + "Nao e uma data no formato dd/mm/aaaa.");
            }

        } while (data == null);

        return data;
    }
}
