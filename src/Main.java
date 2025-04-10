import java.util.Scanner;
// --> Autor: William RM <--
public class Main {
    public static void loading() throws InterruptedException {
        System.out.print("Loading");
        Thread.sleep(600);
        System.out.print(".");
        Thread.sleep(400);
        System.out.print(".");
        Thread.sleep(400);
        System.out.print(".");
        System.out.println();
        Thread.sleep(600);
    }
    public static void main(String[] args) throws InterruptedException {

        Scanner teclado = new Scanner(System.in);

        Aluno aluno = new Aluno(); // versao com List
        AlunoSet alunoSet = new AlunoSet(); // versao com Set
        AlunoMap alunoMap = new AlunoMap(); // versao com Map

        AlunoDAOList alunoDAO = new AlunoDAOList(); // versao com List
        AlunoDAOSet alunoDAOSet = new AlunoDAOSet(); // versao com Set
        AlunoDAOMap alunoDAOMap = new AlunoDAOMap(); // versao com Map

        int exit1 = 0, exit2, op, op2;
        String aux1, aux2;

        loading();

        do
        {
            exit2 = 0;
            System.out.print("""
                    System > Escolha uma opcao de versao de codigo <
                    
                    [0] sair
                    [1] List
                    [2] Set
                    [3] Map
                    """);
            System.out.print("Digite:");
            op = teclado.nextInt();
            System.out.println();

            switch (op)
            {
                case 0: // sair
                    System.out.println("System > Ok, fechando o sistema < ");
                    loading();
                    exit1 = 1;
                    break;
                case 1: // Versao do SistemaDeEscola com ( List ).
                    System.out.println("System > Versao List < \n");
                    do
                    {
                        System.out.print("""
                                
                                [0] sair (volta para o sistema de escolhas)
                                [1] Cadastrar
                                [2] Listar
                                [3] Excluir
                                """);
                        System.out.print("Digite:");
                        op2 = teclado.nextInt();
                        switch (op2)
                        {
                            case 0:
                                System.out.println("System > Voltando para o sistema de escolhas! < \n");
                                loading();
                                exit2 = 1;
                                break;
                            case 1:
                                aluno = new Aluno();
                                System.out.println("System > Coloque a matricula do aluno <");
                                System.out.print("Digite:");
                                aux1 = teclado.next();

                                if(alunoDAO.buscarAluno(aux1) != null)
                                {
                                    System.out.println("System > Já existe um aluno com essa matricula! <");
                                }
                                else
                                {
                                    teclado.nextLine();
                                    aluno.setMatricula(aux1);
                                    System.out.print("Digite o curso:");
                                    aluno.setCurso(teclado.nextLine());
                                    System.out.print("Digite o nome:");
                                    aluno.setNome(teclado.nextLine());
                                    System.out.print("Digite a idade:");
                                    aluno.setIdade(teclado.nextInt());

                                    alunoDAO.registrar(aluno);

                                    System.out.println("System > Aluno cadastrado com sucesso! <");
                                }

                                break;
                            case 2:
                                if(alunoDAO.verificarExistencia())
                                {
                                    System.out.println();
                                    System.out.println(alunoDAO.listarAlunos());
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            case 3:
                                if(alunoDAO.verificarExistencia())
                                {
                                    teclado.nextLine();
                                    System.out.print("Digite a matricula:");
                                    aux2 = teclado.nextLine();

                                    if(alunoDAO.buscarAluno(aux2) != null)
                                    {
                                        aluno = alunoDAO.buscarAluno(aux2);
                                        System.out.println("System > Informacoes do aluno <");
                                        System.out.println(aluno);

                                        System.out.println("Desesa excluir? S / N");
                                        aux1 = teclado.nextLine();

                                        if(aux1.equalsIgnoreCase("S"))
                                        {
                                            alunoDAO.excluirAluno(aux2);
                                            System.out.println("System > Aluno excluido com sucesso! <");
                                        }
                                        else if(aux1.equalsIgnoreCase("N"))
                                        {
                                            System.out.println("System > Ok, nao vamos excluir o aluno <");
                                        }
                                        else
                                        {
                                            System.out.println("System > Opcao Invalida <");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("System > Nao existe um aluno com essa matricula! <");
                                    }
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            default:
                                System.out.println("System > Opcao Invalida <");
                        }
                    }while(exit2 != 1);


                    break;
                case 2:// Versao do SistemaDeEscola com ( Set ).
                    System.out.println("System > Versao Set < \n");
                    do
                    {
                        System.out.print("""
                                
                                [0] sair (volta para o sistema de escolhas)
                                [1] Cadastrar
                                [2] Listar
                                [3] Excluir
                                """);
                        System.out.print("Digite:");
                        op2 = teclado.nextInt();
                        switch (op2)
                        {
                            case 0:
                                System.out.println("System > Voltando para o sistema de escolhas! < \n");
                                loading();
                                exit2 = 1;
                                break;
                            case 1:
                                System.out.println("System > Coloque a matricula do aluno <");
                                System.out.print("Digite:");
                                aux1 = teclado.next();

                                if(alunoDAOSet.buscarAluno(aux1))
                                {
                                    System.out.println("System > Já existe um aluno com essa matricula! <");
                                }
                                else
                                {
                                    teclado.nextLine();
                                    System.out.print("Digite o curso:");
                                    String curso = teclado.nextLine();
                                    System.out.print("Digite o nome:");
                                    String nome = teclado.nextLine();
                                    System.out.print("Digite a idade:");
                                    int idade = teclado.nextInt();

                                    alunoDAOSet.registrarAluno(nome,aux1,curso,idade);

                                    System.out.println("System > Aluno cadastrado com sucesso! <");

                                }

                                break;
                            case 2:
                                if(alunoDAOSet.verificarExistencia())
                                {
                                    System.out.println();
                                    System.out.println(alunoDAOSet.listarAlunos());
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            case 3:
                                if(alunoDAOSet.verificarExistencia())
                                {
                                    teclado.nextLine();
                                    System.out.print("Digite a matricula:");
                                    aux2 = teclado.nextLine();

                                    if(alunoDAOSet.buscarAluno(aux2))
                                    {

                                        System.out.println("System > Informacoes do aluno <");
                                        System.out.println(alunoDAOSet.mostrarAlunoEspecifico(aux2));

                                        System.out.println("Desesa excluir? S / N");
                                        aux1 = teclado.nextLine();

                                        if(aux1.equalsIgnoreCase("S"))
                                        {
                                            try
                                            {
                                                alunoDAOSet.excluirAluno(aux2);
                                            }catch (Exception e)
                                            {
                                                System.out.println(e);
                                            }

                                            System.out.println("System > Aluno excluido com sucesso! <");
                                        }
                                        else if(aux1.equalsIgnoreCase("N"))
                                        {
                                            System.out.println("System > Ok, nao vamos excluir o aluno <");
                                        }
                                        else
                                        {
                                            System.out.println("System > Opcao Invalida <");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("System > Nao existe um aluno com essa matricula! <");
                                    }
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            default:
                                System.out.println("System > Opcao Invalida <");
                        }
                    }while(exit2 != 1);
                    break;
                case 3:// Versao do SistemaDeEscola com ( Map ).
                    System.out.println("System > Versao Map < \n");
                    do
                    {
                        System.out.print("""
                                
                                [0] sair (volta para o sistema de escolhas)
                                [1] Cadastrar
                                [2] Listar
                                [3] Excluir
                                """);
                        System.out.print("Digite:");
                        op2 = teclado.nextInt();
                        switch (op2)
                        {
                            case 0:
                                System.out.println("System > Voltando para o sistema de escolhas! < \n");
                                loading();

                                exit2 = 1;
                                break;
                            case 1:
                                System.out.println("System > Coloque a matricula do aluno <");
                                System.out.print("Digite:");
                                aux1 = teclado.next();

                                if(alunoDAOMap.buscarAluno(aux1))
                                {
                                    System.out.println("System > Já existe um aluno com essa matricula! <");
                                }
                                else
                                {
                                    teclado.nextLine();
                                    System.out.print("Digite o curso:");
                                    String curso = teclado.nextLine();
                                    System.out.print("Digite o nome:");
                                    String nome = teclado.nextLine();
                                    System.out.print("Digite a idade:");
                                    int idade = teclado.nextInt();

                                    alunoDAOMap.registrarAluno(nome,aux1,curso,idade);

                                    System.out.println("System > Aluno cadastrado com sucesso! <");

                                }

                                break;
                            case 2:
                                if(alunoDAOMap.verificarExistencia())
                                {
                                    System.out.println();
                                    System.out.println(alunoDAOMap.listarAlunos());
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            case 3:
                                if(alunoDAOMap.verificarExistencia())
                                {
                                    teclado.nextLine();
                                    System.out.print("Digite a matricula:");
                                    aux1 = teclado.nextLine();

                                    if(alunoDAOMap.buscarAluno(aux1))
                                    {

                                        System.out.println("System > Informacoes do aluno <");
                                        System.out.println(alunoDAOMap.mostrarAlunoEspecifico(aux1));

                                        System.out.println("Desesa excluir? S / N");
                                        aux2 = teclado.nextLine();

                                        if(aux2.equalsIgnoreCase("S"))
                                        {
                                            alunoDAOMap.excluirAluno(aux1);
                                            System.out.println("System > Aluno excluido com sucesso! <");
                                        }
                                        else if(aux2.equalsIgnoreCase("N"))
                                        {
                                            System.out.println("System > Ok, nao vamos excluir o aluno <");
                                        }
                                        else
                                        {
                                            System.out.println("System > Opcao Invalida <");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("System > Nao existe um aluno com essa matricula! <");
                                    }
                                }
                                else
                                {
                                    System.out.println("System > Nao foi cadastrado nenhum aluno ainda, tente cadastrar pelo menos um para poder usar essa opcao!");
                                }
                                break;
                            default:
                                System.out.println("System > Opcao Invalida <");
                        }
                    }while(exit2 != 1);
                    break;
                default:
                    System.out.println("System > Opcao Invalida <");
            }

        }while(exit1 != 1);
    }
}