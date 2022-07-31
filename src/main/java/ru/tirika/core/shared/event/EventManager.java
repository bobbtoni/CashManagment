package ru.tirika.core.shared.event;

import ru.tirika.core.domain.event.DomainEvent;

public interface EventManager {

    <T extends DomainEvent> void notify(T event);

    <T extends DomainEvent> void subscribe(Listener<T> listener);

}
