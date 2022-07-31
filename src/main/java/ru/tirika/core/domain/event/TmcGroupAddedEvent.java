package ru.tirika.core.domain.event;

import lombok.AllArgsConstructor;
import ru.tirika.core.domain.entity.TmcGroup;

@AllArgsConstructor
public class TmcGroupAddedEvent implements DomainEvent {
    private final Long parentId;
    private final TmcGroup tmcGroup;
}
