package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public class Recepcionista extends Funcionario {

    private int idRecepcionista;
    private List<Lembrete> lembretes;

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public Recepcionista() {
    }

    public Recepcionista(int idRecepcionista, int matricula, String nome, String cpf, String endereco, 
            String status, String urlFoto, String senha, List<Telefone> telefones, List<Lembrete> lembretes) {
        super(matricula, nome, cpf, endereco, status, urlFoto, senha, telefones);
        this.idRecepcionista = idRecepcionista;
        this.lembretes = lembretes;
    }

}
