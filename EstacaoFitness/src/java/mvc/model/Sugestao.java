package mvc.model;

import java.util.Date;

/**
 *
 * @author Luciana
 */
public class Sugestao {
    private int idSugestao;
    private Date data;
    private String descricao;
    private String areaSugestao;
    private Aluno aluno;

    public int getIdSugestao() {
        return idSugestao;
    }

    public void setIdSugestao(int idSugestao) {
        this.idSugestao = idSugestao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaSugestao() {
        return areaSugestao;
    }

    public void setAreaSugestao(String areaSugestao) {
        this.areaSugestao = areaSugestao;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Sugestao() {
    }

    public Sugestao(int idSugestao, Date data, String descricao, String areaSugestao, Aluno aluno) {
        this.idSugestao = idSugestao;
        this.data = data;
        this.descricao = descricao;
        this.areaSugestao = areaSugestao;
        this.aluno = aluno;
        
    }

    @Override
    public String toString() {
        return "Sugestao{" + "idSugestao=" + idSugestao + ", data=" + data + ", descricao=" + descricao + ", areaSugestao=" + areaSugestao + ", aluno=" + aluno + '}';
    }
    
    

    
}
