package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.InventoryIndex;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InventoryIndexMapper {
    @Select("SELECT box_id, box_index, item_number, box_name, box_number, sealed, quantity, description FROM inventory_index")
    @ResultMap("inventoryIndexResultMap")
    List<InventoryIndex> getAll();

    @Select("select box_id, box_index, item_number, box_name, box_number, sealed, quantity, description from inventory_index ii " +
            "where not exists (select 1 from item i where i.item_number = ii.item_number) " +
            "and ii.item_number not in ('no #','') " +
            "and ii.item_number is not null")
    @ResultMap("inventoryIndexResultMap")
    List<InventoryIndex> getAllWithNoItem();

    @Select("SELECT box_id, box_index, item_number, box_name, box_number, sealed, quantity, description FROM inventory_index where box_id = #{boxId}")
    @ResultMap("inventoryIndexResultMap")
    List<InventoryIndex> getAllForBox(int boxId);

    @Insert("INSERT INTO inventory_index(box_id, box_index, item_number, box_name, box_number, sealed, quantity, description) " +
            "VALUES (#{boxId}, #{boxIndex}, #{itemNumber}, #{boxName}, #{boxNumber}, #{sealed}, #{quantity}, #{description})")
    void insertInventoryIndex(InventoryIndex inventoryIndex);

    @Update("UPDATE inventory_index " +
            "SET    sealed = #{sealed}," +
            "       quantity = #{quantity}," +
            "       description = #{description} " +
            "WHERE  boxIndex = #{boxIndex} " +
            "AND    box_number = #{boxNumber} " +
            "AND    itemNumber = #{itemNumber} ")
    void udpateInventoryIndex(InventoryIndex inventoryIndex);
}







