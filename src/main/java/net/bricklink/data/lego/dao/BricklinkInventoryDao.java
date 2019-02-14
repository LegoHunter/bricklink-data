package net.bricklink.data.lego.dao;

import lombok.RequiredArgsConstructor;
import net.bricklink.data.lego.dto.BricklinkInventory;
import net.bricklink.data.lego.ibatis.mapper.BricklinkInventoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BricklinkInventoryDao {
    private final BricklinkInventoryMapper bricklinkInventoryMapper;

    public List<BricklinkInventory> getAllInventoryWork() {
        return bricklinkInventoryMapper.getAllInventoryWork();
    }

    public List<BricklinkInventory> getInventoryWork() {
        return bricklinkInventoryMapper.getInventoryWork();
    }
}
