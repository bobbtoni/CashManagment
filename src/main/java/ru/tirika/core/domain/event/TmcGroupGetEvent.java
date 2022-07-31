package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.TmcGroup;

@AllArgsConstructor
public class TmcGroupGetEvent implements DomainEvent {
    private final TmcGroup tmcGroup;
}
