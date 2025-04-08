
import java.time.LocalDate;
import java.time.Period;

public class JmAlunos extends Jmessoa {

    private int IDAluno;
    private String responsavel, turma;
    private int numeroMatricula;
    //private ArrayList<String> aluno; NAO PRECISO DE UMA LISTA AQUI, SO INFOR

    public JmAlunos(String responsavel, String turma, String nome, String endereco, String numeroTelefone, String sexo, LocalDate dataNascimento) {
        super(nome, endereco, numeroTelefone, sexo, dataNascimento);
        this.IDAluno = GeradorID.gerarIdAluno();
        this.responsavel = responsavel;
        this.turma = turma;
        this.numeroMatricula = GeradorID.matricula();
    }

    public int getIDAluno() {
        return IDAluno;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getTurma() {
        return turma;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "JmAlunos{" + "responsavel=" + responsavel + ", turma=" + turma + ", numeroMatricula=" + numeroMatricula + '}';
    }

    public int calcIdadeAluno() {
        LocalDate dataHoje = LocalDate.now();
        return Period.between(getDataNascimento(), dataHoje).getYears(); //getYears retorna o intervalo de anos entre as datas
    }

    public String exibirFichaAluno() {
        String ficha = "Matricula: " + numeroMatricula + "\n"
                + "Nome: " + nome + "\n"
                + "Nascimento: " + dataNascimento + "\n"
                + "Turma: " + turma + "\n"
                + "endereço: " + endereco + "\n"
                + "Sexo: " + sexo + "\n"
                + "Responsavel: " + responsavel + "\n"
                + "Telefone: " + numeroTelefone + "\n";
        return ficha;
    }

    public void atualizarEndereco(String enderecoNovo) {
        this.setEndereco(enderecoNovo);
    }

    public void atualizarTelefone(String novoNumero) {
        this.setNumeroTelefone(novoNumero);
    }

    public boolean disvincularAluno(int matricula) {
        if (matricula == numeroMatricula) {
            this.setTurma(null);
            return true;
        }
        return false;// nao encontrou
    }

    public String validacaoAluno(JmTurma t) {
        LocalDate dataHoje = LocalDate.now();
        int idade = Period.between(getDataNascimento(), dataHoje).getYears();
        if (idade >= t.getFaixaEtariaMn() && idade <= t.getFaixaEtariaMx()) {
            return t.getNomeTurma();// volta o nome da turma que pode adicionar o kid
        }
        return null;// se nao tiver turma dessa msm idade 
    }
}
