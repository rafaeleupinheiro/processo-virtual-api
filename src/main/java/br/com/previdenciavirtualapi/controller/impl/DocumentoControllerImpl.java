package br.com.previdenciavirtualapi.controller.impl;

import br.com.previdenciavirtualapi.controller.DocumentoController;
import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.ArquivoRequest;
import br.com.previdenciavirtualapi.model.Beneficiario;
import br.com.previdenciavirtualapi.model.BeneficiarioDocumento;
import br.com.previdenciavirtualapi.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentoControllerImpl implements DocumentoController {

  @Autowired private DocumentoService service;

  @Override
  public ResponseEntity<?> pesquisar(Beneficiario beneficiario) {
    try {
      return ResponseEntity.ok(service.pesquisar(beneficiario));
    } catch (BeneficiarioException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @Override
  public ResponseEntity<?> salvar(ArquivoRequest request) {
    try {
      service.salvar(request);
      return ResponseEntity.ok(HttpStatus.OK);
    } catch (BeneficiarioException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @Override
  public ResponseEntity<?> exibir(BeneficiarioDocumento beneficiarioDocumento) {
    try {
      return ResponseEntity.ok(service.exibir(beneficiarioDocumento));
    } catch (BeneficiarioException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }
}
