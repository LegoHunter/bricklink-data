package net.bricklink.data.lego.dao;

import net.bricklink.data.lego.dto.Item;
import net.bricklink.data.lego.ibatis.configuration.MybatisConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import({ItemDao.class, InventoryIndexDao.class, MybatisConfiguration.class})
class ItemDaoTest {

    @Autowired
    ItemDao itemDao;

    @Test
    @Sql(scripts = {"/scripts/db/h2/item_schema.ddl", "/scripts/db/h2/truncate-table-item.sql"})
    void findItemById() {
        Item item = new Item();
        item.setItemNumber("1234");
        item.setItemName("Test Item");
        itemDao.insertItem(item);
        assertThat(item.getItemId()).isEqualTo(1);

        item = new Item();
        item.setItemNumber("5678");
        item.setItemName("Test Item 2");
        itemDao.insertItem(item);
        assertThat(item.getItemId()).isEqualTo(2);
    }

    @EnableAutoConfiguration
    @Configuration
    @PropertySource("application.properties")
    static class DaoConfiguration {
    }
}