package ru.tirika.core.application.usecase.tmcgroup.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.port.TmcGroupPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmcgroup.TmcGroupRemove;
import ru.tirika.core.domain.entity.TmcGroup;
import ru.tirika.core.domain.event.TmcGroupRemovedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcGroupRemoveImpl implements TmcGroupRemove {

    private final TmcGroupPort tmcGroupPort;
    private final EventManager eventManager;

    @Autowired
    public TmcGroupRemoveImpl(TmcGroupPort tmcGroupPort, EventManager eventManager) {
        this.tmcGroupPort = tmcGroupPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Boolean> execute(Long id) {
        final ResultExecution<Boolean> resultExecution;
        final TmcGroup deletedTmcGroup = tmcGroupPort.dropObject(id);
        if (deletedTmcGroup == null) {
            resultExecution = ResultExecution.fail("Not Found");
        } else {
            resultExecution = ResultExecution.ok(true);
            eventManager.notify(new TmcGroupRemovedEvent(deletedTmcGroup));
        }
        return resultExecution;
    }

}
