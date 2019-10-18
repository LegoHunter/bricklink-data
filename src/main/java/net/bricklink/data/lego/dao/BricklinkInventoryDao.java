package net.bricklink.data.lego.dao;

import com.sun.javafx.binding.StringFormatter;
import lombok.RequiredArgsConstructor;
import net.bricklink.data.lego.dto.BricklinkInventory;
import net.bricklink.data.lego.ibatis.mapper.BricklinkInventoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        bricklinkInventory.setRemarks(String.format("Box[%d,%d] %s", bricklinkInventory.getBoxId(), bricklinkInventory.getBoxIndex(), bricklinkInventory.getUuid()));
        Optional.ofNullable(bricklinkInventory.getInternalComments()).ifPresent(ed -> {
            String remarks = String.format(bricklinkInventory.getRemarks() + "; %s", bricklinkInventory.getInternalComments());
            bricklinkInventory.setRemarks(remarks);
        });
        bricklinkInventoryMapper.update(bricklinkInventory);
    }

    public BricklinkInventory get(Integer blInventoryId) {
        return bricklinkInventoryMapper.get(blInventoryId);
    }
    public BricklinkInventory getByUuid(String uuid) {
        return bricklinkInventoryMapper.getByUuid(uuid);
    }
    public Optional<BricklinkInventory> getByInventoryId(Long inventoryId) {
        return Optional.ofNullable(bricklinkInventoryMapper.getByInventoryId(inventoryId));
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

    public void updateOrder(Integer blInventoryId, final String orderId) {
        bricklinkInventoryMapper.updateOrder(blInventoryId, orderId);
    }
}
