package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.BricklinkInventory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BricklinkInventoryMapper {
    String INVENTORY_COLUMNS =
            "bi.bl_inventory_id," +
            "bi.uuid," +
            "bi.inventory_id," +
            "bi.order_id," +
            "bi.box_id," +
            "bi.box_index," +
            "bi.bl_item_number," +
            "i.item_number," +
            "i.item_name," +
            "bli.bl_item_number," +
            "bli.bl_item_id," +
            "bi.item_type," +
            "bi.quantity," +
            "bi.new_or_used," +
            "bi.completeness," +
            "bi.unit_price," +
            "bi.description," +
            "bi.remarks," +
            "bi.bulk," +
            "bi.is_retain," +
            "bi.is_stock_room," +
            "bi.stock_room_id," +
            "bi.date_created," +
            "bi.my_cost," +
            "bi.my_weight," +
            "bi.sealed," +
            "bi.built_once," +
            "bi.box_condition_id," +
            "bi.instructions_condition_id," +
            "bi.internal_comments," +
            "bi.update_timestamp," +
            "bi.last_synchronized_timestamp," +
            "bi.internal_comments," +
            "bi.extended_description," +
            "bi.extra_description ";

    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE bi.bl_inventory_id = #{blInventoryId}")
    @ResultMap("bricklinkInventoryWorkResultMap")
    BricklinkInventory get(Integer blInventoryId);

    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE bi.uuid = #{uuid}")
    @ResultMap("bricklinkInventoryWorkResultMap")
    BricklinkInventory getByUuid(String uuid);

    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id")
    @ResultMap("bricklinkInventoryWorkResultMap")
    List<BricklinkInventory> getAll();


    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE bi.for_sale = true")
    @ResultMap("bricklinkInventoryWorkResultMap")
    List<BricklinkInventory> getAllForSale();

    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE (bi.last_synchronized_timestamp < CURRENT_TIMESTAMP OR bi.last_synchronized_timestamp IS NULL) " +
            "AND bi.item_type = 'SET' " +
            "AND bi.order_id IS NULL " +
            "AND bi.for_sale = #{forSale}")
    @ResultMap("bricklinkInventoryWorkResultMap")
    List<BricklinkInventory> getInventoryWork(boolean forSale);

    @Update("UPDATE bricklink_inventory SET "+
            "inventory_id = #{inventoryId}," +
            "order_id = #{orderId}," +
            "quantity = #{quantity}," +
            "new_or_used = #{newOrUsed}," +
            "completeness = #{completeness}," +
            "unit_price = #{unitPrice}," +
            "description = #{description}," +
            "remarks = #{remarks}," +
            "is_stock_room = #{isStockRoom}," +
            "stock_room_id = #{stockRoomId}," +
            "date_created = #{dateCreated}," +
            "my_cost = #{myCost}," +
            "my_weight = #{myWeight}," +
            "sealed = #{sealed}," +
            "built_once = #{builtOnce}," +
            "box_condition_id = #{boxConditionId}," +
            "instructions_condition_id = #{instructionsConditionId}," +
            "internal_comments = #{internalComments}," +
            "last_synchronized_timestamp = #{lastSynchronizedTimestamp} " +
            "WHERE bl_inventory_id = #{blInventoryId}")
    void update(BricklinkInventory bricklinkInventory);

    @Update("UPDATE bricklink_inventory SET "+
            "last_synchronized_timestamp = CURRENT_TIMESTAMP " +
            "WHERE bl_inventory_id = #{blInventoryId}")
    void setSynchronizedNow(Integer blInventoryId);

    @Update("UPDATE bricklink_inventory SET " +
            "for_sale = false " +
            "WHERE bl_inventory_id = #{blInventoryId}")
    void setNotForSale(Integer blInventoryId);

    @Update("UPDATE bricklink_inventory SET " +
            "unit_price = #{unitPrice} " +
            "WHERE bl_inventory_id = #{blInventoryId} " +
            "AND fixed_price = false")
    void setPrice(@Param("blInventoryId") Integer blInventoryId, @Param("unitPrice") double unitPrice);

    @UpdateProvider(type=BricklinkInventoryUpdateBuilder.class, method="updateBricklinkInventoryByUuidAndBlItemNumber")
    void updateFromImageKeywords(BricklinkInventory bricklinkInventory);
}

















