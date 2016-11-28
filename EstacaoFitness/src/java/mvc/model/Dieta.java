package mvc.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luciana
 */
public class Dieta {

    private int idDieta;
    private Date validade;
    private String descricao;
    private List<Alimento> alimentos;
    private Aluno aluno;
    private Nutricionista nutricionista;

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    public Dieta() {
    }

    public Dieta(int idDieta, Date validade, String descricao, List<Alimento> alimentos, Nutricionista nutricionista,
            Aluno aluno) {
        this.idDieta = idDieta;
        this.validade = validade;
        this.descricao = descricao;
        this.alimentos = alimentos;
        this.aluno = aluno;
        this.nutricionista = nutricionista;
    }

    @Override
    public String toString() {
        return "\n Dieta{"
                + "\n idDieta=" + getIdDieta()
                + "\n validade=" + getValidade()
                + "\n descricao=" + getDescricao()
                + "\n alimentos=" + getAlimentos()
                + "\n aluno" + getAluno()
                + "\n Nutricionista" + getNutricionista();
    }

}
