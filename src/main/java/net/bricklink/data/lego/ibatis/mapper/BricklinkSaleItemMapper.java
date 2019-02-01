package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.BricklinkSaleItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BricklinkSaleItemMapper {
    @Insert("INSERT INTO bricklink_sale_item (bl_item_id, inventory_id, quantity, new_or_used, completeness, unit_price, description, has_extended_description, date_created) " +
            "VALUES (#{blItemId}, #{inventoryId}, #{quantity}, #{newOrUsed}, #{completeness}, #{unitPrice}, #{description}, #{hasExtendedDescription}, #{dateCreated})")
    void insert(BricklinkSaleItem bricklinkSaleItem);
}