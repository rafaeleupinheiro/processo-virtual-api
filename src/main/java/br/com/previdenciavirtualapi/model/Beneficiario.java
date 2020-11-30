package br.com.previdenciavirtualapi.model;

public class Beneficiario {
  private String nome;
  private String cpf;
  private String orgao;
  private String matricula;

  public Beneficiario(String nome, String cpf, String orgao, String matricula) {
    this.nome = nome;
    this.cpf = cpf;
    this.orgao = orgao;
    this.matricula = matricula;
  }

  public Beneficiario() {
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

  public String getOrgao() {
    return orgao;
  }

  public void setOrgao(String orgao) {
    this.orgao = orgao;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
}
