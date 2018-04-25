package mvc.model;

/**
 *
 * @author Luciana
 */
public class Alimento {

    private int idAlimento;
    private String nome;
    private String urlImagem;
    private TipoAlimento tipoAlimento;

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
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
    
    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public Alimento() {
    }

    public Alimento(int idAlimento, String nome, String urlImagem, TipoAlimento tipoAlimento) {
        this.idAlimento = idAlimento;
        this.nome = nome;
        this.urlImagem = urlImagem;
        this.tipoAlimento = tipoAlimento;
    }

    

}
