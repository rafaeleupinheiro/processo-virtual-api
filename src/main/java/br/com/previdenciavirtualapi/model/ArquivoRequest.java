package br.com.previdenciavirtualapi.model;

import br.com.previdenciavirtualapi.enume.CategoriaBeneficiario;

import java.sql.Timestamp;

public class ArquivoRequest {
  protected String cpf;
  protected CategoriaBeneficiario categoria;
  protected String nomeArquivo;
  protected String extensaoArquivo;
  protected Timestamp dataCadastro;
  protected byte[] arquivoBase64;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public CategoriaBeneficiario getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaBeneficiario categoria) {
    this.categoria = categoria;
  }

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }

  public String getExtensaoArquivo() {
    return extensaoArquivo;
  }

  public void setExtensaoArquivo(String extensaoArquivo) {
    this.extensaoArquivo = extensaoArquivo;
  }

  public Timestamp getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Timestamp dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public byte[] getArquivoBase64() {
    return arquivoBase64;
  }

  public void setArquivoBase64(byte[] arquivoBase64) {
    this.arquivoBase64 = arquivoBase64;
  }
}
