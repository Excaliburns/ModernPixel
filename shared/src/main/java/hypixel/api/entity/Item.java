package hypixel.api.entity;

import lombok.Data;

@Data
public class Item {
    public String material;
    public int durability;
    public String skin;
    public String name;
    public String category;
    public String tier;
    public double npc_sell_price;
    public String id;
}
