package net.lego.data.v2.dao;

import lombok.RequiredArgsConstructor;
import net.lego.data.v2.dto.ExternalItem;
import net.lego.data.v2.mybatis.mapper.ExternalItemMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExternalItemDao {

    private final ExternalItemMapper externalItemMapper;

    public Optional<ExternalItem> findByExternalItemId(Integer externalItemId) {
        return externalItemMapper.findByExternalItemId(externalItemId);
    }

    public Optional<ExternalItem> findByItemId(Integer itemId) {
        return externalItemMapper.findByItemId(itemId);
    }

    public Optional<ExternalItem> findByExternalUniqueId(Integer externalUniqueId) {
        return externalItemMapper.findByExternalUniqueId(externalUniqueId);
    }

    public Optional<ExternalItem> findByExternalNumber(String externalNumber) {
        return externalItemMapper.findByExternalNumber(externalNumber);
    }

    public void insert(ExternalItem externalItem) {
        externalItemMapper.insert(externalItem);
    }

    public void update(ExternalItem externalItem) {
        externalItemMapper.update(externalItem);
    }
}
