package com.ucinae.root.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash("inventory")
public class Inventory implements Serializable {

    @Id
    private Integer filmId;
    private List<Integer> storeIds;
    private LocalDateTime refreshTime;

    @Builder
    public Inventory(Integer filmId, List<Integer> storeIds, LocalDateTime refreshTime) {
        this.filmId = filmId;
        this.storeIds = storeIds;
        this.refreshTime = refreshTime;
    }
}
