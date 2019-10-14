package my.learning.springboot.swagger.springbootswagger;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguraton() {
		return new Docket(DocumentationType.SWAGGER_2).
				select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("my.learning.springboot.swagger"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Address Book API",
				"Sample application for Swagger API",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact("", "http://localhost:8080/swagger-ui.htm",
				""),
				"API License", 
				"http://localhost:8080/swagger-ui.htm",
				Collections.emptyList());
	}
}
