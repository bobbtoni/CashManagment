package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.Tmc;

@AllArgsConstructor
public class TmcEditedEvent implements DomainEvent {
    private final Tmc oldTmc;
    private final Tmc newTmc;
}
