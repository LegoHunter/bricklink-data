package net.lego.data.v2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalItem {
    private Integer externalItemId;
    private String externalNumber;
    private Long externalUniqueId;
    private String externalItemType;
    private String externalName;
    private String externalUrl;
    private Integer externalServiceId;
    private ExternalServiceItem externalServiceItem;
}
