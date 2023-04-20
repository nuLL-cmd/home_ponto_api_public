package br.com.automatodev.homeponto.infrastructure.swagger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Getter
@Setter
@ToString
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "app")
public class SwaggerConfig {
    private String name;

    private String version;

    private String description;

    private String organization;

    private String contextPath;

    @Bean
    public Docket api() {

        SecurityReference securityReference =
                SecurityReference.builder()
                        .reference("basicAuth")
                        .scopes(new AuthorizationScope[0])
                        .build();

        ArrayList<SecurityReference> reference = new ArrayList<>(1);
        reference.add(securityReference);

        ArrayList<SecurityContext> securityContexts = new ArrayList<>(1);
        securityContexts.add(SecurityContext.builder().securityReferences(reference).build());

        ArrayList<SecurityScheme> auth = new ArrayList<>(1);
        auth.add(new BasicAuth("basicAuth"));

        return new Docket(DocumentationType.SWAGGER_2)
                //.securitySchemes(auth)
                .securityContexts(securityContexts)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.automatodev.homeponto"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {

        return new ApiInfo(
                name,
                description,
                version,
                "",
                new Contact(
                        organization, "https://github.com/nuLL-cmd/", "programadormoderador@hotmail.cokm"),
                "Licença Swagger",
                "https://swagger.io/license/",
                Collections.emptyList());
    }
}
