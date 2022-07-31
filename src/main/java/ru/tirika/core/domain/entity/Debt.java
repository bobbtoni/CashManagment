package ru.tirika.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Debt {
    private final Collection<TmcOnCredit> tmcs;
    private final LocalDateTime date;
}
