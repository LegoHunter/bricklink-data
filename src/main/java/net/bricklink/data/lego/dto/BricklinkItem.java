package net.bricklink.data.lego.dto;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class BricklinkItem {
    private int itemId;
    private int blItemId;
    private String blItemNumber;
}
