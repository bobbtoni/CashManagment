package ru.tirika.core.application.usecase.tmcgroup;

import ru.tirika.core.application.model.EditTmcGroupCommand;
import ru.tirika.core.application.usecase.UseCase;
import ru.tirika.core.domain.entity.TmcGroup;

public interface TmcGroupEdit extends UseCase<EditTmcGroupCommand, TmcGroup> {

}
