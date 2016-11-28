package mvc.model;

/**
 *
 * @author Luciana
 */
public class AlimentoDieta {

    private int idAlimentoDieta;
    private Dieta dieta;
    private Alimento alimento;

    public int getIdAlimentoDieta() {
        return idAlimentoDieta;
    }

    public void setIdAlimentoDieta(int idAlimentoDieta) {
        this.idAlimentoDieta = idAlimentoDieta;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public AlimentoDieta() {
    }

    public AlimentoDieta(int idAlimentoDieta, Dieta dieta, Alimento alimento, String tipo) {
        this.idAlimentoDieta = idAlimentoDieta;
        this.dieta = dieta;
        this.alimento = alimento;
    }

}
