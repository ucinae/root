package com.ucinae.root.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "rest app open api doc", description = "API DOC", version = "v1", contact = @Contact(name = "ucinae", email = "test@test.com"))
)
@Configuration
public class OpenApiConfig {

    public GroupedOpenApi openApi() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder().group("all rest api").pathsToMatch().build();
    }
}
