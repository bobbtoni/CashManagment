package ru.tirika.core.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tmc {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final BigDecimal remainCount;
    private final Long idGroup;
}
