package ru.tirika.core.application.usecase.tmc;

import ru.tirika.core.application.model.EditTmcCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.Tmc;

public interface TmcEdit extends UseCase<EditTmcCommand, Tmc> {
}
