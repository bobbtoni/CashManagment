package ru.tirika.core.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditTmcGroupCommand {
    private final Long id;
    private final String name;
}
