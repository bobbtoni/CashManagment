package ru.tirika.core.application.port;

import ru.tirika.core.domain.entity.TmcGroup;

public interface TmcGroupPort extends CrudPort<TmcGroup, Long> {
    TmcGroup saveChildGroup(TmcGroup tmcGroup, Long parentGroupid);
}
