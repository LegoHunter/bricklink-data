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

    public List<BricklinkInventory> getAll() {
        return bricklinkInventoryMapper.getAll();
    }

    public List<BricklinkInventory> getAllForSale() {
        return bricklinkInventoryMapper.getAllForSale();
    }

    public List<BricklinkInventory> getInventoryWork(boolean forSale) {
        return bricklinkInventoryMapper.getInventoryWork(forSale);
    }

    public void update(BricklinkInventory bricklinkInventory) {
        bricklinkInventoryMapper.update(bricklinkInventory);
    }

    public BricklinkInventory get(Integer blInventoryId) {
        return bricklinkInventoryMapper.get(blInventoryId);
    }
    public BricklinkInventory getByUuid(String uuid) {
        return bricklinkInventoryMapper.getByUuid(uuid);
    }

    public void setSynchronizedNow(Integer blInventoryId) {
        bricklinkInventoryMapper.setSynchronizedNow(blInventoryId);
    }

    public void setNotForSale(Integer blInventoryId) {
        bricklinkInventoryMapper.setNotForSale(blInventoryId);
    }

    public void setPrice(Integer blInventoryId, double price) {
        bricklinkInventoryMapper.setPrice(blInventoryId, price);
    }

    public void updateFromImageKeywords(BricklinkInventory bricklinkInventory) {
        bricklinkInventoryMapper.updateFromImageKeywords(bricklinkInventory);
    }
}
