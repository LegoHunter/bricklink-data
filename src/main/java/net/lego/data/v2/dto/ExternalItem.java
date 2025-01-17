package net.lego.data.v2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
