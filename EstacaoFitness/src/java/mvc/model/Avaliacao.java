package mvc.model;

import java.util.Date;

/**
 *
 * @author Luciana
 */
public class Avaliacao {
    private int idAvaliacao;
    private Date dataAvaliacao;
    private String resultado;
    private double valor;
    private Date validade;
    private Aluno aluno;
    private Professor professor;

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao, Date dataAvaliacao, String resultado, double valor, Date validade, Aluno aluno, Professor professor) {
        this.idAvaliacao = idAvaliacao;
        this.dataAvaliacao = dataAvaliacao;
        this.resultado = resultado;
        this.valor = valor;
        this.validade = validade;
        this.aluno = aluno;
        this.professor = professor;
    }
}
