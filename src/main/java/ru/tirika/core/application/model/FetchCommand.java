package ru.tirika.core.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FetchCommand {
    private final long offset;
    private final long limit;
}
