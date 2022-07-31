package ru.tirika.core.shared.event;

import ru.tirika.core.domain.event.DomainEvent;

public interface Listener<T extends DomainEvent> {
    void apply(T event);
}
