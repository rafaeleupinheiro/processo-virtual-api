package br.com.previdenciavirtualapi.model;

import br.com.previdenciavirtualapi.enume.CategoriaBeneficiario;

import java.util.Map;

public class DocumentoBeneficiario {
  private String cpf;
  private Map<CategoriaBeneficiario, Documento> documentos;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Map<CategoriaBeneficiario, Documento> getDocumentos() {
    return documentos;
  }

  public void setDocumentos(Map<CategoriaBeneficiario, Documento> documentos) {
    this.documentos = documentos;
  }
}
