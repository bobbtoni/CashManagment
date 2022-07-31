package ru.tirika.core.application.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EditTmcCommand {
    private final Long idTmc;
    private final String newName;
    private final BigDecimal newPrice;
}
