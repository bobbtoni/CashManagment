package ru.tirika.core.application.usecase.tmcgroup;

import java.util.Collection;

import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.TmcGroup;

public interface TmcGroupFetch extends UseCase<FetchCommand, Collection<TmcGroup>> {

}
