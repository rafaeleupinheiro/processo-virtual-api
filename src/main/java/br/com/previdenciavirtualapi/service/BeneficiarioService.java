package br.com.previdenciavirtualapi.service;

import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.Beneficiario;
import br.com.previdenciavirtualapi.dao.BeneficiarioList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BeneficiarioService {

  public List<Beneficiario> pesquisar() throws BeneficiarioException {
    Map<String, Beneficiario> beneficiarios = BeneficiarioList.getInstance().getBeneficiarios();
    if (beneficiarios == null || beneficiarios.isEmpty()) {
      throw new BeneficiarioException("Nenhum beneficiário encontrado!");
    }
    return new ArrayList<>(beneficiarios.values());
  }

  public void cadastrar(Beneficiario beneficiario) throws BeneficiarioException {
    validacaoBeneficiario(beneficiario);
    Map<String, Beneficiario> beneficiarios = BeneficiarioList.getInstance().getBeneficiarios();
    if (beneficiarios == null || beneficiarios.isEmpty()) {
      throw new BeneficiarioException("Erro ao cadastrar beneficiário!");
    }
    if (beneficiarios.containsKey(beneficiario.getCpf())) {
      throw new BeneficiarioException("Beneficiário com cpf já cadastrado!");
    }
    beneficiarios.put(beneficiario.getCpf(), beneficiario);
  }

  private void validacaoBeneficiario(Beneficiario beneficiario) throws BeneficiarioException {
    if (beneficiario == null) {
      throw new BeneficiarioException("Favor informar os dados do beneficiário.");
    }
    if (beneficiario.getNome() == null || beneficiario.getNome().isEmpty()) {
      throw new BeneficiarioException("Favor informar o nome do beneficiário.");
    }
    if (beneficiario.getCpf() == null || beneficiario.getCpf().isEmpty()) {
      throw new BeneficiarioException("Favor informar o cpf do beneficiário.");
    }
    if (beneficiario.getOrgao() == null || beneficiario.getOrgao().isEmpty()) {
      throw new BeneficiarioException("Favor informar o orgão.");
    }
    if (beneficiario.getMatricula() == null || beneficiario.getMatricula().isEmpty()) {
      throw new BeneficiarioException("Favor informar a matricula do beneficiário.");
    }
  }
}
