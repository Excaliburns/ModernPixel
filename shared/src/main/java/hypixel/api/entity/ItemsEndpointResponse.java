package hypixel.api.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ItemsEndpointResponse {
    boolean success;
    LocalDateTime lastUpdated;
    List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}
