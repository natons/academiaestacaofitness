package mvc.model;

/**
 *
 * @author Luciana
 */
public class Tipo {

    private int idTipo;
    private String nome;
    private String urlImagem;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Tipo() {
    }

    public Tipo(int idTipo) {
        this.idTipo = idTipo;
    }

}
