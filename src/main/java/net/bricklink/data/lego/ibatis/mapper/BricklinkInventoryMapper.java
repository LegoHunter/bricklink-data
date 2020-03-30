package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.BricklinkInventory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

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
            "bi.for_sale," +
            "bi.fixed_price," +
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
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE bi.inventory_id = #{inventoryId}")
    @ResultMap("bricklinkInventoryWorkResultMap")
    BricklinkInventory getByInventoryId(Long inventoryId);

    @Select("SELECT " + INVENTORY_COLUMNS + " " +
            "FROM bricklink_inventory bi " +
            "JOIN bricklink_item bli ON bi.bl_item_number = bli.bl_item_number " +
            "JOIN item i ON i.item_id = bli.item_id " +
            "WHERE bi.box_id = #{boxId} " +
            "AND   bi.box_index = #{boxIndex}")
    @ResultMap("bricklinkInventoryWorkResultMap")
    Optional<BricklinkInventory> findByBoxIdAndBoxIndex(Integer boxId, Integer boxIndex);

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
                "AND bi.item_type IN ('SET','GEAR') " +
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
            "remarks = #{uuid}," +
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

    @Update("UPDATE bricklink_inventory SET " +
            "order_id = #{orderId} " +
            "WHERE bl_inventory_id = #{blInventoryId}")
    void updateOrder(@Param("blInventoryId") Integer blInventoryId, @Param("orderId") String orderId);

    @Insert("insert into bricklink_inventory (uuid, box_id, box_index, bl_item_number, inventory_id, item_type, color_id, color_name,\n" +
            "                                 quantity, new_or_used, completeness, unit_price, bind_id, description, remarks, bulk,\n" +
            "                                 is_retain, is_stock_room, stock_room_id, my_cost, sale_rate, tier_quantity1,\n" +
            "                                 tier_quantity2, tier_quantity3, tier_price1, tier_price2, tier_price3, my_weight,\n" +
            "                                 sealed, order_id, fixed_price, for_sale, built_once, box_condition_id,\n" +
            "                                 instructions_condition_id, internal_comments, extended_description, extra_description)\n" +
            "select md5(concat(#{boxId}, #{boxIndex}, #{blItemNo}))  uuid,\n" +
            "       #{boxId}                    box_id,\n" +
            "       #{boxIndex}                 box_index,\n" +
            "       #{blItemNo},\n" +
            "       null                       inventory_id,\n" +
            "       'SET'                      item_type,\n" +
            "       0                          color_id,\n" +
            "       null                       color_name,\n" +
            "       1                          quantity,\n" +
            "       'U'               new_or_used,\n" +
            "       'C'              completeness,\n" +
            "       0.00                       unit_price,\n" +
            "       null                       bind_id,\n" +
            "       'Contact me for photos!'   description,\n" +
            "       md5(concat(#{boxId}, #{boxIndex}, #{blItemNo})) remarks,\n" +
            "       1                          bulk,\n" +
            "       1                          is_retain,\n" +
            "       1                          is_stock_room,\n" +
            "       'A'                        stock_room_id,\n" +
            "       0.00                       my_cost,\n" +
            "       null                       sale_rate,\n" +
            "       null                       tier_quantity1,\n" +
            "       null                       tier_quantity2,\n" +
            "       null                       tier_quantity3,\n" +
            "       null                       tier_price1,\n" +
            "       null                       tier_price2,\n" +
            "       null                       tier_price3,\n" +
            "       null                       my_weight,\n" +
            "       0                          sealed,\n" +
            "       null                       order_id,\n" +
            "       0                          fixed_price,\n" +
            "       1                          for_sale,\n" +
            "       1                          built_once,\n" +
            "       null                       box_condition_id,\n" +
            "       null                       instructions_condition_id,\n" +
            "       null                       internal_comments,\n" +
            "       null                       extended_description,\n" +
            "       null                       extra_description\n" +
            "from inventory_index ii\n" +
            "where ii.box_id = #{boxId}\n" +
            "  and ii.box_index = #{boxIndex}\n" +
            "  and not exists(select 1 from bricklink_inventory bi where bi.box_id = #{boxId} and bi.box_index = #{boxIndex})")
    void insert(BricklinkInventory bricklinkInventory);
}

















