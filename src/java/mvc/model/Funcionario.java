package mvc.model;

import java.util.List;

/**
 *
 * @author Luciana
 */
public abstract class Funcionario {
    private int matricula;
    private String nome;
    private String cpf;
    private String endereco;
    private String status;
    private String urlFoto;
    private String senha;
    private List<Telefone> telefones;
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Telefone> getTelefones() {
        return telefones;
    }
    
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Funcionario() {
    }

    public Funcionario(int matricula, String nome, String cpf, String endereco, String status, String urlFoto, String senha, List<Telefone> telefones) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.status = status;
        this.urlFoto = urlFoto;
        this.senha = senha;
        this.telefones = telefones;
    }

    
    
  
    
}
