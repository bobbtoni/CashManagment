package ru.tirika.core.domain.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TmcOnCredit {
    private final String tmcName;
    private final BigDecimal price;
    private final BigDecimal count;
}
