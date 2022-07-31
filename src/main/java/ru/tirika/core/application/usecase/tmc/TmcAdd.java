package ru.tirika.core.application.usecase.tmc;

import ru.tirika.core.application.model.AddTmcCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.Tmc;

public interface TmcAdd extends UseCase<AddTmcCommand, Tmc> {
}
