package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.TmcGroup;

@AllArgsConstructor
public class TmcGroupRemovedEvent implements DomainEvent {
    private final TmcGroup removedTmcGroup;
}
