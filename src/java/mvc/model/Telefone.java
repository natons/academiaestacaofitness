package mvc.model;

/**
 *
 * @author Luciana
 */
public class Telefone {
    private int idTelefone;
    private String numero;
    
    
    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Telefone() {
    }

    public Telefone(int idTelefone, String numero) {
        this.idTelefone = idTelefone;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\n Telefone:" + 
                "\n idTelefone=" + getIdTelefone() + 
                "\n numero=" + getNumero();
    }
    
    
        
}
