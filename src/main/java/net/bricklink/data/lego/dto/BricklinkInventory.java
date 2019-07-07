package net.bricklink.data.lego.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class BricklinkInventory {
    private Integer blInventoryId;
    private String uuid;
    private Integer boxId;
    private Integer boxIndex;
    private Integer itemId;
    private String itemName;
    private String itemNumber;
    private Long blItemId;
    private String blItemNo;
    private Long inventoryId;
    private Integer orderId;
    private String itemType;
    private Integer colorId;
    private String colorName;
    private Integer quantity;
    private String newOrUsed;
    private String completeness;
    private Double unitPrice;
    private Integer bindId;
    private String description;
    private String remarks;
    private Integer bulk;
    private Boolean isRetain;
    private Boolean isStockRoom;
    private String stockRoomId;
    private LocalDateTime dateCreated;
    private Double myCost;
    private Integer saleRate;
    private Integer tierQuantity1;
    private Integer tierQuantity2;
    private Integer tierQuantity3;
    private Double tierPrice1;
    private Double tierPrice2;
    private Double tierPrice3;
    private Double myWeight;
    private Boolean sealed;
    private Boolean builtOnce;
    private Boolean forSale;
    private Boolean fixedPrice;
    private Integer boxConditionId;
    private String boxConditionCode;
    private Integer instructionsConditionId;
    private String instructionsConditionCode;
    private String extendedDescription;
    private String extraDescription;
    private String internalComments;
    private Instant updateTimestamp;
    private Instant lastSynchronizedTimestamp;

    public boolean shouldSynchronize() {
        Optional<Instant> lastSynchronizedTimestamp = Optional.ofNullable(getLastSynchronizedTimestamp());
        Optional<Instant> updateTimestamp = Optional.ofNullable(getUpdateTimestamp());
        return (!lastSynchronizedTimestamp.isPresent() || !updateTimestamp.isPresent() || lastSynchronizedTimestamp.get().isBefore(getUpdateTimestamp()));
    }

    public boolean getSealed() {
        return Optional.ofNullable(sealed).orElse(false);
    }

    public void setRemarks(String remarks) {
        this.remarks = this.uuid + "; " + remarks;
    }

    public boolean canBeAvailableForSale() {
        boolean canBeAvailableForSale = true;
        canBeAvailableForSale = canBeAvailableForSale && Optional.ofNullable(this.getForSale()).orElse(false);
        canBeAvailableForSale = canBeAvailableForSale && Optional.ofNullable(this.getInventoryId()).isPresent();
        canBeAvailableForSale = canBeAvailableForSale && Optional.ofNullable(this.getInstructionsConditionId()).isPresent();
        canBeAvailableForSale = canBeAvailableForSale && Optional.ofNullable(this.getBoxConditionId()).isPresent();
        return canBeAvailableForSale;
    }

    public static BricklinkInventory fromKeywords(final Map<String, String> keywords) {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        Optional.ofNullable(keywords.get("uuid"))
                .ifPresent(bricklinkInventory::setUuid);
        Optional.ofNullable(keywords.get("bl"))
                .ifPresent(bricklinkInventory::setBlItemNo);
        Optional.ofNullable(keywords.get("sealed"))
                .ifPresent(v -> bricklinkInventory.setSealed(Boolean.valueOf(v)));
        Optional.ofNullable(keywords.get("bc"))
                .ifPresent(bricklinkInventory::setBoxConditionCode);
        Optional.ofNullable(keywords.get("ic"))
                .ifPresent(bricklinkInventory::setInstructionsConditionCode);
        Optional.ofNullable(keywords.get("bo"))
                .ifPresent(v -> bricklinkInventory.setBuiltOnce(Boolean.valueOf(v)));
        return bricklinkInventory;
    }
}