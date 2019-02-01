package net.bricklink.data.lego.dao;

import lombok.RequiredArgsConstructor;
import net.bricklink.data.lego.dto.InventoryIndex;
import net.bricklink.data.lego.ibatis.mapper.InventoryIndexMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryIndexDao {
    private final InventoryIndexMapper inventoryIndexMapper;

    public List<InventoryIndex> getAll() {
        return inventoryIndexMapper.getAll();
    }

    public List<InventoryIndex> getAllWithNoItem() {
        return inventoryIndexMapper.getAllWithNoItem();
    }

    public void insertInventoryIndex(InventoryIndex inventoryIndex) {
        inventoryIndexMapper.insertInventoryIndex(inventoryIndex);
    }

    public void udpateInventoryIndex(InventoryIndex inventoryIndex) {
        inventoryIndexMapper.udpateInventoryIndex(inventoryIndex);
    }
}
