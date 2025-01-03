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
          SELECT ei.external_item_id, ei.external_number, ei.external_unique_id, ei.external_name, ei.external_item_type, ei.external_url, ei.external_service_id, esi.item_id \
          FROM external_item ei \
          JOIN external_service_item esi on ei.external_item_id = esi.external_item_id \
          WHERE esi.item_id = #{itemId} \
          """)
    @ResultMap("externalItemResultMap")
    Optional<ExternalItem> findByItemId(Integer itemId);

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
