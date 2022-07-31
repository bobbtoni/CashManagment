package ru.tirika.core.domain.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TmcGroupFetchedEvent implements DomainEvent {
    private final LocalDateTime fetchedTime;
    private final long countRecords;
}
