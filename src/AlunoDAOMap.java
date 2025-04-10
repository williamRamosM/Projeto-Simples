import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
public class AlunoDAOMap {

    Map<AlunoMap, AlunoMap> hashAluno = new HashMap<>();

    public void registrarAluno(String nome, String matricula, String curso, int idade)
    {
        AlunoMap aluno = new AlunoMap(nome, matricula, curso, idade);
        hashAluno.put(aluno,aluno);
    }

    public boolean buscarAluno(String matricula)
    {
        for(AlunoMap aluno : hashAluno.keySet())
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

        for(AlunoMap aluno : hashAluno.keySet())
        {
            text = text + aluno.toString() + "\n";
        }

        return text;
    }

    public void excluirAluno(String matricula)
    {
        Iterator<AlunoMap> iteratorAlunoMap = hashAluno.keySet().iterator(); // SERVE PARA REMOVER O ALUNO COM SEGURANCA.
        while(iteratorAlunoMap.hasNext())
        {
            AlunoMap alunoMap = iteratorAlunoMap.next();
            if(alunoMap.getMatricula().equals(matricula))
            {
                iteratorAlunoMap.remove();
            }
        }
    }

    public String mostrarAlunoEspecifico(String matricula)
    {
        String text = "";
        for(AlunoMap aluno : hashAluno.keySet())
        {

            if(aluno.getMatricula().equals(matricula))
                text = text + aluno.toString();
        }
        return text;
    }
}
