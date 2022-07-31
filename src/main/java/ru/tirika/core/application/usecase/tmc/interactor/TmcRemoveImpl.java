package ru.tirika.core.application.usecase.tmc.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tirika.core.application.port.TmcPort;
import ru.tirika.core.application.usecase.ResultExecution;
import ru.tirika.core.application.usecase.tmc.TmcRemove;
import ru.tirika.core.domain.event.TmcRemovedEvent;
import ru.tirika.core.shared.event.EventManager;

@Service
public class TmcRemoveImpl implements TmcRemove {

    private final TmcPort tmcPort;
    private final EventManager eventManager;

    @Autowired
    public TmcRemoveImpl(TmcPort tmcPort, EventManager eventManager) {
        this.tmcPort = tmcPort;
        this.eventManager = eventManager;
    }

    @Override
    public ResultExecution<Boolean> execute(Long id) {
        tmcPort.dropObject(id);

        eventManager.notify(new TmcRemovedEvent(id));
        return ResultExecution.ok(true);
    }

}
