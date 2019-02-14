package net.bricklink.data.lego.dto;

import org.junit.Test;

import java.time.Instant;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

public class BricklinkInventoryTest {

    @Test
    public void shouldSynchronize_withNullLastSynchronizedAndNullLastUpdate_isTrue() {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        assertThat(bricklinkInventory.shouldSynchronize()).isTrue();
    }

    @Test
    public void shouldSynchronize_withNullLastSynchronizedAndNonNullLastUpdate_isTrue() {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        bricklinkInventory.setUpdateTimestamp(Instant.now());
        assertThat(bricklinkInventory.shouldSynchronize()).isTrue();
    }

    @Test
    public void shouldSynchronize_withNonNullLastSynchronizedAndNullLastUpdate_isTrue() {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        bricklinkInventory.setLastSynchronizedTimestamp(Instant.now());
        assertThat(bricklinkInventory.shouldSynchronize()).isTrue();
    }

    @Test
    public void shouldSynchronize_withLastSynchronizedBeforeLastUpdate_isTrue() {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        Instant now = Instant.now();
        bricklinkInventory.setUpdateTimestamp(now);
        bricklinkInventory.setLastSynchronizedTimestamp(now.minus(Period.ofDays(10)));
        assertThat(bricklinkInventory.shouldSynchronize()).isTrue();
    }

    @Test
    public void shouldSynchronize_withLastSynchronizedAfterLastUpdate_isTrue() {
        BricklinkInventory bricklinkInventory = new BricklinkInventory();
        Instant now = Instant.now();
        bricklinkInventory.setUpdateTimestamp(now);
        bricklinkInventory.setLastSynchronizedTimestamp(now.plus(Period.ofDays(10)));
        assertThat(bricklinkInventory.shouldSynchronize()).isFalse();
    }
}