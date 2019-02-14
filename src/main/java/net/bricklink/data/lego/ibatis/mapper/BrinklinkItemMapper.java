package net.bricklink.data.lego.ibatis.mapper;

import net.bricklink.data.lego.dto.BricklinkItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrinklinkItemMapper {
    @Select("SELECT item_id, bricklink_item_id FROM bricklink_item WHERE item_id = #{itemId}")
    BricklinkItem getBricklinkItemForItemId(int itemId);


}
