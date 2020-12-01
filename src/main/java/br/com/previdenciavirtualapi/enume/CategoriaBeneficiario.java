package br.com.previdenciavirtualapi.enume;

public enum CategoriaBeneficiario {
  IDENTIFICACAO(1, "IDENTIFICAÇÃO"),
  VIDA_FUNCIONAL(2, "VIDA FUNCIONAL"),
  CONTAGEM_DE_TEMPO(3, "CONTAGEM DE TEMPO"),
  REMUNERACAO_PROVENTOS(4, "REMUNERAÇÃO / PROVENTOS");

  private Integer codigo;
  private String descricao;

  CategoriaBeneficiario(Integer codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
