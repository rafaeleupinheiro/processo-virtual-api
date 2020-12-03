package br.com.previdenciavirtualapi.service;

import br.com.previdenciavirtualapi.dao.BeneficiarioList;
import br.com.previdenciavirtualapi.dao.DocumentoList;
import br.com.previdenciavirtualapi.enume.CategoriaBeneficiario;
import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DocumentoService {

  public Map<String, List<Documento>> pesquisar(Beneficiario beneficiario) throws BeneficiarioException {
    validacaoBeneficiario(beneficiario);
    Map<String, Beneficiario> beneficiarios = BeneficiarioList.getInstance().getBeneficiarios();
    if (beneficiarios == null || beneficiarios.isEmpty() || !beneficiarios.containsKey(beneficiario.getCpf())) {
      throw new BeneficiarioException("Nenhum beneficiário encontrado!");
    }

    Map<String, Documento> documentos = DocumentoList.getInstance().getDocumentos().get(beneficiario.getCpf());
    if (documentos == null || documentos.isEmpty()) {
      throw new BeneficiarioException("Nenhum documento encontrado!");
    }
    List<Documento> docs = new ArrayList<>(documentos.values());
    return agruparDocumentos(docs);
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

  private Map<String, List<Documento>> agruparDocumentos(List<Documento> lista) {
    List<Documento> identificacao = new ArrayList<>();
    List<Documento> remuneracaoProventos = new ArrayList<>();
    List<Documento> contagemTempo = new ArrayList<>();
    List<Documento> vidaFuncional = new ArrayList<>();

    for (Documento doc : lista) {
      if (doc.getCategoria().equals(CategoriaBeneficiario.IDENTIFICACAO)) {
        identificacao.add(doc);
      }
      if (doc.getCategoria().equals(CategoriaBeneficiario.REMUNERACAO_PROVENTOS)) {
        remuneracaoProventos.add(doc);
      }
      if (doc.getCategoria().equals(CategoriaBeneficiario.CONTAGEM_DE_TEMPO)) {
        contagemTempo.add(doc);
      }
      if (doc.getCategoria().equals(CategoriaBeneficiario.VIDA_FUNCIONAL)) {
        vidaFuncional.add(doc);
      }
    }

    Map<String, List<Documento>> map = new HashMap<>();
    if (!identificacao.isEmpty()) {
      map.put("identificacao", identificacao);
    }

    if (!remuneracaoProventos.isEmpty()) {
      map.put("remuneracao_proventos", remuneracaoProventos);
    }

    if (!contagemTempo.isEmpty()) {
      map.put("contagem_de_tempo", contagemTempo);
    }

    if (!vidaFuncional.isEmpty()) {
      map.put("vida_funcional", vidaFuncional);
    }
    return map;
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
