public class Aluno {
    private String nome, matricula, curso;
    private int idade;

    public Aluno()
    {

    }
    public Aluno(String nome, String matricula, String curso, int idade)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
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

    public String toString()
    {
        return "Nome:"+nome+"\n" +
                "Idade:"+idade+"\n" +
                "Matricula:"+matricula+"\n" +
                "Curso:"+curso+"\n";
    }
}
