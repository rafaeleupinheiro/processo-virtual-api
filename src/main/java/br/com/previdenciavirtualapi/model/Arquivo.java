package br.com.previdenciavirtualapi.model;

public class Arquivo {
  private String idDocumento;
  private byte[] arquivoBase64;

  public Arquivo(String idDocumento, byte[] arquivoBase64) {
    this.idDocumento = idDocumento;
    this.arquivoBase64 = arquivoBase64;
  }

  public Arquivo() {
  }

  public String getIdDocumento() {
    return idDocumento;
  }

  public void setIdDocumento(String idDocumento) {
    this.idDocumento = idDocumento;
  }

  public byte[] getArquivoBase64() {
    return arquivoBase64;
  }

  public void setArquivoBase64(byte[] arquivoBase64) {
    this.arquivoBase64 = arquivoBase64;
  }

}
