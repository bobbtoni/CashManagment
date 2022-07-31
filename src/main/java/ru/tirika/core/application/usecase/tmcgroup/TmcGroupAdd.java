package ru.tirika.core.application.usecase.tmcgroup;

import ru.tirika.core.application.model.AddTmcGroupCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.TmcGroup;

public interface TmcGroupAdd extends UseCase<AddTmcGroupCommand, TmcGroup> {
}
