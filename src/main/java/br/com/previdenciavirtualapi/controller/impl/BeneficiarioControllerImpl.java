package br.com.previdenciavirtualapi.controller.impl;

import br.com.previdenciavirtualapi.controller.BeneficiarioController;
import br.com.previdenciavirtualapi.exception.BeneficiarioException;
import br.com.previdenciavirtualapi.model.Beneficiario;
import br.com.previdenciavirtualapi.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeneficiarioControllerImpl implements BeneficiarioController {

  @Autowired private BeneficiarioService service;

  @Override
  public ResponseEntity<?> pesquisar() {
    try {
      return ResponseEntity.ok(service.pesquisar());
    } catch (BeneficiarioException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @Override
  public ResponseEntity<?> cadastrar(Beneficiario beneficiario) {
    try {
      service.cadastrar(beneficiario);
      return ResponseEntity.ok(HttpStatus.OK);
    } catch (BeneficiarioException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
