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
public class InventoryIndex {
    private Integer boxId;
    private Integer boxIndex;
    private String itemNumber;
    private String boxName;
    private String boxNumber;
    private String sealed;
    private Integer quantity;
    private String description;
}
