package ru.tirika.core.application.usecase.tmcgroup.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.model.AddTmcGroupCommand;
import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupAdd;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.domain.event.TmcGroupAddedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGroupAddImpl implements TmcGroupAdd {

    private final TmcGroupPort tmcGroupPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGroupAddImpl(TmcGroupPort tmcGroupPort, EventManager eventManager) {
        this.tmcGroupPort = tmcGroupPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<TmcGroup> execute(AddTmcGroupCommand data) {
        final TmcGroup tmcGroup = new TmcGroup(null, data.getName());
        final TmcGroup savedTmcGroup = tmcGroupPort.saveObject(tmcGroup);
        eventManager.notify(new TmcGroupAddedEvent(data.getParentId(), savedTmcGroup));
        return ResultExecution.ok(savedTmcGroup);
    }

}
