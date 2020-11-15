package com.ucinae.root.controller;

import com.ucinae.root.dto.RabbitDto;
import com.ucinae.root.model.RabbitVariety;
import com.ucinae.root.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class RabbitController {
    private final RabbitService rabbitService;

    @GetMapping("/rabbit/sample/{age}")
    public String produceSample(@PathVariable Integer age) {
        RabbitDto rabbitDto = RabbitDto.builder()
                .name("rabbit")
                .variety(RabbitVariety.CHINCHILLA)
                .age(age)
                .birth(new Date())
                .build();

        rabbitService.produce(rabbitDto);

        return "success";
    }
}
