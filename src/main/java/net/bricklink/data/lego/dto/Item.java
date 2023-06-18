package net.bricklink.data.lego.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Item {
    private int itemId;
    private String itemNumber;
    private String itemName;
    private Integer numberOfPieces;
    private Integer issueYear;
    private String issueLocation;
    private Integer themeId;
    private String itemTypeCode;
    private String notes;
    private BricklinkItem brickLinkItem;
}
