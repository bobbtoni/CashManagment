package ru.tirika.core.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddTmcGroupCommand {
    private final Long parentId;
    private final String name;
}
