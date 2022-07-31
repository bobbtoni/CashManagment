package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TmcRemovedEvent implements DomainEvent {
    private final Long idRemovedTmc;
}
