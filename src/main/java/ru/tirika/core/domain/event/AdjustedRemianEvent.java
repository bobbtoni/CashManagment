package ru.tirika.core.domain.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdjustedRemianEvent implements DomainEvent {
    public final Long idTmc;
    public final BigDecimal newCount;
}
