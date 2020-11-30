package br.com.previdenciavirtualapi.model;

import java.util.Date;

public class Documento {
  private String nomeArquivo;
  private String extensaoArquivo;
  private Date dataupload;
  private byte[] arquivoBase64;

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

  public byte[] getArquivoBase64() {
    return arquivoBase64;
  }

  public void setArquivoBase64(byte[] arquivoBase64) {
    this.arquivoBase64 = arquivoBase64;
  }

  public Date getDataupload() {
    return dataupload;
  }

  public void setDataupload(Date dataupload) {
    this.dataupload = dataupload;
  }
}
