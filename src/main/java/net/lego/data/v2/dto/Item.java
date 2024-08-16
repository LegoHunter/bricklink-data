package net.lego.data.v2.dto;

import lombok.*;

@Data
@Builder
public class Item {
    private int itemId;
    private String itemNumber;
    private String itemName;
    private String notes;
    private Integer categoryId;
}
