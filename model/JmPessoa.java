
import java.time.LocalDate;

public class JmPessoa {

    protected String nome, endereco, numeroTelefone, sexo;
    protected LocalDate dataNascimento;

    public JmPessoa(String nome, String endereco, String numeroTelefone, String sexo, LocalDate dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public JmPessoa(String nome, String endereco, String numeroTelefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
