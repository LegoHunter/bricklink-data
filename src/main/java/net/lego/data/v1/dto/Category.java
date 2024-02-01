package net.lego.data.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private Long categoryId;
    private String categoryType;
    private String categoryName;
}
