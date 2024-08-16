package net.lego.data.v2.mybatis.mapper;

import net.lego.data.v2.dto.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface ItemMapper {
    @Select("""
          SELECT item_id, \
                 item_number, \
                 item_name, \
                 notes, \
                 category_id \
          FROM item \
          """)
    @ResultMap("itemResultMap")
    List<Item> findAll();

    @Select("""
          SELECT item_id, \
                 item_number, \
                 item_name, \
                 notes, \
                 category_id \
          FROM item \
          WHERE item_id = #{itemId} \
            """)
    @ResultMap("itemResultMap")
    Optional<Item> findByItemId(Integer itemId);

    @Insert("""
            INSERT INTO item (item_id, item_number, item_name, notes, category_id) \
            VALUES (#{itemId}, #{itemNumber}, #{itemName}, #{notes}, #{categoryId}) \
            """)
    @Options(useGeneratedKeys = false, keyProperty = "itemId")
    void insert(Item item);

    @Update("""
          UPDATE item
          SET item_number = #{itemNumber}, \
              item_name = #{itemName}, \
              notes = #{notes}, \
              category_id = #{categoryId} \
          WHERE item_id = #{itemId} \
          """)
    void update(Item item);
}
