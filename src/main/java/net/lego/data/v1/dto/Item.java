package net.lego.data.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Long itemId;
    private String itemNumber;
    private String itemName;
    private Integer numberOfPieces;
    private Integer issueYear;
    private String issueLocation;
    private Long themeId;
    private String itemTypeCode;
    private String notes;
}
