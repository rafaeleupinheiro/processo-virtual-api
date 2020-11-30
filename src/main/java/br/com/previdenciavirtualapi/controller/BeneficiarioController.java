package br.com.previdenciavirtualapi.controller;

import br.com.previdenciavirtualapi.model.Beneficiario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"BENEFICIÁRIO"})
@CrossOrigin(origins = "*")
@RequestMapping("/beneficiario")
public interface BeneficiarioController {

  @ApiOperation(
      value = "RETORNA TODOS OS BENEFICIÁRIOS CADASTRADOS",
      notes = "Retorna todos os beneficiários cadastrados",
      nickname = "pesquisar"
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Beneficiários retornados com sucesso.", response = Beneficiario.class),
      @ApiResponse(code = 400, message = "Não foi possível retornar os beneficiários.")})
  @GetMapping(value = "/pesquisar", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<?> pesquisar();

  @ApiOperation(
      value = "REALIZA CADASTRO DE BENEFICIÁRIO",
      notes = "Realiza cadastro de beneficiário",
      nickname = "cadastrar"
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Cadastro de beneficiário realizado com sucesso.", response = Beneficiario.class),
      @ApiResponse(code = 400, message = "Não foi possível realizar o cadastro do beneficiário.")})
  @PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<?> cadastrar(@RequestBody Beneficiario beneficiario);
}
