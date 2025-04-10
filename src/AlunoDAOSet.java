import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class AlunoDAOSet {

    private Set<AlunoSet> hashAluno = new HashSet<>();


    public void registrarAluno(String nome, String matricula, String curso, int idade)
    {
        AlunoSet aluno = new AlunoSet(nome, matricula, curso, idade);
        hashAluno.add(aluno);
    }

    public boolean buscarAluno(String matricula)
    {
        for(AlunoSet aluno : hashAluno)
        {
            if(aluno.getMatricula().equals(matricula))
            {
                return true;
            }
        }
        return false;
    }

    public boolean verificarExistencia()
    {
        return !hashAluno.isEmpty();
    }

    public String listarAlunos()
    {
        String text = "";

        for(AlunoSet aluno : hashAluno)
        {
            text = text + aluno.toString() + "\n";
        }

        return text;
    }

    public void excluirAluno(String matricula)
    {
        Iterator <AlunoSet> iteratorAlunoSet = hashAluno.iterator(); // SERVE PARA REMOVER O ALUNO COM SEGURANCA.
            while (iteratorAlunoSet.hasNext())
            {
                AlunoSet aluno = iteratorAlunoSet.next();
                if(aluno.getMatricula().equals(matricula))
                {
                    iteratorAlunoSet.remove();
                }
            }
    }

    public String mostrarAlunoEspecifico(String matricula)
    {
        String text = "";
        for(AlunoSet aluno : hashAluno)
        {

            if(aluno.getMatricula().equals(matricula))
                text = text + aluno.toString();
        }
        return text;
    }

}
