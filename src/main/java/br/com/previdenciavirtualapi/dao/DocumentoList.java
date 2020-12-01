package br.com.previdenciavirtualapi.dao;

import br.com.previdenciavirtualapi.model.Arquivo;
import br.com.previdenciavirtualapi.model.Documento;

import java.util.HashMap;
import java.util.Map;

public class DocumentoList {
  private static DocumentoList instance = new DocumentoList();
  private Map<String, Map<String, Documento>> documentos;
  private Map<String, Arquivo> arquivos;

  private DocumentoList() {
    documentos = new HashMap<>();
    documentos.put("10210210214", new HashMap<>());
    documentos.put("01401401425", new HashMap<>());
    documentos.put("74174174123", new HashMap<>());
    documentos.put("25825825841", new HashMap<>());
    documentos.put("12315142581", new HashMap<>());
    documentos.put("14914914952", new HashMap<>());
    arquivos = new HashMap<>();
  }

  public static DocumentoList getInstance() {
    return instance;
  }

  public Map<String, Map<String, Documento>> getDocumentos() {
    return documentos;
  }

  public void setDocumentos(Map<String, Map<String, Documento>> documentos) {
    this.documentos = documentos;
  }

  public Map<String, Arquivo> getArquivos() {
    return arquivos;
  }

  public void setArquivos(Map<String, Arquivo> arquivos) {
    this.arquivos = arquivos;
  }
}
