package br.com.previdenciavirtualapi.controller;

import br.com.previdenciavirtualapi.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"DOCUMENTO"})
@CrossOrigin(origins = "*")
@RequestMapping("/documento")
public interface DocumentoController {

  @ApiOperation(
      value = "RETORNA TODOS OS DOCUMENTOS DE UM BENEFICIÁRIO",
      notes = "Retorna todos os documentos de um beneficiário",
      nickname = "pesquisar"
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Documento(s) retornado(s) com sucesso.", response = Documento.class),
      @ApiResponse(code = 400, message = "Não foi possível retornar o(s) documento(s).")})
  @PostMapping(value = "/pesquisar", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<?> pesquisar(@RequestBody Beneficiario beneficiario);

  @ApiOperation(
      value = "SALVA DOCUMENTO DE UM BENEFICIÁRIO",
      notes = "Salva documento de um beneficiário",
      nickname = "salvar"
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Documento(s) retornado(s) com sucesso.", response = Arquivo.class),
      @ApiResponse(code = 400, message = "Não foi possível retornar o(s) documento(s).")})
  @PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<?> salvar(@RequestBody ArquivoRequest request);

  @ApiOperation(
      value = "RETORNA UM DOCUMENTO DE UM BENEFICIÁRIO",
      notes = "Retorna um documento de um beneficiário",
      nickname = "exibir"
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Arquivo retornado com sucesso.", response = Arquivo.class),
      @ApiResponse(code = 400, message = "Não foi possível retornar o documento.")})
  @PostMapping(value = "/exibir", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<?> exibir(@RequestBody BeneficiarioDocumento beneficiarioDocumento);
}
