package net.bricklink.data.lego.dao;

import net.bricklink.data.lego.dto.BricklinkSaleItem;
import net.bricklink.data.lego.ibatis.mapper.BricklinkSaleItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BricklinkSaleItemDao {
    private final BricklinkSaleItemMapper bricklinkSaleItemMapper;

    public void insert(BricklinkSaleItem bricklinkSaleItem) {
        bricklinkSaleItemMapper.insert(bricklinkSaleItem);
    }
}
