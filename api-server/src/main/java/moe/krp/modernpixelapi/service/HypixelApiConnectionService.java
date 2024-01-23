package moe.krp.modernpixelapi.service;

import hypixel.api.entity.Item;
import hypixel.api.entity.ItemsEndpointResponse;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class HypixelApiConnectionService {
    final static Logger logger = LogManager.getLogger();
    private String API_KEY;
    private final WebClient client;
    final static String HYPIXEL_API_URL = "https://api.hypixel.net/";

    public HypixelApiConnectionService(
            final String apiKey
    ) {
        this.API_KEY = apiKey;
        this.client = WebClient.builder()
                .defaultHeader("API-Key", API_KEY)
                .baseUrl(HYPIXEL_API_URL)
                .codecs( clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
                .build();
    }
    @PostConstruct
    public void init() {
        List<Item> items = getItemsFromHypixelApi();
        logger.info(items);
    }

    public List<Item> getItemsFromHypixelApi() {
        return client.get()
                                  .uri("v2/resources/skyblock/items").accept(MediaType.APPLICATION_JSON)
                                  .retrieve()
                                  .bodyToMono(ItemsEndpointResponse.class)
                .block()
                .getItems();
    }

}
