package br.com.previdenciavirtualapi.model;

import java.util.HashMap;
import java.util.Map;

public class BeneficiarioList {
  private static BeneficiarioList instance = new BeneficiarioList();
  private Map<String, Beneficiario> beneficiarios;
  private Map<String, DocumentoBeneficiario> documentos;

  private BeneficiarioList() {
    beneficiarios = new HashMap<>();
    beneficiarios.put("10210210214", new Beneficiario("BENEFICIARIO 1", "10210210214", "ORGÃO 1", "00000001"));
    beneficiarios.put("01401401425", new Beneficiario("BENEFICIARIO 2", "01401401425", "ORGÃO 2", "00000002"));
    beneficiarios.put("74174174123", new Beneficiario("BENEFICIARIO 3", "74174174123", "ORGÃO 2", "00000003"));
    beneficiarios.put("25825825841", new Beneficiario("BENEFICIARIO 4", "25825825841", "ORGÃO 3", "00000004"));
    beneficiarios.put("12315142581", new Beneficiario("BENEFICIARIO 5", "12315142581", "ORGÃO 2", "00000005"));
    beneficiarios.put("14914914952", new Beneficiario("BENEFICIARIO 6", "14914914952", "ORGÃO 1", "00000006"));

    documentos = new HashMap<>();
  }

  public static BeneficiarioList getInstance() {
    return instance;
  }

  public Map<String, Beneficiario> getBeneficiarios() {
    return beneficiarios;
  }

  public Map<String, DocumentoBeneficiario> getDocumentos() {
    return documentos;
  }
}
