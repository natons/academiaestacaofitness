package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public class Exercicio {
    private int idExercicio;
    private String descricao; 
    private Aluno aluno;
    private Professor professor;
    private Estagiario estagiario;
    private List<Tipo> tipos;

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Estagiario getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(Estagiario estagiario) {
        this.estagiario = estagiario;
    }
    
    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Exercicio() {
    }

    public Exercicio(int idExercicio, String descricao,
    Aluno aluno, Professor professor, Estagiario estagiario, List<Tipo> tipos) {
        this.idExercicio = idExercicio;
        this.descricao = descricao;
        this.aluno = aluno;
        this.professor = professor;
        this.estagiario = estagiario;
        this.tipos = tipos;
    }

    

}
