package com.ucinae.root.repository;

import com.ucinae.root.PostgresqlTests;
import com.ucinae.root.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@Slf4j
@SpringBootTest
class CategoryRepositoryTest extends PostgresqlTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void contextLoads() {
        assertThat(categoryRepository).isNotNull();
    }

    @Test
    public void getCategoryTest() {
        // given

        // when
        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            log.info("category = {}", category);
        }

        // then
        then(categories).isNotNull();
        then(categories.size()).isNotZero();
    }
}