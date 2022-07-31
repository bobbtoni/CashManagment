package ru.tirika.core.domain.entity;

import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TmcGroup {
    private final Long id;
    private final String name;
    private final Collection<TmcGroup> tmcGroups = new ArrayList<>();
    private final Collection<Tmc> tmcs = new ArrayList<>();
}
