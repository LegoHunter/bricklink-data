package net.lego.data.v2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalServiceItem {
    private Integer externalItemId;
    private Integer itemId;
}
