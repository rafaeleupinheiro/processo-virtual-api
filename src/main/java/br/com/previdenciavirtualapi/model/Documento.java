package br.com.previdenciavirtualapi.model;

import br.com.previdenciavirtualapi.enume.CategoriaBeneficiario;

import java.sql.Timestamp;
import java.util.Date;

public class Documento {
  protected CategoriaBeneficiario categoria;
  protected String id;
  protected String nomeArquivo;
  protected String extensaoArquivo;
  protected Timestamp dataCadastro;

  public Documento(CategoriaBeneficiario categoria, String id, String nomeArquivo, String extensaoArquivo, Timestamp dataCadastro) {
    this.id = id;
    this.categoria = categoria;
    this.nomeArquivo = nomeArquivo;
    this.extensaoArquivo = extensaoArquivo;
    this.dataCadastro = dataCadastro;
  }

  public Documento() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
