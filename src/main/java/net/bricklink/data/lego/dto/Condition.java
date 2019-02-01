package net.bricklink.data.lego.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Condition {
    private int conditionId;
    private String conditionCode;
    private String conditionDescription;
    private String conditionText;
}
