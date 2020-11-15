package com.ucinae.root.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@ToString
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // serialize 시에 "variety":{"name":"Chinchilla","weight":8} 이렇게 변환
public enum RabbitVariety {
    ALASKAN("Alaskan", 6),
    AMERICAN("American", 7),
    CHINCHILLA("Chinchilla", 8),
    ANGORA("Angora", 4),
    CINNAMON("Cinnamon", 5),
    DUTCH("Dutch", 3)
    ;

    private final String name;
    private final Integer weight;

    @JsonCreator // deserialize 시에 variety=RabbitVariety.CHINCHILLA(name=Chinchilla, weight=8)) 이렇게 변환
    public static RabbitVariety fromJson(@JsonProperty("name") String name) {
        for (RabbitVariety r : RabbitVariety.values()) {
            if (StringUtils.equalsIgnoreCase(r.name, name)) {
                return r;
            }
        }
        return null;
    }
}
