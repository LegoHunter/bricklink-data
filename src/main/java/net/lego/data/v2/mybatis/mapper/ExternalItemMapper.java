package net.lego.data.v2.mybatis.mapper;

import net.lego.data.v2.dto.ExternalItem;
import net.lego.data.v2.dto.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

public interface ExternalItemMapper {
    @Select("""
          SELECT external_item_id, external_number, external_unique_id, external_name, external_item_type, external_url, external_service_id \
          FROM external_item \
          WHERE external_item_id = #{externalItemId} \
          """)
    @ResultMap("externalItemResultMap")
    Optional<ExternalItem> findByExternalItemId(Integer externalItemId);

    @Select("""
          SELECT external_item_id, external_number, external_unique_id, external_name, external_item_type, external_url, external_service_id \
          FROM external_item \
          WHERE external_unique_id = #{externalUniqueId} \
          """)
    @ResultMap("externalItemResultMap")
    Optional<ExternalItem> findByExternalUniqueId(Integer externalUniqueId);

    @Select("""
          SELECT external_item_id, external_number, external_unique_id, external_name, external_item_type, external_url, external_service_id \
          FROM external_item \
          WHERE external_number = #{externalNumber} \
          """)
    @ResultMap("externalItemResultMap")
    Optional<ExternalItem> findByExternalNumber(String externalNumber);

    @Insert("""
            INSERT INTO external_item (external_number, external_unique_id, external_name, external_item_type, external_url, external_service_id) \
            VALUES (#{externalNumber}, #{externalUniqueId}, #{externalName}, #{externalItemType}, #{externalUrl}, #{externalServiceId}) \
            """)
    @Options(useGeneratedKeys = true, keyProperty = "externalItemId")
    void insert(ExternalItem externalItem);

    @Update("""
          UPDATE external_item
          SET external_number = #{externalNumber}, \
              external_unique_id = #{externalUniqueId}, \
              external_name = #{externalName}, \
              external_item_type = #{externalItemType}, \
              external_url = #{externalUrl} \
          WHERE external_item_id = #{externalItemId} \
          """)
    void update(ExternalItem externalItem);
}
