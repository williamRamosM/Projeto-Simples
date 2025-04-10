import java.util.ArrayList;
import java.util.List;
public class AlunoDAOList {

    private List <Aluno> arrayAluno = new ArrayList<Aluno>();
    private Aluno aluno = new Aluno();

    public void registrar(Aluno aluno)
    {
        arrayAluno.add(aluno);
    }

    public Aluno buscarAluno(String matricula)
    {
        for(int i = 0; i<arrayAluno.size(); i++)
        {
            aluno = arrayAluno.get(i);

            if(aluno.getMatricula().equals(matricula))
            {
                return aluno;
            }
        }
        return null;
    }

    public boolean verificarExistencia()
    {
        return !arrayAluno.isEmpty();
    }

    public String listarAlunos()
    {
        String text = "";

        for(int i = 0; i<arrayAluno.size(); i++)
        {
            text += arrayAluno.get(i).toString()+"\n";
        }

        return text;
    }
    public void excluirAluno(String matricula)
    {
        for(int i = 0; i<arrayAluno.size(); i++)
        {
            aluno = arrayAluno.get(i);
            if(aluno.getMatricula().equals(matricula))
            {
                arrayAluno.remove(i);
            }
        }
    }

}
