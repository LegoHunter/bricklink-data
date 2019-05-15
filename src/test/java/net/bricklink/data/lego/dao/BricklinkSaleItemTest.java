package net.bricklink.data.lego.dao;

import lombok.extern.slf4j.Slf4j;
import net.bricklink.data.lego.dto.BricklinkSaleItem;
import net.bricklink.data.lego.ibatis.configuration.IbatisConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import({BricklinkSaleItemDao.class, IbatisConfiguration.class})
@Slf4j
public class BricklinkSaleItemTest {
    @Autowired
    private BricklinkSaleItemDao bricklinkSaleItemDao;

    @Test
    @Sql(scripts = {"/scripts/db/h2/bricklink_sale_item_schema.ddl",
            "/scripts/db/h2/bricklink_sale_item_data-01.sql"})
    public void updateBricklinkSaleItemSold() {
        List<Integer> currentlyForSaleInventoryIds = new ArrayList<>();
        currentlyForSaleInventoryIds.add(101);
        currentlyForSaleInventoryIds.add(103);
        currentlyForSaleInventoryIds.add(104);
        bricklinkSaleItemDao.updateBricklinkSaleItemSold(5082L, "U", currentlyForSaleInventoryIds);
        List<BricklinkSaleItem> saleItems = bricklinkSaleItemDao.getAll();
        assertThat(saleItems).hasSize(5);
        saleItems.forEach(s -> {
            if (s.getInventoryId().equals(101)) {
                assertThat(s.getStatus()).isEqualTo("C");
            }
            if (s.getInventoryId().equals(102)) {
                assertThat(s.getStatus()).isEqualTo("S");
            }
            if (s.getInventoryId().equals(103)) {
                assertThat(s.getStatus()).isEqualTo("C");
            }
            if (s.getInventoryId().equals(104)) {
                assertThat(s.getStatus()).isEqualTo("C");
            }
            if (s.getInventoryId().equals(105)) {
                assertThat(s.getStatus()).isEqualTo("S");
            }
        });
    }

    @EnableAutoConfiguration
    @Configuration
    @PropertySource("application.properties")
    static class DaoConfiguration {
    }
}
