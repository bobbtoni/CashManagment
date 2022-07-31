package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.Tmc;

@AllArgsConstructor
public class TmcAddedEvent implements DomainEvent {
    private final Tmc newTmc;
}
