package net.lego.data.v2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionPlatform {
    private String transactionPlatformCode;
    private String transactionPlatformName;
}
