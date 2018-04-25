package mvc.model;

/**
 *
 * @author Luciana
 */
public class Lembrete {

    private int idLembrete;
    private String titulo;
    private String corpo;
    private Recepcionista atendente;

    public int getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(int idLembrete) {
        this.idLembrete = idLembrete;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Recepcionista getRecepcionista() {
        return atendente;
    }

    public void setRecepcionista(Recepcionista atendente) {
        this.atendente = atendente;
    }

    public Lembrete() {
    }

    public Lembrete(int idLembrete, String titulo, String corpo, Recepcionista atendente) {
        this.idLembrete = idLembrete;
        this.titulo = titulo;
        this.corpo = corpo;
        this.atendente = atendente;
    }

}
