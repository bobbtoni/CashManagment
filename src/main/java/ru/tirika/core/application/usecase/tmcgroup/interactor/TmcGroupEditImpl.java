package ru.tirika.core.application.usecase.tmcgroup.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.EditTmcGroupCommand;
import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupEdit;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.domain.event.TmcGroupEditedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGroupEditImpl implements TmcGroupEdit {

    private final TmcGroupPort tmcGroupPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGroupEditImpl(TmcGroupPort tmcGroupPort, EventManager eventManager) {
        this.tmcGroupPort = tmcGroupPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<TmcGroup> execute(EditTmcGroupCommand data) {
        final TmcGroup tmcGroup = tmcGroupPort.findObject(data.getId());
        final String name;
        if (data.getName() != null) {
            name = data.getName();
        } else {
            name = tmcGroup.getName();
        }
        final TmcGroup editedTmcGroup = new TmcGroup(tmcGroup.getId(), name);
        final TmcGroup savedTmcGroup = tmcGroupPort.saveObject(editedTmcGroup);
        eventManager.notify(new TmcGroupEditedEvent(tmcGroup, savedTmcGroup));
        return ResultExecution.ok(savedTmcGroup);
    }

}
