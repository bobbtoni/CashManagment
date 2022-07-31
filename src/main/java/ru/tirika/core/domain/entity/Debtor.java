package ru.tirika.core.domain.entity;

import java.util.Collection;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.value.FullName;

@AllArgsConstructor
public class Debtor {
    private final FullName fullName;
    private final Collection<Debt> debts;
}
