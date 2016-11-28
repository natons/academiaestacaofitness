package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public class Estagiario extends Funcionario {

    private int idEstagiario;

    public int getIdEstagiario() {
        return idEstagiario;
    }

    public void setIdEstagiario(int idEstagiario) {
        this.idEstagiario = idEstagiario;
    }

    public Estagiario() {
    }

    public Estagiario(int idEstagiario, int matricula, String nome, String cpf, String endereco, String status, String urlFoto, String senha, List<Telefone> telefones) {
        super(matricula, nome, cpf, endereco, status, urlFoto, senha, telefones);
        this.idEstagiario = idEstagiario;
    }

}
