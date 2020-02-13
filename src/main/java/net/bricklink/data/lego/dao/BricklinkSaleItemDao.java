package net.bricklink.data.lego.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bricklink.data.lego.dto.BricklinkSaleItem;
import net.bricklink.data.lego.ibatis.mapper.BricklinkSaleItemMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BricklinkSaleItemDao {
    private final BricklinkSaleItemMapper bricklinkSaleItemMapper;

    public Integer upsert(BricklinkSaleItem bricklinkSaleItem) {
        return bricklinkSaleItemMapper.upsert(bricklinkSaleItem);
    }

    public void updateBricklinkSaleItemSold(Long blItemId, String newOrUsed, List<Integer> currentlyForSaleInventoryIds) {
        if (currentlyForSaleInventoryIds.isEmpty()) {
            log.debug("No items currently for sale for [{}] new/Used [{}]", blItemId, newOrUsed);
        } else {
            bricklinkSaleItemMapper.updateBricklinkSaleItemSold(blItemId, newOrUsed, currentlyForSaleInventoryIds);
        }
    }

    public List<BricklinkSaleItem> getPricesForItem(Long blItemId, String newOrUsed, String completeness) {
        return bricklinkSaleItemMapper.getPricesForItem(blItemId, newOrUsed, completeness);
    }

    public List<BricklinkSaleItem> getAll() {
        return bricklinkSaleItemMapper.getAll();
    }
}
