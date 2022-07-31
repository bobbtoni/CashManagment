package ru.tirika.core.application.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddTmcCommand {
    private final Long idTmcGroup;
    private final String tmcName;
    private final BigDecimal price;
}
