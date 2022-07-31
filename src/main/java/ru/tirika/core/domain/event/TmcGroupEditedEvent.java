package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.TmcGroup;

@AllArgsConstructor
public class TmcGroupEditedEvent implements DomainEvent {
    private final TmcGroup oldTmcGroup;
    private final TmcGroup newTmcGroup;
}
