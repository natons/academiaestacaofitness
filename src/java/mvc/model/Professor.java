package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public class Professor extends Funcionario implements Qualificacao {

    private int idProfessor;

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Professor() {
    }

    public Professor(int idProfessor, int matricula, String nome, String cpf, String endereco, String status, String urlFoto, String senha, List<Telefone> telefones) {
        super(matricula, nome, cpf, endereco, status, urlFoto, senha, telefones);
        this.idProfessor = idProfessor;
    }

}
