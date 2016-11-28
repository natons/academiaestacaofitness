package mvc.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luciana
 */
public class Aluno {

    private int idAluno;
    private String nome;
    private double peso;
    private String endereco;
    private Date dataNascimento;
    private String senha;
    private String status;
    private List<Telefone> telefones;
    private String urlFoto;
    private int matricula;
    private Dieta dieta;
    private List<Avaliacao> avaliacoes;
    private List<Exercicio> exercicios;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public Aluno() {
    }

    public Aluno(int idAluno, String nome, double peso, String endereco, Date dataNascimento, 
            String senha, String status, List<Telefone> telefones, String urlFoto, int matricula,
            Dieta dieta, List<Avaliacao> avaliacoes, List<Exercicio> exercicios) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.peso = peso;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.status = status;
        this.telefones = telefones;
        this.urlFoto = urlFoto;
        this.matricula = matricula;
        this.dieta = dieta;
        this.avaliacoes = avaliacoes;
        this.exercicios = exercicios;
    }

    @Override
    public String toString() {
        return "\n Aluno: "
                + "\n Código Aluno:" + getIdAluno()
                + "\n Nome:" + getNome()
                + "\n Peso: " + getPeso()
                + "\n Status:" + getStatus()
                + "\n Data de Nascimento: " + getDataNascimento()
                + "\n Endereco: " + getEndereco()
                + "\n Senha: " + getSenha()
                + "\n telefone:" + getTelefones()
                + "\n matrícula: " + getMatricula()
                + "\n url Foto:" + getUrlFoto()
                + "\n Dieta:"+ getDieta() 
                + "\n Avaliacoes:"+ getAvaliacoes()
                + "\n Exercícios:"+ getExercicios();
    }

    

    

}
