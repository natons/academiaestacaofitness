/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

/**
 *
 * @author Natanael
 */
public class TipoAlimento {
    private int idTipoAlimento;
    private String nome;

    public int getIdTipoAlimento() {
        return idTipoAlimento;
    }

    public void setIdTipoAlimento(int idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAlimento() {
    }

    public TipoAlimento(int idTipoAlimento, String nome) {
        this.idTipoAlimento = idTipoAlimento;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoDieta{" + "idTipoDieta=" + idTipoAlimento + ", nome=" + nome + '}';
    }
    
    
}
