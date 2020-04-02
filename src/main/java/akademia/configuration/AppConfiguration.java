package akademia.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

//Profilowanie - nasze środowisko developerskie powinno być takie sam jak środowisko produkcyjne natomiast dbać należy

@Configuration
public class AppConfiguration {

    @Configuration
    @Profile("dev")
    @PropertySource("classpath:config-dev.properties")
    static class Development {
    }

    @Configuration
    @Profile("prod")
    @PropertySource("classpath:config-prod.properties")
    static class Production {
    }
}
