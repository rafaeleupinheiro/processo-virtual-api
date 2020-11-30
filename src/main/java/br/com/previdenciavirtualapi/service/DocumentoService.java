package br.com.previdenciavirtualapi.service;

import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.Beneficiario;
import br.com.previdenciavirtualapi.model.BeneficiarioList;
import br.com.previdenciavirtualapi.model.DocumentoBeneficiario;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DocumentoService {

  public DocumentoBeneficiario pesquisar(Beneficiario beneficiario) throws BeneficiarioException {
    validacaoBeneficiario(beneficiario);
    Map<String, Beneficiario> beneficiarios = BeneficiarioList.getInstance().getBeneficiarios();
    if (beneficiarios == null || beneficiarios.isEmpty() || !beneficiarios.containsKey(beneficiario.getCpf())) {
      throw new BeneficiarioException("Nenhum beneficiário encontrado!");
    }

    DocumentoBeneficiario documentoBeneficiario = BeneficiarioList.getInstance().getDocumentos().get(beneficiario.getCpf());
    if (documentoBeneficiario == null) {
      throw new BeneficiarioException("Nenhum documento encontrado!");
    }
    return documentoBeneficiario;
  }

  private void validacaoBeneficiario(Beneficiario beneficiario) throws BeneficiarioException {
    if (beneficiario == null) {
      throw new BeneficiarioException("Favor informar os dados do beneficiário.");
    }
    if (beneficiario.getCpf() == null || beneficiario.getCpf().isEmpty()) {
      throw new BeneficiarioException("Favor informar o cpf do beneficiário.");
    }
  }
}
