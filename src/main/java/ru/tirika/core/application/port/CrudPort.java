package ru.tirika.core.application.port;

import java.util.Collection;

public interface CrudPort<ENTITY, ID> {
    ENTITY saveObject(ENTITY object);

    ENTITY findObject(ID id);

    ENTITY dropObject(ID id);

    Collection<ENTITY> findPartitionalObjects(long offset, long limit);
}
