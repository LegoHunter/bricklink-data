package net.bricklink.data.lego.dao;

import lombok.RequiredArgsConstructor;
import net.bricklink.data.lego.dto.BricklinkSaleItem;
import net.bricklink.data.lego.ibatis.mapper.BricklinkSaleItemMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BricklinkSaleItemDao {
    private final BricklinkSaleItemMapper bricklinkSaleItemMapper;

    public void upsert(BricklinkSaleItem bricklinkSaleItem) {
        bricklinkSaleItemMapper.upsert(bricklinkSaleItem);
    }
}
