package br.com.previdenciavirtualapi.service;

import br.com.previdenciavirtualapi.dao.BeneficiarioList;
import br.com.previdenciavirtualapi.dao.DocumentoList;
import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DocumentoService {

  public List<Documento> pesquisar(Beneficiario beneficiario) throws BeneficiarioException {
    validacaoBeneficiario(beneficiario);
    Map<String, Beneficiario> beneficiarios = BeneficiarioList.getInstance().getBeneficiarios();
    if (beneficiarios == null || beneficiarios.isEmpty() || !beneficiarios.containsKey(beneficiario.getCpf())) {
      throw new BeneficiarioException("Nenhum beneficiário encontrado!");
    }

    Map<String, Documento> documentos = DocumentoList.getInstance().getDocumentos().get(beneficiario.getCpf());
    if (documentos == null || documentos.isEmpty()) {
      throw new BeneficiarioException("Nenhum documento encontrado!");
    }
    return new ArrayList<>(documentos.values());
  }

  public void salvar(ArquivoRequest request) throws BeneficiarioException {
    validacaoArquivo(request);

    String idDocumento = UUID.randomUUID().toString();
    Documento documento = new Documento(request.getCategoria(), idDocumento, request.getNomeArquivo(),
        request.getExtensaoArquivo(), request.getDataCadastro());
    Arquivo arquivo = new Arquivo(idDocumento, request.getArquivoBase64());

    DocumentoList.getInstance().getDocumentos().get(request.getCpf()).put(idDocumento, documento);
    DocumentoList.getInstance().getArquivos().put(idDocumento, arquivo);
  }

  public Arquivo exibir(BeneficiarioDocumento beneficiarioDocumento) throws BeneficiarioException {
    validacaoBeneficiarioDocumento(beneficiarioDocumento);
    Map<String, Documento> documentos = DocumentoList.getInstance().getDocumentos().get(beneficiarioDocumento.getCpf());
    if (documentos == null || documentos.isEmpty()) {
      throw new BeneficiarioException("Nenhum beneficiário encontrado!");
    }

    if (!documentos.containsKey(beneficiarioDocumento.getIdDocumento())) {
      throw new BeneficiarioException("Documento não encontrado!");
    }
    return DocumentoList.getInstance().getArquivos().get(documentos.get(beneficiarioDocumento.getIdDocumento()).getId());
  }

  private void validacaoBeneficiario(Beneficiario beneficiario) throws BeneficiarioException {
    if (beneficiario == null) {
      throw new BeneficiarioException("Favor informar os dados do beneficiário.");
    }
    if (beneficiario.getCpf() == null || beneficiario.getCpf().isEmpty()) {
      throw new BeneficiarioException("Favor informar o cpf do beneficiário.");
    }
  }

  private void validacaoBeneficiarioDocumento(BeneficiarioDocumento beneficiarioDocumento) throws BeneficiarioException {
    if (beneficiarioDocumento == null) {
      throw new BeneficiarioException("Favor informar os dados do beneficiário.");
    }
    if (beneficiarioDocumento.getCpf() == null || beneficiarioDocumento.getCpf().isEmpty()) {
      throw new BeneficiarioException("Favor informar o cpf do beneficiário.");
    }
    if (beneficiarioDocumento.getIdDocumento() == null || beneficiarioDocumento.getIdDocumento().isEmpty()) {
      throw new BeneficiarioException("Favor informar o identificador do documento.");
    }
  }

  private void validacaoArquivo(ArquivoRequest request) throws BeneficiarioException {
    if (request == null) {
      throw new BeneficiarioException("Favor informar os dados do documento.");
    }
    if (request.getCategoria() == null) {
      throw new BeneficiarioException("Favor informar a categoria documento.");
    }
    if (request.getNomeArquivo() == null || request.getNomeArquivo().isEmpty()) {
      throw new BeneficiarioException("Favor informar o nome do documento.");
    }
    if (request.getExtensaoArquivo() == null || request.getExtensaoArquivo().isEmpty()) {
      throw new BeneficiarioException("Favor informar a extensão do documento.");
    }
    if (request.getDataCadastro() == null) {
      throw new BeneficiarioException("Favor informar a data do upload do documento.");
    }
    if (request.getArquivoBase64() == null) {
      throw new BeneficiarioException("Favor informar o base64 do documento.");
    }
  }
}
