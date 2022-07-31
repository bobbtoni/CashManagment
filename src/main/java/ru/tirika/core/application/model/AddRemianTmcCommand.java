package ru.tirika.core.application.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddRemianTmcCommand {
    private final Long idTmc;
    private final BigDecimal remainedCount;
}
