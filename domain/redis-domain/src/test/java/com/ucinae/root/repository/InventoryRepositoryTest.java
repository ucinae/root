package com.ucinae.root.repository;

import com.ucinae.root.RedisTests;
import com.ucinae.root.entity.Inventory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@Slf4j
@SpringBootTest
class InventoryRepositoryTest extends RedisTests {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void redisOperationTest() {
        // given
        Integer filmId = 0;
        LocalDateTime refreshTime = LocalDateTime.now();
        List<Integer> storeIds = List.of(1, 2, 3);
        Inventory expectedInventory = Inventory.builder()
                .filmId(filmId)
                .storeIds(storeIds)
                .refreshTime(refreshTime)
                .build();

        // when
        inventoryRepository.save(expectedInventory);

        // then
        Inventory actualInventory = inventoryRepository.findById(filmId.toString()).get();
        log.info("actual inventory = {}", actualInventory);

        then(actualInventory.getFilmId()).isEqualTo(expectedInventory.getFilmId());
        inventoryRepository.delete(actualInventory);
    }
}