package ru.tirika.core.domain.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TmcFetchedEvent implements DomainEvent {
    private final LocalDateTime fetchedDateTime;
    private final long countRecords;
}
