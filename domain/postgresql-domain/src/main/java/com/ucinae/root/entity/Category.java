package com.ucinae.root.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.ZonedDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {
    @Id
    @SequenceGenerator(name = "categorySequenceGenerator", sequenceName = "category_category_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequenceGenerator")
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name")
    private String name;

    @UpdateTimestamp
    @Column(name = "last_update")
    private ZonedDateTime lastUpdate;

    @Builder
    public Category(String name, ZonedDateTime lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
}
