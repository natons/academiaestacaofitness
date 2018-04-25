package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public class Nutricionista extends Funcionario {

    private int idNutricionista;

    public int getIdNutricionista() {
        return idNutricionista;
    }

    public void setIdNutricionista(int idNutricionista) {
        this.idNutricionista = idNutricionista;
    }

    public Nutricionista() {
    }

    public Nutricionista(int idNutricionista, int matricula, String nome, String cpf, String endereco, String status, String urlFoto, String senha, List<Telefone> telefones) {
        super(matricula, nome, cpf, endereco, status, urlFoto, senha, telefones);
        this.idNutricionista = idNutricionista;
    }

}
