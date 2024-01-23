package moe.krp.modernpixelapi.config;

import moe.krp.modernpixelapi.service.HypixelApiConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModernPixelApplicationConfig {

    @Bean
    public HypixelApiConnectionService hypixelApiConnectionService(
            @Value("${hypixel.api.key}") final String apiKey
    ) {
        return new HypixelApiConnectionService(apiKey);
    }
}
