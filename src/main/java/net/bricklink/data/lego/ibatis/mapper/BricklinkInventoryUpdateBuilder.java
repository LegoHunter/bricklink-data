package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.BricklinkInventory;
import org.apache.ibatis.jdbc.SQL;

import java.util.Optional;

public class BricklinkInventoryUpdateBuilder {
    public String updateBricklinkInventoryByUuidAndBlItemNumber(BricklinkInventory bricklinkInventory) {
        return new SQL() {{
            UPDATE("bricklink_inventory bi");
            Optional.ofNullable(bricklinkInventory.getBoxConditionCode())
                    .ifPresent(s -> SET("bi.box_condition_id = coalesce((select c.condition_id from `condition` c where c.condition_code = upper(#{boxConditionCode})),bi.box_condition_id)"));
            Optional.ofNullable(bricklinkInventory.getInstructionsConditionCode())
                    .ifPresent(s -> SET("bi.instructions_condition_id = coalesce((select c.condition_id from `condition` c where c.condition_code = upper(#{instructionsConditionCode})),bi.instructions_condition_id)"));
            Optional.ofNullable(bricklinkInventory.getBuiltOnce())
                    .ifPresent(s -> SET("bi.built_once = #{builtOnce}"));
            Optional.ofNullable(bricklinkInventory.getSealed())
                    .ifPresent(s -> SET("bi.sealed = #{sealed}"));
            SET("color_id = bi.color_id");
            WHERE("color_id = bi.color_id");
            WHERE("bi.uuid = #{uuid}");
            WHERE("bi.bl_item_number = #{blItemNo}");
        }}.toString();
    }
}
