package ru.tirika.core.application.usecase.tmc;

import java.util.Collection;

import ru.tirika.core.application.model.FetchCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.Tmc;

public interface TmcFetch extends UseCase<FetchCommand, Collection<Tmc>> {
}
