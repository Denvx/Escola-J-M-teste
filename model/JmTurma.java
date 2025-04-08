
import java.util.ArrayList;

public class JmTurma {

    private int idTurma;
    private String nomeTurma, turno;
    private int faixaEtariaMn, faixaEtariaMx, capacidadeTurma;
    private ArrayList<JmAlunos> listAlunos;

    public Turma(String nomeTurma, String turno, int faixaEtariaMx, int faixaEtariaMn, int capacidadeTurma) {
        this.idTurma = GeradorID.gerarIDTurma();
        this.nomeTurma = nomeTurma;
        this.turno = turno;
        this.faixaEtariaMx = faixaEtariaMx;
        this.faixaEtariaMn = faixaEtariaMn;
        this.capacidadeTurma = capacidadeTurma;
        this.listAlunos = new ArrayList<>();
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getFaixaEtariaMn() {
        return faixaEtariaMn;
    }

    public void setFaixaEtariaMn(int faixaEtariaMn) {
        this.faixaEtariaMn = faixaEtariaMn;
    }

    public int getFaixaEtariaMx() {
        return faixaEtariaMx;
    }

    public void setFaixaEtariaMx(int faixaEtariaMx) {
        this.faixaEtariaMx = faixaEtariaMx;
    }

    public int getCapacidadeTurma() {
        return capacidadeTurma;
    }

    public void setCapacidadeTurma(int capacidadeTurma) {
        this.capacidadeTurma = capacidadeTurma;
    }

    public ArrayList<JmAlunos> getListAlunos() {
        return listAlunos;
    }

    public void setListAlunos(ArrayList<JmAlunos> listAlunos) {
        this.listAlunos = listAlunos;
    }

    @Override
    public String toString() {
        return "Turma{" + "idTurma=" + idTurma + ", nomeTurma=" + nomeTurma + ", turno=" + turno + ", faixaEtariaMn=" + faixaEtariaMn + ", faixaEtariaMx=" + faixaEtariaMx + ", capacidadeTurma=" + capacidadeTurma + ", listAlunos=" + listAlunos + '}';
    }

    public boolean adicionarAluno(JmAlunos aluno) {
        if (listAlunos.size() <= capacidadeTurma) {// Verifica se a tem menos mais de 15 alunos, se tiver, nao matricula
            listAlunos.add(aluno);// adiciona o aluno a turma
            return true;// 'true' porque conseguiu matricular
        }
        return false;// 'false' se nao consegui espeço na turma 
    }

    public boolean removerAluno(int alunoId) {
        for (int i = 0; i < listAlunos.size(); i++) {
            if (alunoId == listAlunos.get(i).getIDAluno()) {
                listAlunos.remove(i);
                return true;// achou e removeu
            }
        }
        return false; // nao chou o aluno
    }

    // Este método é chamado na TURMA ATUAL do aluno
    public boolean trocarAlunoDeTurma(int matricula, String nomeNovaTurma, Turma novaTurma) {
        for (int i = 0; i < listAlunos.size(); i++) {
            if (matricula == listAlunos.get(i).getNumeroMatricula()) { // Verifica se encontrou o aluno pela matrícula
                JmAlunos aluno = listAlunos.get(i);// Pega o aluno da turma atual
                listAlunos.remove(i);// Remove o aluno da turma atual (this)
                if (novaTurma.getNomeTurma().equalsIgnoreCase(nomeNovaTurma)) {
                    aluno.setTurma(novaTurma.getNomeTurma());
                    novaTurma.adicionarAluno(aluno);
                    return true;
                }
            }
        }
        return false; // Aluno não encontrado na turma atual
    }

    public String mostrarAlunos() {
        String nomes = "";
        for (JmAlunos listAluno : listAlunos) {
            nomes += listAluno.getNome() + "\n";
        }
        return nomes;
    }

    public int retornarTamTurma() {
        return listAlunos.size();
    }
}
