package br.com.previdenciavirtualapi.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Value("${swagger.titulo}")
	private String titulo;

	@Value("${swagger.descricao}")
	private String descricao;

	@Value("${swagger.licenca}")
	private String licenca;

	@Bean
	public Docket docketConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().pathMapping("/").directModelSubstitute(Calendar.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, globalResponses())
				.globalResponseMessage(RequestMethod.POST, globalResponses())
				.globalResponseMessage(RequestMethod.PUT, globalResponses())
				.globalResponseMessage(RequestMethod.PATCH, globalResponses())
				.globalResponseMessage(RequestMethod.DELETE, globalResponses())
				.apiInfo(apiInfo().build());
	}

	private List<ResponseMessage> globalResponses() {
		return asList(new ResponseMessageBuilder().code(400).message("Requisição inválida.").build(),
				new ResponseMessageBuilder().code(500).message("Erro interno no servidor.").build());
	}

	// http://localhost:8080/wsamazons3/v1/swagger-ui.html
	private ApiInfoBuilder apiInfo() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title(titulo);
		apiInfoBuilder.description(descricao);
		apiInfoBuilder.license(licenca);

		return apiInfoBuilder;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().displayOperationId(true).operationsSorter(OperationsSorter.ALPHA)
				.tagsSorter(TagsSorter.ALPHA).build();
	}

}
