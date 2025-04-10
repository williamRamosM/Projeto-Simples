import java.util.Objects;

public class AlunoMap {
    private String nome, matricula, curso;
    private int idade;

    public AlunoMap()
    {

    }
    public AlunoMap(String nome, String matricula, String curso, int idade)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoMap alunoMap = (AlunoMap) o;
        return Objects.equals(matricula, alunoMap.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    public String toString()
    {
        return "Nome:"+nome+"\n" +
                "Idade:"+idade+"\n" +
                "Matricula:"+matricula+"\n" +
                "Curso:"+curso+"\n";
    }
}
