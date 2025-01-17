package net.lego.data.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Condition {
    private Integer conditionId;
    private String conditionCode;
    private String conditionDescription;
    private String conditionText;
}
