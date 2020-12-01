package br.com.previdenciavirtualapi.model;

public class BeneficiarioDocumento {
  private String cpf;
  private String idDocumento;

  public BeneficiarioDocumento(String cpf, String idDocumento) {
    this.cpf = cpf;
    this.idDocumento = idDocumento;
  }

  public BeneficiarioDocumento() {
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getIdDocumento() {
    return idDocumento;
  }

  public void setIdDocumento(String idDocumento) {
    this.idDocumento = idDocumento;
  }
}
