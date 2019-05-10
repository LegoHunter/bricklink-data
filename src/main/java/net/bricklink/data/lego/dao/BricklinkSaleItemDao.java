package net.bricklink.data.lego.dao;

import lombok.RequiredArgsConstructor;
import net.bricklink.data.lego.dto.BricklinkSaleItem;
import net.bricklink.data.lego.ibatis.mapper.BricklinkSaleItemMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BricklinkSaleItemDao {
    private final BricklinkSaleItemMapper bricklinkSaleItemMapper;

    public Integer upsert(BricklinkSaleItem bricklinkSaleItem) {
        return bricklinkSaleItemMapper.upsert(bricklinkSaleItem);
    }
}
